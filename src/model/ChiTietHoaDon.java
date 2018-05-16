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
public class ChiTietHoaDon {
    private int idChiTietHoaDon;
    private int soLuong;
    private int giaLinhKienId;
    private String maHoaDon;

    public ChiTietHoaDon(int idChiTietHoaDon, int soLuong, int giaLinhKienId, String maHoaDon) {
        this.idChiTietHoaDon = idChiTietHoaDon;
        this.soLuong = soLuong;
        this.giaLinhKienId = giaLinhKienId;
        this.maHoaDon = maHoaDon;
    }

    public ChiTietHoaDon(int soLuong, int giaLinhKienId, String maHoaDon) {
        this.soLuong = soLuong;
        this.giaLinhKienId = giaLinhKienId;
        this.maHoaDon = maHoaDon;
    }

    public ChiTietHoaDon() {
    }

    public int getIdChiTietHoaDon() {
        return idChiTietHoaDon;
    }

    public void setIdChiTietHoaDon(int idChiTietHoaDon) {
        this.idChiTietHoaDon = idChiTietHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaLinhKienId() {
        return giaLinhKienId;
    }

    public void setGiaLinhKienId(int giaLinhKienId) {
        this.giaLinhKienId = giaLinhKienId;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

}
