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
import model.LoaiLinhKien;
import model.NguoiDung;

/**
 *
 * @author dtvta
 */
public class DbLoaiLinhKien {
    public CreateDb db;
    private ResultSet result=null;
    public String TbLoaiLinhKien="TbLoaiLinhKien";
    public String Ten_loai_linh_kien="Ten_loai_linh_kien";
    public String Id_loai_linh_kien="Id_loai_linh_kien";
    
    public DbLoaiLinhKien() {
        db=new CreateDb();
    }
    
    /*
        - Muc dich: them linh kien 
        - Gia tri tra ve: 
            + true: neu them linh kien khong thanh cong
            + false: neu them linh kien  thanh cong
        - Params: Loai Linh kien
    
    */
    public boolean insertLoaiLinhKien(LoaiLinhKien llk){
        boolean res=true;
        String query="Insert into " + TbLoaiLinhKien + "(" + Id_loai_linh_kien + ", " + Ten_loai_linh_kien + ") values" +
                        " ( null" + ", '" + llk.getTenLoaiLinhKien() + "')";
        System.out.println(query);
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            res=db.getStatement().execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DbLoaiLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res; 
    }
    
    //get list loai linh kien in db
    public ArrayList<LoaiLinhKien> getListLoaiLinhKien(){
        ArrayList<LoaiLinhKien> mList=new ArrayList();
        String query="Select * from "+TbLoaiLinhKien;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_loai_linh_kien);
                String ten=result.getString(Ten_loai_linh_kien);
                LoaiLinhKien lk=new LoaiLinhKien(id,ten);
                mList.add(lk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    
    public int getIdByName(String name){
        int id=0;
        String query="Select * from "+TbLoaiLinhKien + " where "+Ten_loai_linh_kien+ "= '"+name+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                id=result.getInt(Id_loai_linh_kien);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return id;
    }
}
