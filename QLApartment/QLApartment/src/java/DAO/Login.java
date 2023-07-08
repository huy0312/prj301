/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Account;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Apartment;
import model.Customers;

/**
 *
 * @author 84915
 */
public class Login {

    public static boolean Login(String username, String password) throws SQLServerException, SQLException {
        boolean loginStatus = false;
        Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Account where username = ? and password = ?");
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            loginStatus = true;
        }
        conn.close();
        return loginStatus;
    }
    
    public static List<Account> getAllAcc(){
        String sql = "select * from Account";
        List<Account> accList = new ArrayList<>();
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String username = rs.getString(1);
                String password = rs.getString(2);
                int roleId = rs.getInt(4);
                int idKH = rs.getInt(5);
                accList.add(new Account(username, password, roleId, idKH));
            }
            return accList;
        }catch(Exception e){
            return null;
        }
    }
    
      public static Account getOneAcc(String name){
        String sql = "select * from Account where username = ?";
        Account acc = new Account();
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String username = rs.getString(1);
                String password = rs.getString(2);
                int roleId = rs.getInt(4);
                int idKH = rs.getInt(5);
                acc = new Account(username, password, roleId, idKH);
            }
            return acc;
        }catch(Exception e){
            return null;
        }
    }
      
       public static List<Customers> getAllCus(){
        String sql = "select * from Customers";
        List<Customers> cusList = new ArrayList<>();
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int idKH = rs.getInt(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                String cmnd = rs.getString(4);
                int gioitinh = rs.getInt(5);
                int trangthai = rs.getInt(6);
                cusList.add(new Customers(idKH, gioitinh, trangthai, tenKH, sdt, cmnd));
            }
            return cusList;
        }catch(Exception e){
            return null;
        }
    }
    public static int getNewestCusid(){
        String sql = "select top 1 * from Customers order by idKH desc";
        int id = 1;
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }catch(Exception ex){
            
        }
        return id;
    }
            
    public static Customers getOneCus(int idKH){
        String sql = "select * from Customers where idKH = ?";
        Customers cus = new Customers();
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idKH);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                String cmnd = rs.getString(4);
                int gioitinh = rs.getInt(5);
                int trangthai = rs.getInt(6);
                cus = new Customers(idKH, gioitinh, trangthai, tenKH, sdt, cmnd);
            }
            return cus;
        }catch(Exception e){
            return null;
        }
    }
    
    public static List<Apartment> getApartmentByidKH(int idKH){
        String sql = "select ap.idPhong, ap.thangThue , ap.trangThai, ap.giaThue, c.tenKH from Account as a JOIN Customers as ON a.idKH = c.idKH JOIN Apartment as ap ON a.idKH = ap.idKH WHERE a.idKH = ?";
        List<Apartment> ApaList = new ArrayList<>();
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, idKH);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                ApaList.add(new Apartment(rs.getInt(1),idKH,rs.getInt(2),rs.getInt(3),rs.getFloat(4),rs.getString(5)));
            }
        }catch(Exception e){
            
        }
        return ApaList;
    }
    
}
