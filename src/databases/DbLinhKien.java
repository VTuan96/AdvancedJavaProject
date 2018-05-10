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
    public String Ngay_nhap="Ngay_nhap";
    public String Gia_ban="Gia_ban";
    public String Gia_nhap="Gia_nhap";
    public String Loai_linh_kien_id="Loai_linh_kien_id";
    public String Vi_tri_linh_kien_id="Vi_tri_linh_kien_id";
    
    
    public DbLinhKien() {
        db=new CreateDb();
    }
    
    public boolean insertViTriLinhKien(LinhKien lk){
        boolean res=true;
        String query="INSERT INTO `tblinhkien` (`" + Id_linh_kien + "`, `" + Ten_linh_kien +"`, `"+ Hinh_anh+
                "`, `"+ Ngay_nhap+ "`, `"+  Gia_nhap +"`, `" + Gia_ban+ "`, `" +Loai_linh_kien_id + "`, `" + Vi_tri_linh_kien_id+
                "`) VALUES (NULL, '" + lk.getTenLinhKien()+ "', '" + lk.getHinhAnh() + "', '" + lk.getNgayNhap()+ "', '" +lk.getGiaNhap() +
                "', '" + lk.getGiaBan() + "', '" + lk.getLoaiLinhKienId() + "', '" +  lk.getViTriLinhKienId() + "')";
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
                String ngayNhap=result.getString(Ngay_nhap);
                String giaNhap=result.getString(Gia_nhap);
                String giaBan = result.getString(Gia_ban);
                int idLLK=result.getInt(Loai_linh_kien_id);
                int idVTLK= result.getInt(Vi_tri_linh_kien_id);
                LinhKien lk=new LinhKien(id, tenLK, hinhAnh, ngayNhap, giaNhap, giaBan, idLLK, idVTLK);
                
                mList.add(lk);
            }
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return mList;
    }
}
