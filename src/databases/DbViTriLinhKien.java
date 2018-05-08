/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.LoaiLinhKien;
import model.ViTriLinhKien;
import java.util.logging.Logger;

/**
 *
 * @author dtvta
 */
public class DbViTriLinhKien {
    public CreateDb db;
    private ResultSet result=null;
    public String TbViTriLinhKien="TbViTriLinhKien";
    public String Ten_vi_tri_linh_kien="Ten_vi_tri_linh_kien";
    public String Id_vi_tri_linh_kien="Id_vi_tri_linh_kien";
    
    public DbViTriLinhKien() {
        db=new CreateDb();
    }
    
    public boolean insertViTriLinhKien(ViTriLinhKien vtlk){
        boolean res=true;
        String query="Insert into " + TbViTriLinhKien + "(" + Id_vi_tri_linh_kien + ", " + Ten_vi_tri_linh_kien + ") values" +
                        " ( null" + ", '" + vtlk.getTenViTriLinhKien()+ "')";
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
    
    //get list loai vi tri linh kien in db
    public ArrayList<ViTriLinhKien> getListViTriLinhKien(){
        ArrayList<ViTriLinhKien> mList=new ArrayList();
        String query="Select * from "+TbViTriLinhKien;
        try{
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                int id=result.getInt(Id_vi_tri_linh_kien);
                String ten=result.getString(Ten_vi_tri_linh_kien);
                ViTriLinhKien lk=new ViTriLinhKien(id,ten);
                mList.add(lk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
}
