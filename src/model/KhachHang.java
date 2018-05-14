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
public class KhachHang {
    private int idKhachHang;
    private String tenKhachHang;
    private String diaChi;
    private String dienThoai;

    public KhachHang(int idKhachHang, String tenKhachHang, String diaChi, String dienThoai) {
        this.idKhachHang = idKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public KhachHang(String tenKhachHang, String diaChi, String dienThoai) {
        this.tenKhachHang = tenKhachHang;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public KhachHang() {
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

}
