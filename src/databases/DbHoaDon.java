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
import model.ChiTietHoaDon;
import model.HoaDon;

/**
 *
 * @author dtvta
 */
public class DbHoaDon {
    public CreateDb db;
    private ResultSet result=null;
    public String TbHoaDon="TbHoaDon";
    public String Id_hoa_don = "Id_hoa_don";
    public String Ngay_nhap="Ngay_nhap";
    public String Khach_hang_Id="Khach_hang_Id";
    public String Tong_tien="Tong_tien";
    
    public DbHoaDon() {
        db=new CreateDb();
    }
    
    public int insertHoaDon(HoaDon hd){
        int res=-1;
        String query= "INSERT INTO `"+ TbHoaDon + "` (`" + Id_hoa_don + "`, `" + Ngay_nhap +"`, `"+ Khach_hang_Id
                +"`, `"+ Tong_tien + "`) VALUES (NULL, '" + hd.getNgayNhap()+ "', '" + hd.getKhachHangId()
                + "', '" + hd.getTongTien()+"')";
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
    
    public int updateHoaDon(HoaDon hd){
        int res = -1;
        String query = "UPDATE " + TbHoaDon + " SET " + Ngay_nhap + " = '" + hd.getNgayNhap()
                + "' , " + Khach_hang_Id + " = '"+ hd.getKhachHangId() + Tong_tien + " = '"+ 
                hd.getTongTien()+"' WHERE "+ Id_hoa_don + " = '"+ hd.getIdHoaDon()+ "'";
        System.out.println(query);
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public int deleteHoaDon(HoaDon hd){
        int res = -1;
        String query = "DELETE FROM " + TbHoaDon + " WHERE " + Id_hoa_don + " = " + hd.getIdHoaDon();
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
}
