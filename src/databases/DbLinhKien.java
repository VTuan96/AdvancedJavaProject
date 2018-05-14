/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.LinhKien;
import model.LoaiLinhKien;
import model.ViTriLinhKien;

/**
 *
 * @author dtvta
 */
public class DbLinhKien {
    public CreateDb db;
    private ResultSet result=null;
    public String TbLinhKien="TbLinhKien";
    public String Id_linh_kien="Id_linh_kien";
    public String Ten_linh_kien="Ten_linh_kien";
    public String Hinh_anh="Hinh_anh";
    public String Loai_linh_kien_id="Loai_linh_kien_id";
    public String Vi_tri_linh_kien_id="Vi_tri_linh_kien_id";
//    public String Id_gia_linh_kien = "Id_gia_linh_kien";
    
    public DbLinhKien() {
        db=new CreateDb();
    }
    
    public boolean insertLinhKien(LinhKien lk){
        boolean res=true;
        String query="INSERT INTO `tblinhkien` (`" + Id_linh_kien + "`, `" + Ten_linh_kien +"`, `"+ Hinh_anh+
                "`, `"+ Loai_linh_kien_id + "`, `" + Vi_tri_linh_kien_id+
                "`) VALUES (NULL, '" + lk.getTenLinhKien()+ "', '" + lk.getHinhAnh() + "', '" + 
                lk.getLoaiLinhKienId() + "', '" +  lk.getViTriLinhKienId() + "')";
        System.out.println(query);
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            res=db.getStatement().execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return res; 
    }
    
    //get list loai linh kien in db
    public ArrayList<LinhKien> getListLinhKien(){
        ArrayList<LinhKien> mList=new ArrayList();
        String query="Select * from "+TbLinhKien;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_linh_kien);
                String tenLK=result.getString(Ten_linh_kien);
                String hinhAnh=result.getString(Hinh_anh);
                int idLLK=result.getInt(Loai_linh_kien_id);
                int idVTLK= result.getInt(Vi_tri_linh_kien_id);
//                int idLSP = result.getInt(Id_gia_linh_kien);
                LinhKien lk=new LinhKien(id, tenLK, hinhAnh, idLLK, idVTLK);
                
                mList.add(lk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    //lay list linh kien theo ten linh kien A-Z
    public ArrayList<LinhKien> getListLinhKienSortDown(){
        ArrayList<LinhKien> mList=new ArrayList();
        String query="Select * from "+ TbLinhKien + " ORDER BY " + Ten_linh_kien + " ASC" ;
        System.out.println(query);
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_linh_kien);
                String tenLK=result.getString(Ten_linh_kien);
                String hinhAnh=result.getString(Hinh_anh);
                int idLLK=result.getInt(Loai_linh_kien_id);
                int idVTLK= result.getInt(Vi_tri_linh_kien_id);
//                int idLSP = result.getInt(Id_gia_linh_kien);
                LinhKien lk=new LinhKien(id, tenLK, hinhAnh, idLLK, idVTLK);
                
                mList.add(lk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    //lay list linh kien theo ten linh kien Z-A
    public ArrayList<LinhKien> getListLinhKienSortUp(){
        ArrayList<LinhKien> mList=new ArrayList();
        String query="Select * from "+ TbLinhKien + " ORDER BY " + Ten_linh_kien + " DESC" ;
        System.out.println(query);
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_linh_kien);
                String tenLK=result.getString(Ten_linh_kien);
                String hinhAnh=result.getString(Hinh_anh);
                int idLLK=result.getInt(Loai_linh_kien_id);
                int idVTLK= result.getInt(Vi_tri_linh_kien_id);
//                int idLSP = result.getInt(Id_gia_linh_kien);
                LinhKien lk=new LinhKien(id, tenLK, hinhAnh, idLLK, idVTLK);
                
                mList.add(lk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    public int getIdLinhKien(String tenLK, int idLLK, int vtlk){
        int res=0;
        String query="Select * from "+ TbLinhKien + " WHERE " + Ten_linh_kien + 
                " LIKE '" + tenLK + "' AND "+ Loai_linh_kien_id + " = " +idLLK 
                +" AND "+ Vi_tri_linh_kien_id + " = " +vtlk;
        System.out.println(query);
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                res=result.getInt(Id_linh_kien);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
    
    //lay linh kien theo id linh kien
    public LinhKien getLinhKien(int id){
        LinhKien res = new LinhKien();
        String query="Select * from "+TbLinhKien + " where "+Id_linh_kien+ "= '"+id+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                String tenLK=result.getString(Ten_linh_kien);
                String hinhAnh=result.getString(Hinh_anh);
                int idLLK=result.getInt(Loai_linh_kien_id);
                int idVTLK= result.getInt(Vi_tri_linh_kien_id);
                res = new LinhKien(id, tenLK, hinhAnh, idLLK, idVTLK);
            }
            System.out.println(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
    
    public String getNameById(int id){
        String res="";
        String query="Select * from "+TbLinhKien + " where "+Id_linh_kien+ "= '"+id+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                res=result.getString(Ten_linh_kien);
            }
            System.out.println(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
}
