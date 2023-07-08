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
public class Apartment {
 int idPhong, idKH, thangThue, trangThai;
 float giaThue;
 String CustomerName;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getThangThue() {
        return thangThue;
    }

    public void setThangThue(int thangThue) {
        this.thangThue = thangThue;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public float getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(float giaThue) {
        this.giaThue = giaThue;
    }

    public Apartment(int idPhong, int idKH, int thangThue, int trangThai, float giaThue, String CustomerName) {
        this.idPhong = idPhong;
        this.idKH = idKH;
        this.thangThue = thangThue;
        this.trangThai = trangThai;
        this.giaThue = giaThue;
        this.CustomerName = CustomerName;
    }

    public Apartment() {
    }
}
