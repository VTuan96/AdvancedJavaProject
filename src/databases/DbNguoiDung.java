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
import model.NguoiDung;

/**
 *
 * @author dtvta
 */
public class DbNguoiDung {
    private CreateDb db;
    private ResultSet result=null;
    public static final String Ten_nguoi_dung="Ten_nguoi_dung";
    public static final String Mat_khau="Mat_khau";
    
    public DbNguoiDung() {
        db=new CreateDb();
    }
    
    public NguoiDung checkNguoiDung(String user, String pass){
        System.out.println(user+" , "+pass);
        NguoiDung res=null;
        String query="Select * from tbNguoiDung where "+Ten_nguoi_dung+" = '"+user+"' and "+Mat_khau+"='"+pass+"'";
        try {
            result=db.getStatement().executeQuery(query);
            while(result.next()){
                System.out.println(user+" , "+pass);
                res=new NguoiDung(user,pass);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
}
