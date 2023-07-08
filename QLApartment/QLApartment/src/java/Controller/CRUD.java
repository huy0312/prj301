/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Home;
import model.Service;
import model.Customers;
import model.Apartment;
import model.Invoice;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author 84915
 */
@WebServlet(name = "CRUD", urlPatterns = {"/CRUD"})
public class CRUD extends BaseAuthController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("id");
            String type = request.getParameter("type");
            String manage = request.getParameter("manage");
            Account acc = (Account) request.getSession().getAttribute("Account");
            ArrayList<Apartment> data = (ArrayList<Apartment>) request.getSession().getAttribute("ApaList");
            switch (manage) {
                case "Apartment":
                    switch (type) {
                        case "del":
                            DAO.Home.DeleteSQL("DELETE FROM Apartment WHERE idPhong=" + id);
                            for (Apartment apartment : data) {
                                if((apartment.getIdPhong() + "").equals(id)) {
                                    data.remove(apartment);
                                    break;
                                }
                            }
                            response.sendRedirect("QLCanHo.jsp");
                            break;
                        case "edit":
                            request.setAttribute("type", "edit");
                            request.setAttribute("id", id);
                            if (acc.getRoleId() == 1) {
                                request.getRequestDispatcher("EditCH.jsp").forward(request, response);
                            } else {
                                request.getRequestDispatcher("KHEditCH.jsp").forward(request, response);
                            }
                            break;
                        case "Cancel":
                            if (acc.getRoleId() == 1) {
                                response.sendRedirect("QLCanHo.jsp");
                            } else {
                                response.sendRedirect("KHQLCanHo.jsp");
                            }
                            break;
                        case "ApplyEdit":
                            try {
                                System.out.println(id);
                            for (Apartment apartment : data) {
                                if ((apartment.getIdPhong() + "").equals(id)) {
                                    if(request.getParameter("out") != null) {
                                        apartment.setIdKH(0);
                                        apartment.setTrangThai(2);
                                        apartment.setCustomerName("");
                                        DAO.Home.UpdateApartment(apartment);
                                        
                                        break;
                                    }
                                    apartment.setIdPhong(Integer.parseInt(id));
                                    apartment.setIdKH(Integer.parseInt(request.getParameter("idKH")));
                                    apartment.setThangThue(Integer.parseInt(request.getParameter("ThangThue")));
                                    apartment.setGiaThue(Float.parseFloat(request.getParameter("GiaThue")));
                                    if (Integer.parseInt(request.getParameter("idKH")) == 0) {
                                        apartment.setTrangThai(2);
                                    } else {
                                        apartment.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));
                                    }
                                    DAO.Home.UpdateApartment(apartment);
                                }
                            }
                            request.getSession().setAttribute("ApaList", Home.getApartment()); 
                            Account account = (Account) request.getSession().getAttribute("Account");
                            if(account != null && account.getRoleId() == 2) {
                                request.getRequestDispatcher("KHQLCanHo.jsp").forward(request, response);
                                return;
                            }
                            request.getRequestDispatcher("QLCanHo.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println("ApplyEdit" + e);
                        }
                        break;
                        case "add":
                            try {
                            Apartment dto = new Apartment();
                            
                            dto.setIdKH(Integer.parseInt(request.getParameter("idKH")));
                            dto.setThangThue(Integer.parseInt(request.getParameter("ThangThue")));
                            dto.setGiaThue(Float.parseFloat(request.getParameter("GiaThue")));
                            dto.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));
                            DAO.Home.InsertApartment(dto);
                            data = DAO.Home.getApartment();
                            request.getSession().setAttribute("ApaList", data);
                            request.getRequestDispatcher("QLCanHo.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    break;
                case "KH":
                    switch (type) {
                        case "del":
                            DAO.Home.DeleteSQL("UPDATE Customers SET trangThai = 0 WHERE idKH=" + id);
                            if (DAO.Home.getApartmentByIDKH(Integer.parseInt(id)).isEmpty()) {
                                response.sendRedirect("QLKhachHang.jsp");
                            } else {
                                DAO.Home.RemoveOutOfPT(Integer.parseInt(id));
                                response.sendRedirect("QLKhachHang.jsp");
                            }
                            break;
                        case "edit":
                            request.setAttribute("type", "edit");
                            request.setAttribute("id", id);
                            if(request.getAttribute("role") != null) request.setAttribute("role", "2");
                            request.getRequestDispatcher("EditKH.jsp").forward(request, response);
                            break;
                        case "Cancel":
                            Account account = (Account) request.getSession().getAttribute("Account");
                            if(account != null && account.getRoleId() == 2) {
                                response.sendRedirect("KHQLKhachHang.jsp");
                                return;
                            }
                            response.sendRedirect("QLKhachHang.jsp");
                            break;
                        case "ApplyEdit":
                            try {
                            Customers dto = new Customers();
                            dto.setIdKH(Integer.parseInt(id));
                            dto.setTenKH(request.getParameter("name"));
                            dto.setSDT(request.getParameter("phone"));
                            dto.setCMND(request.getParameter("cmnd"));
                            dto.setGioiTinh(Integer.parseInt(request.getParameter("gender")));
                            DAO.Home.UpdateKH(dto);
                            request.getSession().setAttribute("cus", dto);
                            request.getSession().setAttribute("ApaList", Home.getApartment());
                            account = (Account) request.getSession().getAttribute("Account");
                            if (account != null && account.getRoleId() == 2) {
                                request.getRequestDispatcher("KHQLKhachHang.jsp").forward(request, response);
                            } else {
                                request.getRequestDispatcher("QLKhachHang.jsp").forward(request, response);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                        case "add":
                            try {
                            Customers dto = new Customers();
                            dto.setTenKH(request.getParameter("name"));
                            dto.setSDT(request.getParameter("phone"));
                            dto.setCMND(request.getParameter("cmnd"));
                            dto.setGioiTinh(Integer.parseInt(request.getParameter("gender")));
                            DAO.Home.InsertKH(dto);
                            request.getRequestDispatcher("QLKhachHang.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    }
                    break;
                case "DV":
                    switch (type) {
                        case "del":
                            DAO.Home.DeleteSQL("UPDATE Service SET trangThai = 0 WHERE idDV=" + id);
                            response.sendRedirect("QLDichVu.jsp");
                            break;
                        case "edit":
                            request.setAttribute("type", "edit");
                            request.setAttribute("id", id);
                            request.setAttribute("idTT", request.getParameter("idTT"));
                            request.getRequestDispatcher("EditDV.jsp").forward(request, response);
                            break;
                        case "Cancel":
                            response.sendRedirect("QLDichVu.jsp");
                            break;
                        case "ApplyEdit":
                            try {
                            Service dto = new Service();
                            
                            dto.setIdDV(Integer.parseInt(request.getParameter("id")));
                            Service odd = DAO.Home.getServiceByID(dto.getIdDV()).get(0);
                            dto.setIdInvoice(Integer.parseInt(request.getParameter("idHD")));
                            dto.setTenDV(request.getParameter("name"));
                            dto.setGiaDV(Float.parseFloat(request.getParameter("price")));
                            dto.setTrangThai(Integer.parseInt(request.getParameter("TrangThai")));
                            DAO.Home.UpdateDV(dto);
                            Invoice invoice = DAO.Home.getInvoiceByID(dto.getIdInvoice());
                            if(dto.getTenDV().equals("Điện") && invoice.getTrangThai()== 2) {
                                invoice.setTongTien(invoice.getTongTien() - odd.getGiaDV() * invoice.getSoDien() + dto.getGiaDV() * invoice.getSoDien());
                            }
                            else if(dto.getTenDV().equals("Nước") && invoice.getTrangThai()== 2) {
                                invoice.setTongTien(invoice.getTongTien() - odd.getGiaDV() * invoice.getSoNuoc()+ dto.getGiaDV() * invoice.getSoNuoc());
                            }
                            DAO.Home.UpdateTT(invoice);
                            request.getRequestDispatcher("QLDichVu.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println(e + "DV");
                        }
                        break;
                        case "add":
                            try {
                            Service dto = new Service();
                            dto.setIdInvoice(Integer.parseInt(request.getParameter("idHD")));
                            dto.setTenDV(request.getParameter("name"));
                            dto.setGiaDV(Float.parseFloat(request.getParameter("price")));
                            DAO.Home.InsertDV(dto);
                            Invoice dtoIV = DAO.Home.getInvoiceByID(dto.getIdInvoice());
                            Apartment apartment = DAO.Home.getApartmentByID(dtoIV.getIdPhong()).get(0);
                            if(dtoIV.getTrangThai() == 2) dtoIV.setTongTien(Calculator.CalSumOfMoney(apartment.getThangThue(), dtoIV.getIdInvoice(), dtoIV.getIdPhong(), dtoIV.getSoDien(), dtoIV.getSoNuoc()));
                            DAO.Home.UpdateTT(dtoIV);
                            request.getRequestDispatcher("QLDichVu.jsp").forward(request, response);
                        } catch (Exception e) {
                            System.out.println(e + "add");
                        }
                        break;
                    }
                    break;
                case "TT":
                    switch (type) {
                        case "del":
                            DAO.Home.DeleteSQL("UPDATE Invoice SET trangThai = 0 WHERE idInvoice=" + id);
                            response.sendRedirect("QLHoaDon.jsp");
                            break;
                        case "edit":
                            request.setAttribute("type", "edit");
                            request.setAttribute("id", id);
                            request.setAttribute("idPhong", request.getParameter("idPhong"));
                            request.getRequestDispatcher("EditHÐ.jsp").forward(request, response);
                            break;
                        case "Cancel":
                            response.sendRedirect("QLHoaDon.jsp");
                            break;
                        case "ApplyEdit":
                            try {
                            String idTmp = request.getParameter("idPhong");
                            String[] arrID = idTmp.split("\\.");
                            Invoice dto = new Invoice();
                            dto.setIdInvoice(Integer.parseInt(request.getParameter("idTT")));
                            dto.setIdPhong(Integer.parseInt(arrID[0]));
                            dto.setSoDien(Integer.parseInt(request.getParameter("SoDien")));
                            dto.setSoNuoc(Integer.parseInt(request.getParameter("SoNuoc")));
                            dto.setTrangThai(Integer.parseInt(request.getParameter("TrangThai")));
                            dto.setTongTien(Calculator.CalSumOfMoney(Integer.parseInt(request.getParameter("ThangThue")), Integer.parseInt(request.getParameter("idTT")), Integer.parseInt(arrID[0]), dto.getSoDien(), dto.getSoNuoc())); 
                            if(dto.getTrangThai() == 1) {
                                for (Apartment apartment : data) {
                                    if(apartment.getIdPhong() == dto.getIdPhong()) {
                                        apartment.setThangThue(LocalDate.now().getMonthValue());
                                        break;
                                    } 
                                }
                                request.getSession().setAttribute("ApaList", data);
                            }
                            Home.UpdateTT(dto);
                            
                            response.sendRedirect("QLHoaDon.jsp");
                        } catch (IOException | NumberFormatException | SQLException e) {
                            System.out.println(e + " DV");
                        }
                        break;
                        case "add":
                            try {
                            int idTT = 0;
                            String idTmp = request.getParameter("idPhong");
                            String[] arrID = idTmp.split("\\.");
                            Invoice dto = new Invoice();
                            try {
                                idTT = Integer.parseInt(request.getParameter("idTT"));
                            } catch (Exception e) {
                                idTT = 0;
                            }
                            dto.setIdPhong(Integer.parseInt(arrID[0]));
                            dto.setSoDien(Integer.parseInt(request.getParameter("SoDien")));
                            dto.setSoNuoc(Integer.parseInt(request.getParameter("SoNuoc")));
                            dto.setTrangThai(Integer.parseInt(request.getParameter("TrangThai")));
                            dto.setTongTien(Calculator.CalSumOfMoney(Integer.parseInt(request.getParameter("ThangThue")), idTT, Integer.parseInt(arrID[0]), dto.getSoDien(), dto.getSoNuoc()));
                            Home.InsertInvoice(dto);
                            response.sendRedirect("QLHoaDon.jsp");
                        } catch (Exception e) {
                            System.out.println(e + " add");
                        }
                        break;
                    }
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
