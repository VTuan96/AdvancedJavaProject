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
public class GiaLinhKien {
    private int idGiaLinhKien;
    private String giaNhap;
    private String giaBan;
    private String ngayNhap;
    private int idDonVi;
    private int idLinhKien;

    public GiaLinhKien() {
    }

    public GiaLinhKien(int idGiaLinhKien, String giaNhap, String giaBan, String ngayNhap, int idDonVi) {
        this.idGiaLinhKien = idGiaLinhKien;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayNhap = ngayNhap;
        this.idDonVi = idDonVi;
    }

    public GiaLinhKien(String giaNhap, String giaBan, String ngayNhap, int idDonVi) {
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayNhap = ngayNhap;
        this.idDonVi = idDonVi;
    }

    public GiaLinhKien(String giaNhap, String giaBan, String ngayNhap, int idDonVi, int idLinhKien) {
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayNhap = ngayNhap;
        this.idDonVi = idDonVi;
        this.idLinhKien = idLinhKien;
    }

    public GiaLinhKien(int idGiaLinhKien, String giaNhap, String giaBan, String ngayNhap, int idDonVi, int idLinhKien) {
        this.idGiaLinhKien = idGiaLinhKien;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayNhap = ngayNhap;
        this.idDonVi = idDonVi;
        this.idLinhKien = idLinhKien;
    }
    

    public int getIdGiaLinhKien() {
        return idGiaLinhKien;
    }

    public void setIdGiaLinhKien(int idGiaLinhKien) {
        this.idGiaLinhKien = idGiaLinhKien;
    }

    public String getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getGiaBan() {
        return giaBan;
    }

    public int getIdLinhKien() {
        return idLinhKien;
    }

    public void setIdLinhKien(int idLinhKien) {
        this.idLinhKien = idLinhKien;
    }

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getIdDonVi() {
        return idDonVi;
    }

    public void setIdDonVi(int idDonVi) {
        this.idDonVi = idDonVi;
    }
    
}
