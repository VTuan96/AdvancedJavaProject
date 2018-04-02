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
public class NguoiDung {
    private String tenNguoiDung;
    private String matKhau;

    public NguoiDung(String tenNguoiDung, String matKhau) {
        this.tenNguoiDung = tenNguoiDung;
        this.matKhau = matKhau;
    }

    public NguoiDung() {
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    
}
