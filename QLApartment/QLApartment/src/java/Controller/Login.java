/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Account;
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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Apartment;
import model.Customers;
import model.Invoice;

/**
 *
 * @author 84915
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Account> accList = DAO.Login.getAllAcc();
        List<Customers> cusList = DAO.Login.getAllCus();
        request.setAttribute("accList", accList);
        request.setAttribute("cusList", cusList);
        response.sendRedirect("register.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean loginStatus = DAO.Login.Login(username, password);
            if (loginStatus) {
                Account acc = DAO.Login.getOneAcc(username);
                List<Apartment> apaList = DAO.Home.getApartment();
                request.getSession().setAttribute("Account", acc);
                if (acc.getIdKH() != 0) {
                    Customers cus = DAO.Home.getOneCustomersByID(acc.getIdKH());
                    request.getSession().setAttribute("cus", cus);
                    ArrayList<Invoice> InvoiceList = DAO.Home.getInvoiceByIdKH(acc.getIdKH());
                    request.getSession().setAttribute("InList", InvoiceList);
                }
                request.getSession().setAttribute("ApaList", apaList);
                request.getSession().setAttribute("username", username);
                if (acc.getRoleId() == 1) {
                    response.sendRedirect("QLCanHo.jsp");
                }
                else {
                   response.sendRedirect("KHQLCanHo.jsp");
                }
            } else {
                request.getSession().setAttribute("username", null);
                response.sendRedirect("Login.jsp");
            }
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

//       try {
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            Account account = DAO.Login.getAccount(username, password);
//            if (account == null) {
//                request.getSession().setAttribute("account", null);
//                response.sendRedirect("Login.jsp");
//            } else {
//                request.getSession().setAttribute("account", account);
//                response.sendRedirect("QLCanHo.jsp");
//            }
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
