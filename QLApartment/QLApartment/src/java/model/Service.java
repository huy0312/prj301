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
public class Service {

    int idDV, idInvoice,trangThai;
    String tenDV;
    float giaDV;

    public Service() {
    }

    public Service(int idDV, int idInvoice, int trangThai, String tenDV, float giaDV) {
        this.idDV = idDV;
        this.idInvoice = idInvoice;
        this.trangThai = trangThai;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
    }

    public int getIdDV() {
        return idDV;
    }

    public void setIdDV(int idDV) {
        this.idDV = idDV;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(float giaDV) {
        this.giaDV = giaDV;
    }
    
    

}
