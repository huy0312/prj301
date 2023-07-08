/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Service;
import model.Customers;
import model.Apartment;
import model.Invoice;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 84915
 */
public class Home {

    public static ArrayList<Apartment> getApartment() throws SQLException {
        ArrayList<Apartment> al = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("Select a.idPhong, a.idKH, a.thangThue, a.giaThue, a.trangThai, c.tenKH From Apartment as a LEFT JOIN Customers as c\n"
                + "ON a.idKH = c.idKH");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Apartment p = new Apartment();
            p.setGiaThue(rs.getFloat("giaThue"));
            p.setIdKH(rs.getInt("idKH"));
            p.setIdPhong(rs.getInt("idPhong"));
            p.setThangThue(rs.getInt("thangThue"));
            p.setTrangThai(rs.getInt("trangThai"));
            p.setCustomerName(rs.getString("tenKH"));
            al.add(p);
        }
        conn.close();
        return al;
    }

    public static int getThangThueByID(int id) throws SQLException {
        int ThangThue = 0;
        try {
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement("select thangThue from Apartment where idPhong = " + id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ThangThue = rs.getInt("thangThue");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ThangThue;
    }

    public static ArrayList<Apartment> getApartmentByIDKH(int id) throws SQLException {
        ArrayList<Apartment> al = new ArrayList<>();
        try {
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Apartment where idKH = " + id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Apartment p = new Apartment();
                p.setGiaThue(rs.getFloat("giaThue"));
                p.setIdKH(rs.getInt("idKH"));
                p.setIdPhong(rs.getInt("idPhong"));
                p.setThangThue(rs.getInt("thangThue"));
                p.setTrangThai(rs.getInt("trangThai"));
                al.add(p);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return al;
    }

    public static ArrayList<Apartment> getApartmentByID(int id) throws SQLException {
        ArrayList<Apartment> al = new ArrayList<>();
        try {
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from Apartment where idPhong = " + id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Apartment p = new Apartment();
                p.setGiaThue(rs.getFloat("giaThue"));
                p.setIdKH(rs.getInt("idKH"));
                p.setIdPhong(rs.getInt("idPhong"));
                p.setThangThue(rs.getInt("thangThue"));
                p.setTrangThai(rs.getInt("trangThai"));
                al.add(p);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return al;
    }

    public static ArrayList<Customers> getCustomers() throws SQLException {
        ArrayList<Customers> al = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Customers where trangThai = 1");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Customers p = new Customers();
            p.setIdKH(rs.getInt("idKH"));
            p.setTenKH(rs.getString("tenKH"));
            p.setSDT(rs.getString("SDT").trim());
            p.setCMND(rs.getString("CMND").trim());
            p.setGioiTinh(rs.getInt("gioiTinh"));
            al.add(p);
        }
        conn.close();
        return al;
    }

    public static ArrayList<Customers> getCustomersByID(int id) throws SQLException {
        ArrayList<Customers> al = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Customers where idKH = " + id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Customers p = new Customers();
            p.setIdKH(rs.getInt("idKH"));
            p.setTenKH(rs.getString("tenKH"));
            p.setSDT(rs.getString("SDT").trim());
            p.setCMND(rs.getString("CMND").trim());
            p.setGioiTinh(rs.getInt("gioiTinh"));
            al.add(p);
        }
        conn.close();
        return al;
    }

    public static Customers getOneCustomersByID(int id) throws SQLException {
        Customers p = new Customers();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Customers where idKH = " + id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {

            p.setIdKH(rs.getInt("idKH"));
            p.setTenKH(rs.getString("tenKH"));
            p.setSDT(rs.getString("SDT").trim());
            p.setCMND(rs.getString("CMND").trim());
            p.setGioiTinh(rs.getInt("gioiTinh"));
            return p;
        }
        conn.close();
        return p;
    }

    public static int UpdateKH(Customers dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = null;
        stm = cnn.prepareStatement("UPDATE Customers SET tenKH=N'" + dto.getTenKH() + "', SDT='" + dto.getSDT() + "',CMND='" + dto.getCMND() + "',gioiTinh=N'" + dto.getGioiTinh() + "' WHERE idKH = '" + dto.getIdKH() + "'");
        return stm.executeUpdate();
    }

    public static int InsertKH(Customers dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = null;
        stm = cnn.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?)");
        stm.setString(1, dto.getTenKH());
        stm.setString(2, dto.getSDT());
        stm.setString(3, dto.getCMND());
        stm.setInt(4, dto.getGioiTinh());
        stm.setInt(5, 1);
        return stm.executeUpdate();
    }

    public static int DeleteSQL(String sqlquery) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = cnn.prepareStatement(sqlquery);
        return stm.executeUpdate();
    }

    public static int UpdateApartment(Apartment dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm;
        if (dto.getIdKH() != 0) {
            stm = cnn.prepareStatement("UPDATE Apartment SET idKH='" + dto.getIdKH() + "',giaThue='" + dto.getGiaThue() + "',thangThue='" + dto.getThangThue() + "',trangThai='" + dto.getTrangThai() + "' WHERE idPhong = '" + dto.getIdPhong() + "'");
        } else {
            stm = cnn.prepareStatement("UPDATE Apartment SET idKH= cast(NULL as int),giaThue='" + dto.getGiaThue() + "',thangThue='" + dto.getThangThue() + "', trangThai='" + dto.getTrangThai() + "' WHERE idPhong = '" + dto.getIdPhong() + "'");
        }
        return stm.executeUpdate();
    }

    public static int InsertApartment(Apartment dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = null;
        if (dto.getIdKH() != 0) {
            stm = cnn.prepareStatement("INSERT INTO Apartment VALUES(?,?,?,?)");
            stm.setInt(1, dto.getIdKH());
            stm.setInt(2, dto.getThangThue());
            stm.setFloat(3, dto.getGiaThue());
            stm.setInt(4, 1);
        } else {
            stm = cnn.prepareStatement("INSERT INTO Apartment VALUES(cast(NULL as int),?,?,?)");
            stm.setInt(1, dto.getThangThue());
            stm.setFloat(2, dto.getGiaThue());
            stm.setInt(3, 2);
        }
        return stm.executeUpdate();
    }

    public static ArrayList<Service> getService() throws SQLException {
        ArrayList<Service> al = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Service");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Service p = new Service();
            p.setIdDV(rs.getInt("idDV"));
            p.setIdInvoice(rs.getInt("idInvoice"));
            p.setTenDV(rs.getString("tenDV"));
            p.setGiaDV(rs.getFloat("giaDV"));
            p.setTrangThai(rs.getInt("trangThai"));
            al.add(p);
        }
        conn.close();
        return al;
    }

    public static ArrayList<Service> getServiceByID(int id) throws SQLException {
        ArrayList<Service> al = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Service where idDV = " + id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Service p = new Service();
            p.setIdDV(rs.getInt("idDV"));
            p.setIdInvoice(rs.getInt("idInvoice"));
            p.setTenDV(rs.getString("tenDV").trim());
            p.setGiaDV(rs.getFloat("giaDV"));
            p.setTrangThai(rs.getInt("trangThai"));
            al.add(p);
        }
        conn.close();
        return al;
    }

    public static ArrayList<Service> getServiceByIDInvoice(int id) throws SQLException {
        ArrayList<Service> arr = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Service where idInvoice = " + id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Service p = new Service();
            p.setIdDV(rs.getInt("idDV"));
            p.setIdInvoice(rs.getInt("idInvoice"));
            p.setTenDV(rs.getString("tenDV").trim());
            p.setGiaDV(rs.getFloat("giaDV"));
            arr.add(p);
        }
        conn.close();
        return arr;
    }

    public static int UpdateDV(Service dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = cnn.prepareStatement("UPDATE Service SET idInvoice='" + dto.getIdInvoice() + "',tenDV=N'" + dto.getTenDV() + "',giaDV ='" + dto.getGiaDV() + "',trangThai ='" + dto.getTrangThai()+ "' WHERE idDV = '" + dto.getIdDV() + "'");
        return stm.executeUpdate();
    }

    public static ArrayList<Invoice> getInvoice() throws SQLException {
        ArrayList<Invoice> al = new ArrayList<>();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Invoice");
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Invoice p = new Invoice();
            p.setIdInvoice(rs.getInt("idInvoice"));
            p.setIdPhong(rs.getInt("idPhong"));
            p.setTongTien(rs.getFloat("tongTien"));
            p.setSoDien(rs.getInt("soDien"));
            p.setSoNuoc(rs.getInt("soNuoc"));
            p.setTrangThai(rs.getInt("trangThai"));
            al.add(p);
        }
        conn.close();
        return al;
    }

    public static ArrayList<Invoice> getInvoiceByIdKH(int idKH) {
        ArrayList<Invoice> al = new ArrayList<>();
        String sql = "SELECT i.idInvoice, i.idPhong, a.thangThue, i.soDien, i.soNuoc, i.trangThai, i.tongTien FROM Invoice as i JOIN Apartment as a ON i.idPhong = a.idPhong JOIN Customers as c ON c.idKH = a.idKH WHERE c.idKH = ?";
        try {
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idKH);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                al.add(new Invoice(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getFloat(7)));
            }
            return al;
        } catch (Exception e) {
            return null;
        }
    }

    public static Invoice getInvoiceByID(int id) throws SQLException {
        Invoice p = new Invoice();
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Invoice where idInvoice = " + id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            p.setIdInvoice(rs.getInt("idInvoice"));
            p.setIdPhong(rs.getInt("idPhong"));
            p.setTongTien(rs.getFloat("tongTien"));
            p.setSoDien(rs.getInt("soDien"));
            p.setSoNuoc(rs.getInt("soNuoc"));
            p.setTrangThai(rs.getInt("trangThai"));
        }
        conn.close();
        return p;
    }

    public static int UpdateTT(Invoice dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm;
        LocalDate LD = LocalDate.now();
        int month = LD.getMonthValue();
        if (dto.getTrangThai() == 1) {
            stm = cnn.prepareStatement("UPDATE Apartment SET thangThue=" + month + "WHERE idPhong=" + dto.getIdPhong());
            stm.executeUpdate();
        }
        stm = cnn.prepareStatement("UPDATE Invoice SET idPhong='" + dto.getIdPhong() + "',tongTien='" + dto.getTongTien() + "',soDien ='" + dto.getSoDien() + "',soNuoc='" + dto.getSoNuoc() + "',trangThai='" + dto.getTrangThai() + "' WHERE idInvoice = '" + dto.getIdInvoice() + "'");
        return stm.executeUpdate();
    }

    public static int InsertDV(Service dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = null;
        if (dto.getIdInvoice() != 0) {
            stm = cnn.prepareStatement("INSERT INTO Service VALUES(?,?,?,?)");
            stm.setInt(1, dto.getIdInvoice());
            stm.setString(2, dto.getTenDV());
            stm.setFloat(3, dto.getGiaDV());
            if(dto.getTenDV().equals("Điện") || dto.getTenDV().equals("Nước")) {
                stm.setInt(4, 3);
            }
            stm.setInt(4, 2);
        } else {
            stm = cnn.prepareStatement("INSERT INTO Service VALUES(cast(NULL as int),?,?,?)");
            stm.setString(1, dto.getTenDV());
            stm.setFloat(2, dto.getGiaDV());
            stm.setInt(3, 2);
        }
        return stm.executeUpdate();
    }

    public static int InsertInvoice(Invoice dto) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = cnn.prepareStatement("INSERT INTO Invoice VALUES(?,?,?,?,?)");
        stm.setInt(1, dto.getIdPhong());
        stm.setFloat(2, dto.getTongTien());
        stm.setInt(3, dto.getSoDien());
        stm.setInt(4, dto.getSoNuoc());
        stm.setInt(5, dto.getTrangThai());

        return stm.executeUpdate();
    }

    public static int RemoveOutOfPT(int id) throws SQLServerException, SQLException {
        Connection cnn = DB.DBContext.getConnection();
        PreparedStatement stm = cnn.prepareStatement("UPDATE Apartment SET idKH= cast(NULL as int),thangThue='0', trangThai='2' WHERE idKH = '" + id + "'");
        return stm.executeUpdate();
    }

}
