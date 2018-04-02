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
    private int linhKienId;

    public ChiTietHoaDon(int idChiTietHoaDon, int soLuong, int linhKienId) {
        this.idChiTietHoaDon = idChiTietHoaDon;
        this.soLuong = soLuong;
        this.linhKienId = linhKienId;
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

    public int getLinhKienId() {
        return linhKienId;
    }

    public void setLinhKienId(int linhKienId) {
        this.linhKienId = linhKienId;
    }
    
}
