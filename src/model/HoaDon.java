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
    private String maHoaDon;
    private String ngayNhap;
    private String maKhachHang;
    private String tongTien;

    public HoaDon() {
    }
    
    public HoaDon( String maHoaDon, String ngayNhap, String maKhachHang, String tongTien) {
        this.ngayNhap = ngayNhap;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
        this.maHoaDon = maHoaDon;
    }

    public HoaDon(String maHoaDon, String ngayNhap, String maKhachHang) {
        this.maHoaDon = maHoaDon;
        this.ngayNhap = ngayNhap;
        this.maKhachHang = maKhachHang;
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

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

}
