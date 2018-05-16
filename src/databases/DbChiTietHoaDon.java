/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietHoaDon;
import model.GiaLinhKien;
import model.KhachHang;

/**
 *
 * @author dtvta
 */
public class DbChiTietHoaDon {
    public CreateDb db;
    private ResultSet result=null;
    public String TbChiTietHoaDon="TbChiTietHoaDon";
    public String Id_chi_tiet_hoa_don = "Id_chi_tiet_hoa_don";
    public String So_luong="So_luong";
    public String Id_gia_linh_kien="Id_gia_linh_kien";
    public String Ma_hoa_don = "Ma_hoa_don";
    
    public DbChiTietHoaDon() {
        db=new CreateDb();
    }
    
    public int insertChiTietHoaDon(ChiTietHoaDon cthd){
        int res=-1;
        String query= "INSERT INTO `"+ TbChiTietHoaDon + "` (`" + Id_chi_tiet_hoa_don + "`, `" + So_luong 
                +"`, `"+ Id_gia_linh_kien+ "`, `"+ Ma_hoa_don +"`) VALUES (NULL, '" + cthd.getSoLuong()+ 
                "', '" + cthd.getGiaLinhKienId() + "', '" + cthd.getMaHoaDon()+"')";
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
    
    public int updateChiTietHoaDon(ChiTietHoaDon cthd){
        int res = -1;
        String query = "UPDATE " + TbChiTietHoaDon + " SET " + So_luong + " = '" + cthd.getSoLuong()
                + "' , " + Id_gia_linh_kien + " = '"+ cthd.getGiaLinhKienId()+ "' , " + Ma_hoa_don 
                + " = '"+ cthd.getMaHoaDon()+ "' WHERE "+ Id_chi_tiet_hoa_don + " = '"+ cthd.getIdChiTietHoaDon()+ "'";
        System.out.println(query);
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public int deleteChiTietHoaDon(ChiTietHoaDon cthd){
        int res = -1;
        String query = "DELETE FROM " + TbChiTietHoaDon + " WHERE " + Id_chi_tiet_hoa_don + " = " + cthd.getIdChiTietHoaDon();
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    //get list Gia linh kien in db
    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(){
        ArrayList<ChiTietHoaDon> mList=new ArrayList();
        String query="Select * from "+TbChiTietHoaDon;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id = result.getInt(Id_chi_tiet_hoa_don);
                int soLuong = result.getInt(So_luong);
                int idGLK = result.getInt(Id_gia_linh_kien);
                String maHD = result.getString(Ma_hoa_don);
                ChiTietHoaDon cthd = new ChiTietHoaDon(id, soLuong, idGLK, maHD);
                mList.add(cthd);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    //get list Gia linh kien in db
    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon(String maHD){
        ArrayList<ChiTietHoaDon> mList=new ArrayList();
        String query="Select * from "+TbChiTietHoaDon + " WHERE " + Ma_hoa_don + " LIKE '" + maHD + "'";
        System.err.println(query);
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id = result.getInt(Id_chi_tiet_hoa_don);
                int soLuong = result.getInt(So_luong);
                int idGLK = result.getInt(Id_gia_linh_kien);
                ChiTietHoaDon cthd = new ChiTietHoaDon(id, soLuong, idGLK, maHD);
                mList.add(cthd);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
}
