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
public class DonVi {
    private int idDonVi;
    private String tenDonVi;

    public DonVi() {
    }

    public DonVi(int idDonVi, String tenDonVi) {
        this.idDonVi = idDonVi;
        this.tenDonVi = tenDonVi;
    }

    public DonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    public int getIdDonVi() {
        return idDonVi;
    }

    public void setIdDonVi(int idDonVi) {
        this.idDonVi = idDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }
    
    
}
