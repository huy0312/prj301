/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import static DAO.Login.getNewestCusid;
import static DAO.Login.getOneAcc;
import static DAO.Login.getOneCus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Customers;

/**
 *
 * @author toden
 */
public class Register {

    public Register(){
        
    }
    
    public static boolean addAcc(String name, String password) {
        String sql = "insert into Account values (?,?,?,?,?)";
        Account acc = new Account();
        try {
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, password);
            st.setInt(3, 0);
            st.setInt(4, 2);
            st.setInt(5, getNewestCusid());
            st.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    public static boolean addCus(String tenKH, String sdt, String CMND, int gender, int Status){
          String sql = "insert into Customers values(?,?,?,?,?) ";
          Customers cus = new Customers();
          try{
              Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setNString(1, tenKH);
            st.setString(2,sdt);
            st.setString(3,CMND);
            st.setInt(4,gender);
            st.setInt(5,Status);
            st.executeUpdate();
            return true;
          }catch(Exception e){
              
          }
          return false;
    }
    
    public static boolean CheckAcc(String name){
        String sql = "select * from Account where username = ?";
        try{
            Connection conn = DB.DBContext.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return false;
            }
        }catch(Exception e){
            return true;
        }
        return true;
    }
    
    public static boolean CheckCus(String CMND) {
        try{
            Connection conn = DB.DBContext.getConnection();
        PreparedStatement st = conn.prepareStatement("select * from Customers where CMND = " + CMND);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
           return false;
        }
        }
        catch(Exception ex){
            
        }
        
        return true;
    }
}
