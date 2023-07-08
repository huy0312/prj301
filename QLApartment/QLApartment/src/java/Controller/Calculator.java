/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.Home;
import model.Service;
import model.Apartment;
import model.Invoice;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 84915
 */
public class Calculator {

    // gia thue phong cua SumOfThanhThue 
    public static float CalSumOfMoney(int ThangThue, int idTT, int idPhong, int soDien, int soNuoc) {
        float Sum = 0, GiaDien = 0, GiaNuoc = 0;
        int SumOfThanhThue = 0;
        try {
            LocalDate LD = LocalDate.now();
            int month = LD.getMonthValue();
            SumOfThanhThue = Math.abs(month - ThangThue);
            if (idTT >=1) {
                ArrayList<Service> arr = Home.getServiceByIDInvoice(idTT);
                for (Service dtoDV : arr) {
                    if (dtoDV.getTenDV().equals("Điện")) {
                        GiaDien = dtoDV.getGiaDV();
                    } else if(dtoDV.getTenDV().equals("Nước")){
                        GiaNuoc = dtoDV.getGiaDV();
                    }
                }
                Sum = (soDien * GiaDien) + (soNuoc * GiaNuoc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Sum + CalRoomMoney(SumOfThanhThue, idPhong);
    }

    // gia thue phong 1 thang 
    public static float CalRoomMoney(int NumberOfMonth, int idPhong) {
        float Sum = 0;
        try {
            ArrayList<Apartment> arrPT = DAO.Home.getApartmentByID(idPhong);
            for (Apartment dtoPT : arrPT) {
                Sum = dtoPT.getGiaThue() * NumberOfMonth;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Sum;
    }

}
