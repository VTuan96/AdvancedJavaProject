/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities;

import databases.DbDonVi;
import databases.DbLoaiLinhKien;
import databases.DbLoaiSanPham;
import databases.DbViTriLinhKien;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DonVi;
import model.LinhKien;
import model.LoaiLinhKien;
import model.LoaiSanPham;
import model.ViTriLinhKien;

/**
 *
 * @author dtvta
 */
public class TableModelCustom {
    
    public void showTableLoaiLinhKien(String[] column, JTable tb){
        ArrayList<LoaiLinhKien> list=new ArrayList<>();
        list=new DbLoaiLinhKien().getListLoaiLinhKien();
//        String[] column=new String[]{"ID", "Ten vi tri linh kien"};
        
        //cap nhat lai model cho table
        DefaultTableModel model=(DefaultTableModel) tb.getModel();
        model.setRowCount(0); //set so dong = 0
        model.setColumnCount(0); //set so cot =0
        
        //them cot vao model
        for( int i=0 ; i<column.length ; i++){
            model.addColumn(column[i]);
        }
        
        //them dong vao model
        Object[] row=new Object[column.length];
        for (int j=0 ; j<list.size() ; j++){
            //k cot
            for (int k=0 ; k<column.length ; k++){
                if(k==0) //cot 1
                    row[k]=list.get(j).getIdLoaiLinhKien();
                else if (k==1) // cot 2
                    row[k]=list.get(j).getTenLoaiLinhKien();
            }
                
            model.addRow(row);
        }
    }
    
        public void showTableLinhKien(ArrayList<LinhKien> list, JTable tb) {
        
        //cap nhat lai model cho table
        DefaultTableModel model=(DefaultTableModel) tb.getModel();
        model.setRowCount(0); //set so dong = 0
        model.setColumnCount(0); //set so cot =0
        
        //them cot vao model
        for( int i=0 ; i<Contants.columnLK.length ; i++){
            model.addColumn(Contants.columnLK[i]);
        }
        
        //them dong vao model
        Object[] row=new Object[Contants.columnLK.length];
        for (int j=0 ; j<list.size() ; j++){
            //k cot
            for (int k=0 ; k<Contants.columnLK.length ; k++){
                if(k==0) //cot 1, ID
                    row[k]=list.get(j).getIdLinhKien();
                else if (k==1) // cot 2, Ten linh kien
                    row[k]=list.get(j).getTenLinhKien();
                else if (k==2) //hinh anh
                    row[k] = list.get(j).getHinhAnh();
                else if (k==3) //Ten loai linh kien
                {
                    int idLLK = list.get(j).getLoaiLinhKienId();
                    row[k] = new DbLoaiLinhKien().getNameById(idLLK);
                }
                else if (k==4) //Vi tri linh kien
                {
                    int idVTLK = list.get(j).getViTriLinhKienId();
                    row[k] = new DbViTriLinhKien().getNameById(idVTLK);
                }
                    
                    
                   
            }
                
            model.addRow(row);
        }
    }
    
    public void showDataTable(String[] column, JTable tb, String category){
        //cap nhat lai model cho table
        DefaultTableModel model=(DefaultTableModel) tb.getModel();
        model.setRowCount(0); //set so dong = 0
        model.setColumnCount(0); //set so cot =0
        
        //them cot vao model
        for( int i=0 ; i<column.length ; i++){
            model.addColumn(column[i]);
        }
        
        if (category.equals(Contants.THEM_DON_VI)){
            ArrayList<DonVi> list=new ArrayList<>();
            list = new DbDonVi().getListDonVi();
            
            //them dong vao model
            Object[] row=new Object[column.length];
            for (int j=0 ; j<list.size() ; j++){
                //k cot
                for (int k=0 ; k<column.length ; k++){
                    if(k==0) //cot 1
                        row[k]=list.get(j).getIdDonVi();
                    else if (k==1) // cot 2
                        row[k]=list.get(j).getTenDonVi();
                }

                model.addRow(row);
            }
        } else if (category.equals(Contants.THEM_LOAI_SAN_PHAM)){
            ArrayList<LoaiSanPham> list=new ArrayList<>();
            list = new DbLoaiSanPham().getListLoaiSanPham();
            
            //them dong vao model
            Object[] row=new Object[column.length];
            for (int j=0 ; j<list.size() ; j++){
                //k cot
                for (int k=0 ; k<column.length ; k++){
                    if(k==0) //cot 1
                        row[k]=list.get(j).getIdLoaiSanPham();
                    else if (k==1) // cot 2
                        row[k]=list.get(j).getTenLoaiSanPham();
                }

                model.addRow(row);
            }
        } else if (category.equals(Contants.THEM_VI_TRI_LINH_KIEN)){
            ArrayList<ViTriLinhKien> list=new ArrayList<>();
            list = new DbViTriLinhKien().getListViTriLinhKien();
            
            //them dong vao model
            Object[] row=new Object[column.length];
            for (int j=0 ; j<list.size() ; j++){
                //k cot
                for (int k=0 ; k<column.length ; k++){
                    if(k==0) //cot 1
                        row[k]=list.get(j).getIdViTriLinhKien();
                    else if (k==1) // cot 2
                        row[k]=list.get(j).getTenViTriLinhKien();
                }

                model.addRow(row);
            }
        }
        
        
        
        
        

    }
}
