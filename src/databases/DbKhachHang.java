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
import model.KhachHang;
import model.LinhKien;
import model.LoaiSanPham;

/**
 *
 * @author dtvta
 */
public class DbKhachHang {
    public CreateDb db;
    private ResultSet result=null;
    public String TbKhachHang="TbKhachHang";
    public String Ma_khach_hang = "Ma_khach_hang";
    public String Ten_khach_hang="Ten_khach_hang";
    public String Dia_chi="Dia_chi";
    public String So_dien_thoai = "So_dien_thoai";
    
    public DbKhachHang() {
        db=new CreateDb();
    }
    
    public int insertKhachHang(KhachHang kh){
        int res=-1;
        String query= "INSERT INTO `"+ TbKhachHang + "` (`" + Ma_khach_hang + "`, `" + Ten_khach_hang +"`, `"+ Dia_chi+
                "`, `"+ So_dien_thoai +"`) VALUES ( '"+ kh.getMaKhachHang()+"', '" + kh.getTenKhachHang()+ "', '" + kh.getDiaChi()+ "', '" + 
                kh.getDienThoai()+ "')";
        System.out.println(query);
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            boolean check = checkKhachHang(kh.getMaKhachHang());
            if (!check){
                res=db.getStatement().executeUpdate(query);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return res; 
    }
    
    public int updateKhachHang(KhachHang kh){
        int res = -1;
        String query = "UPDATE " + TbKhachHang + " SET " + Ten_khach_hang + " = '" + kh.getTenKhachHang()
                + "' , " + Dia_chi + " = '"+ kh.getDiaChi() + "' , " + So_dien_thoai + "  = '" + 
                kh.getDienThoai()+ "' WHERE "+ Ma_khach_hang + " LIKE '"+ kh.getMaKhachHang()+ "'";
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
        String query = "DELETE FROM " + TbKhachHang + " WHERE " + Ma_khach_hang + " LIKE '" + kh.getMaKhachHang() + "'";
        System.out.println(query);
        try {
            res = db.getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public boolean checkKhachHang(String mkh){
        boolean res=false; //san pham chua ton tai
        String query="Select * from "+TbKhachHang + " where "+Ma_khach_hang+ " LIKE '"+mkh+"'";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                String tenKH = result.getString(Ten_khach_hang);
                if (tenKH.equals(null) || tenKH.equals("")){
                    res = false;
                } else
                    res =true;
            }
            System.out.println(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
    
    //get list khach hang in db
    public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> mList=new ArrayList();
        String query="Select * from "+TbKhachHang;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                String maKH =result.getString(Ma_khach_hang);
                String tenKH =result.getString(Ten_khach_hang);
                String diaChi =result.getString(Dia_chi);
                String dienThoai =result.getString(So_dien_thoai);
                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, dienThoai);
                mList.add(kh);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    //get ten khach hang in db
    public String getTenKhachHang(String maKH){
        String res = "";
        String query="Select * from "+TbKhachHang + " WHERE " + Ma_khach_hang + " LIKE '" +maKH + "'";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                res = result.getString(Ten_khach_hang);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
    
    //get ten khach hang in db
    public KhachHang getKhachHang(String maKH){
        KhachHang res = new KhachHang();
        String query="Select * from "+TbKhachHang + " WHERE " + Ma_khach_hang + " LIKE '" +maKH + "'";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                String tenKH =result.getString(Ten_khach_hang);
                String diaChi =result.getString(Dia_chi);
                String dienThoai =result.getString(So_dien_thoai);
                res = new KhachHang(maKH, tenKH, diaChi, dienThoai);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
}
