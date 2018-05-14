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
import model.LoaiSanPham;

/**
 *
 * @author dtvta
 */
public class DbLoaiSanPham {
    public CreateDb db;
    private ResultSet result=null;
    public String TbLoaiSanPham="TbLoaiSanPham";
    public String Ten_loai_san_pham="Ten_loai_san_pham";
    public String Id_loai_san_pham = "Id_loai_san_pham";
    
    public DbLoaiSanPham() {
        db=new CreateDb();
    }

    public boolean insertLoaiSanPham(LoaiSanPham lsp){
        boolean res=true;
        String query="Insert into " + TbLoaiSanPham + "(" + Id_loai_san_pham + ", " +
                Ten_loai_san_pham + ") values" + " ( null" + ", '" 
                + lsp.getTenLoaiSanPham() +"')";
        System.out.println(query);
        
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            //check lpai linh kien in database
            boolean check = checkLoaiSanPham(lsp.getTenLoaiSanPham());
            if (!check) //loai linh kien chua co trong co so du lieu
                res=db.getStatement().execute(query);
            else 
                res=true;
        } catch (SQLException ex) {
            Logger.getLogger(DbLoaiLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res; 
    }
    
    //get list san pham in db
    public ArrayList<LoaiSanPham> getListLoaiSanPham(){
        ArrayList<LoaiSanPham> mList=new ArrayList();
        String query="Select * from "+TbLoaiSanPham;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_loai_san_pham);
                String ten=result.getString(Ten_loai_san_pham);
                LoaiSanPham lsp=new LoaiSanPham(id,ten);
                mList.add(lsp);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    
    public int getIdByName(String name){
        int id=0;
        String query="Select * from "+TbLoaiSanPham + " where "+Ten_loai_san_pham+ "= '"+name+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                id=result.getInt(Id_loai_san_pham);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return id;
    }
    
    public String getNameById(int id){
        String res="";
        String query="Select * from "+TbLoaiSanPham + " where "+Id_loai_san_pham+ "= '"+id+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                res=result.getString(Ten_loai_san_pham);
            }
            System.out.println(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
    
    public boolean checkLoaiSanPham(String name){
        boolean res=false; //san pham chua ton tai
        String query="Select * from "+TbLoaiSanPham + " where "+Ten_loai_san_pham+ " LIKE '"+name+"'";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id = result.getInt(Id_loai_san_pham);
                if (id >0){
                    res = true;
                } else
                    res =false;
            }
            System.out.println(query);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
}
