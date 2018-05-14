/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
import model.LinhKien;

/**
 *
 * @author dtvta
 */
public class DbKhachHang {
    public CreateDb db;
    private ResultSet result=null;
    public String TbKhachHang="TbKhachHang";
    public String Id_khach_hang = "Id_khach_hang";
    public String Ten_khach_hang="Ten_khach_hang";
    public String Dia_chi="Dia_chi";
    public String So_dien_thoai = "So_dien_thoai";
    
    public DbKhachHang() {
        db=new CreateDb();
    }
    
    public int insertKhachHang(KhachHang kh){
        int res=-1;
        String query= "INSERT INTO `"+ TbKhachHang + "` (`" + Id_khach_hang + "`, `" + Ten_khach_hang +"`, `"+ Dia_chi+
                "`, `"+ So_dien_thoai +"`) VALUES (NULL, '" + kh.getTenKhachHang()+ "', '" + kh.getDiaChi()+ "', '" + 
                kh.getDienThoai()+ "')";
        System.out.println(query);
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            res=db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return res; 
    }
    
    public int updateKhachHang(KhachHang kh){
        int res = -1;
        String query = "UPDATE " + TbKhachHang + " SET " + Ten_khach_hang + " = '" + kh.getTenKhachHang()
                + "' , " + Dia_chi + " = '"+ kh.getDiaChi() + "' , " + So_dien_thoai + "  = '" + 
                kh.getDiaChi() + "' WHERE "+ Id_khach_hang + " = '"+ kh.getIdKhachHang()+ "'";
        System.out.println(query);
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public int deleteKhachHang(KhachHang kh){
        int res = -1;
        String query = "DELETE FROM " + TbKhachHang + " WHERE " + Id_khach_hang + " = " + kh.getIdKhachHang();
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
}
