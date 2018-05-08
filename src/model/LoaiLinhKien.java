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
public class LoaiLinhKien {
    private int idLoaiLinhKien;
    private String tenLoaiLinhKien;

    public LoaiLinhKien(int idLoaiLinhKien, String tenLoaiLinhKien) {
        this.idLoaiLinhKien = idLoaiLinhKien;
        this.tenLoaiLinhKien = tenLoaiLinhKien;
    }

    public LoaiLinhKien(String tenLoaiLinhKien) {
        this.tenLoaiLinhKien = tenLoaiLinhKien;
    }

    public LoaiLinhKien() {
    }

    public int getIdLoaiLinhKien() {
        return idLoaiLinhKien;
    }

    public void setIdLoaiLinhKien(int idLoaiLinhKien) {
        this.idLoaiLinhKien = idLoaiLinhKien;
    }

    public String getTenLoaiLinhKien() {
        return tenLoaiLinhKien;
    }

    public void setTenLoaiLinhKien(String tenLoaiLinhKien) {
        this.tenLoaiLinhKien = tenLoaiLinhKien;
    }
    
}
