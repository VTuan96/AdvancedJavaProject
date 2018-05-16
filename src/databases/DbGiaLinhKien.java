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
import model.GiaLinhKien;
import model.LinhKien;
import model.LoaiSanPham;

/**
 *
 * @author dtvta
 */
public class DbGiaLinhKien {
    public CreateDb db;
    private ResultSet result=null;
    public String TbGiaLinhKien = "TbGiaLinhKien";
    public String Ngay_nhap="Ngay_nhap";
    public String Gia_ban="Gia_ban";
    public String Gia_nhap="Gia_nhap";
    public String Id_gia_linh_kien = "Id_gia_linh_kien";
    public String Id_don_vi = "Id_don_vi";
    public String Id_linh_kien = "Id_linh_kien";
    
    public DbGiaLinhKien() {
        db=new CreateDb();
    }

    public boolean insertGiaLinhKien(GiaLinhKien glk){
        boolean res=true;
        String query="Insert into " + TbGiaLinhKien + "(" + Id_gia_linh_kien + ", " +
                Gia_ban + ", " + Gia_nhap +", " + Ngay_nhap +", " + Id_don_vi +", " + Id_linh_kien+") values" 
                + " ( null" + ", '" + glk.getGiaBan()+ "' , '" + glk.getGiaNhap()+ 
                "', '" + glk.getNgayNhap()+  "', '" + glk.getIdDonVi()+ "', '" + glk.getIdLinhKien()+"')";
        System.out.println(query);
        
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            //check lpai linh kien in database
            res=db.getStatement().execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLoaiLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res; 
    }
    
    public int updateGiaLinhKien(GiaLinhKien glk){
        int res = -1;
        String query = "UPDATE " + TbGiaLinhKien + " SET " + Ngay_nhap + " = '" + glk.getNgayNhap()
                + "' , " + Gia_nhap + " = '"+ glk.getGiaNhap()+ "' , " + Gia_ban + "  = '" + 
                glk.getGiaBan()+ "' , " + Id_don_vi + " = '"+ glk.getIdDonVi() + "', "+ Id_linh_kien +
                " = '" + glk.getIdLinhKien() + "' WHERE "+ Id_gia_linh_kien + " = '"+ glk.getIdGiaLinhKien()+ "'";
        System.out.println(query);
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public int deleteGiaLinhKien(GiaLinhKien glk){
        int res = -1;
        String query = "DELETE FROM " + TbGiaLinhKien + " WHERE " + Id_gia_linh_kien + " = " + glk.getIdGiaLinhKien();
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    //get list Gia linh kien in db
    public ArrayList<GiaLinhKien> getListGiaLinhKien(){
        ArrayList<GiaLinhKien> mList=new ArrayList();
        String query="Select * from "+TbGiaLinhKien;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_gia_linh_kien);
                String giaNhap=result.getString(Gia_nhap);
                String giaBan = result.getString(Gia_ban);
                String ngayNhap = result.getString(Ngay_nhap);
                int idDV = result.getInt(Id_don_vi);
                int idLK = result.getInt(Id_linh_kien);
                GiaLinhKien glk = new GiaLinhKien(id, giaNhap, giaBan, ngayNhap, idDV, idLK );
                mList.add(glk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    //lay Gia Linh kien theo id Linh kien
    public GiaLinhKien getGiaLinhKien(int idLK){
        GiaLinhKien glk = new GiaLinhKien();
        String query="Select * from "+TbGiaLinhKien + " where "+Id_linh_kien+ "= '"+idLK+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_gia_linh_kien);
                String giaNhap=result.getString(Gia_nhap);
                String giaBan = result.getString(Gia_ban);
                String ngayNhap = result.getString(Ngay_nhap);
                int idDV = result.getInt(Id_don_vi);
                glk = new GiaLinhKien(id, giaNhap, giaBan, ngayNhap, idDV, idLK );
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return glk;
    }
    
     //lay Gia Linh kien theo id Gia Linh kien
    public GiaLinhKien getGiaLinhKienByIdGLK(int idGLK){
        GiaLinhKien glk = new GiaLinhKien();
        String query="Select * from "+TbGiaLinhKien + " where "+Id_gia_linh_kien+ "= '"+idGLK+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_gia_linh_kien);
                String giaNhap=result.getString(Gia_nhap);
                String giaBan = result.getString(Gia_ban);
                String ngayNhap = result.getString(Ngay_nhap);
                int idDV = result.getInt(Id_don_vi);
                int idLK = result.getInt(Id_linh_kien);
                glk = new GiaLinhKien(id, giaNhap, giaBan, ngayNhap, idDV, idLK );
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return glk;
    }
}
