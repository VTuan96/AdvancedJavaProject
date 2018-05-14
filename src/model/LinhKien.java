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
    private String tenLinhKien;
    private String hinhAnh;
    private int loaiLinhKienId;
    private int viTriLinhKienId;
//    private int idGiaLinhKien;

//    public LinhKien(int idLinhKien, String tenLinhKien, String hinhAnh, int loaiLinhKienId, int viTriLinhKienId, int idGiaLinhKien) {
//        this.idLinhKien = idLinhKien;
//        this.tenLinhKien = tenLinhKien;
//        this.hinhAnh = hinhAnh;
//        this.loaiLinhKienId = loaiLinhKienId;
//        this.viTriLinhKienId = viTriLinhKienId;
//        this.idGiaLinhKien = idGiaLinhKien;
//    }
//
//    public LinhKien(String tenLinhKien, String hinhAnh, int loaiLinhKienId, int viTriLinhKienId, int idGiaLinhKien) {
//        this.tenLinhKien = tenLinhKien;
//        this.hinhAnh = hinhAnh;
//        this.loaiLinhKienId = loaiLinhKienId;
//        this.viTriLinhKienId = viTriLinhKienId;
//        this.idGiaLinhKien = idGiaLinhKien;
//    }

    public LinhKien(int idLinhKien, String tenLinhKien, String hinhAnh, int loaiLinhKienId, int viTriLinhKienId) {
        this.idLinhKien = idLinhKien;
        this.tenLinhKien = tenLinhKien;
        this.hinhAnh = hinhAnh;
        this.loaiLinhKienId = loaiLinhKienId;
        this.viTriLinhKienId = viTriLinhKienId;
    }

    public LinhKien(String tenLinhKien, String hinhAnh, int loaiLinhKienId, int viTriLinhKienId) {
        this.tenLinhKien = tenLinhKien;
        this.hinhAnh = hinhAnh;
        this.loaiLinhKienId = loaiLinhKienId;
        this.viTriLinhKienId = viTriLinhKienId;
    }
    
    

    public LinhKien() {
    }

    public String getTenLinhKien() {
        return tenLinhKien;
    }

    public void setTenLinhKien(String tenLinhKien) {
        this.tenLinhKien = tenLinhKien;
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

//    public int getIdGiaLinhKien() {
//        return idGiaLinhKien;
//    }
//
//    public void setIdGiaLinhKien(int idGiaLinhKien) {
//        this.idGiaLinhKien = idGiaLinhKien;
//    }

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
