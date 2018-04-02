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
public class LinhKien {
    private int idLinhKien;
    private String hinhAnh;
    private String ngayNhap;
    private String giaNhap;
    private String giaBan;
    private int loaiLinhKienId;
    private int viTriLinhKienId;

    public LinhKien(int idLinhKien, String hinhAnh, String ngayNhap, String giaNhap, String giaBan, int loaiLinhKienId, int viTriLinhKienId) {
        this.idLinhKien = idLinhKien;
        this.hinhAnh = hinhAnh;
        this.ngayNhap = ngayNhap;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.loaiLinhKienId = loaiLinhKienId;
        this.viTriLinhKienId = viTriLinhKienId;
    }

    public LinhKien() {
    }

    public int getIdLinhKien() {
        return idLinhKien;
    }

    public void setIdLinhKien(int idLinhKien) {
        this.idLinhKien = idLinhKien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
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

    public void setGiaBan(String giaBan) {
        this.giaBan = giaBan;
    }

    public int getLoaiLinhKienId() {
        return loaiLinhKienId;
    }

    public void setLoaiLinhKienId(int loaiLinhKienId) {
        this.loaiLinhKienId = loaiLinhKienId;
    }

    public int getViTriLinhKienId() {
        return viTriLinhKienId;
    }

    public void setViTriLinhKienId(int viTriLinhKienId) {
        this.viTriLinhKienId = viTriLinhKienId;
    }
    
    
}
