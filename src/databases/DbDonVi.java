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
import model.DonVi;
import model.GiaLinhKien;
import model.LoaiLinhKien;

/**
 *
 * @author dtvta
 */
public class DbDonVi {
     public CreateDb db;
    private ResultSet result=null;
    public String TbDonVi="TbDonVi";
    public String Ten_don_vi = "Ten_don_vi";
    public String Id_don_vi = "Id_don_vi";
    
    public DbDonVi() {
        db=new CreateDb();
    }

    public boolean insertDonVi(DonVi dv){
        boolean res=true;
        String query="Insert into " + TbDonVi + "(" + Id_don_vi + ", " +
                Ten_don_vi + ") values" 
                + " ( null" + ", '" + dv.getTenDonVi() + "')";
        System.out.println(query);
        
        try {
            //excute() function true if the first result is a ResultSet object;
            //false if it is an update count or there are no results
            //check lpai linh kien in database
            boolean check = checkDonVi(dv.getTenDonVi());
            if (!check) //loai linh kien chua co trong co so du lieu
                res=db.getStatement().execute(query);
            else 
                res=true;
        } catch (SQLException ex) {
            Logger.getLogger(DbLoaiLinhKien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res; 
    }
    
    public boolean checkDonVi(String name){
        boolean res=false; //san pham chua ton tai
        String query="Select * from "+TbDonVi + " where "+Ten_don_vi+ " LIKE '"+name+"'";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id = result.getInt(Id_don_vi);
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
    
    //get list loai linh kien in db
    public ArrayList<DonVi> getListDonVi(){
        ArrayList<DonVi> mList=new ArrayList();
        String query="Select * from "+TbDonVi;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_don_vi);
                String ten=result.getString(Ten_don_vi);
                DonVi dv=new DonVi(id,ten);
                mList.add(dv);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
    
    public int getIdByName(String name){
        int id=0;
        String query="Select * from "+TbDonVi + " where "+Ten_don_vi+ "= '"+name+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                id=result.getInt(Id_don_vi);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return id;
    }
    
    public String getNameById(int id){
        String res="";
        String query="Select * from "+TbDonVi + " where "+Id_don_vi+ "= '"+id+" '";
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                res=result.getString(Ten_don_vi);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return res;
    }
}
