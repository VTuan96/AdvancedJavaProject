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
public class ViTriLinhKien {
    private int idViTriLinhKien;
    private String tenViTriLinhKien;

    public ViTriLinhKien(int idViTriLinhKien, String tenViTriLinhKien) {
        this.idViTriLinhKien = idViTriLinhKien;
        this.tenViTriLinhKien = tenViTriLinhKien;
    }

    public ViTriLinhKien() {
    }

    public int getIdViTriLinhKien() {
        return idViTriLinhKien;
    }

    public void setIdViTriLinhKien(int idViTriLinhKien) {
        this.idViTriLinhKien = idViTriLinhKien;
    }

    public String getTenViTriLinhKien() {
        return tenViTriLinhKien;
    }

    public void setTenViTriLinhKien(String tenViTriLinhKien) {
        this.tenViTriLinhKien = tenViTriLinhKien;
    }
    
    
}
