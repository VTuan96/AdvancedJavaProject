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
    private int hoaDonId;

    public ChiTietHoaDon(int idChiTietHoaDon, int soLuong, int giaLinhKienId, int hoaDonId) {
        this.idChiTietHoaDon = idChiTietHoaDon;
        this.soLuong = soLuong;
        this.giaLinhKienId = giaLinhKienId;
        this.hoaDonId = hoaDonId;
    }

    public ChiTietHoaDon(int soLuong, int giaLinhKienId, int hoaDonId) {
        this.soLuong = soLuong;
        this.giaLinhKienId = giaLinhKienId;
        this.hoaDonId = hoaDonId;
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

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }
}
