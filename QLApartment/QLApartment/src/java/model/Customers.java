/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 84915
 */
public class Customers {
    int idKH, gioiTinh, trangthai;
    String tenKH, SDT, CMND;

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    
    public Customers() {
    }

    public Customers(int idKH, int gioiTinh, int trangthai, String tenKH, String SDT, String CMND) {
        this.idKH = idKH;
        this.gioiTinh = gioiTinh;
        this.trangthai = trangthai;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.CMND = CMND;
    }

    

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
    
}
