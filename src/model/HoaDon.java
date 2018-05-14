/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author dtvta
 */
public class HoaDon {
    private int idHoaDon;
    private String ngayNhap;
    private int khachHangId;
    private String tongTien;

    public HoaDon(int idHoaDon, String ngayNhap, int khachHangId, String tongTien) {
        this.idHoaDon = idHoaDon;
        this.ngayNhap = ngayNhap;
        this.khachHangId = khachHangId;
        this.tongTien = tongTien;
    }

    public HoaDon(String ngayNhap, int khachHangId) {
        this.ngayNhap = ngayNhap;
        this.khachHangId = khachHangId;
    }
    

    public HoaDon(String ngayNhap, int khachHangId, String tongTien) {
        this.ngayNhap = ngayNhap;
        this.khachHangId = khachHangId;
        this.tongTien = tongTien;
    }

    
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(int khachHangId) {
        this.khachHangId = khachHangId;
    }


}
