/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dtvta
 */
public class HoaDon {
    private int idHoaDon;
    private String ngayNhap;
    private int khachHangId;
    private int chiTietHoaDonId;

    public HoaDon(int idHoaDon, String ngayNhap, int khachHangId, int chiTietHoaDonId) {
        this.idHoaDon = idHoaDon;
        this.ngayNhap = ngayNhap;
        this.khachHangId = khachHangId;
        this.chiTietHoaDonId = chiTietHoaDonId;
    }

    public HoaDon() {
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

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(int khachHangId) {
        this.khachHangId = khachHangId;
    }

    public int getChiTietHoaDonId() {
        return chiTietHoaDonId;
    }

    public void setChiTietHoaDonId(int chiTietHoaDonId) {
        this.chiTietHoaDonId = chiTietHoaDonId;
    }
    
}
