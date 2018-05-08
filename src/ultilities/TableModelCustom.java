/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities;

import databases.DbViTriLinhKien;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ViTriLinhKien;

/**
 *
 * @author dtvta
 */
public class TableModelCustom {
    
    public void showTableLoaiLinhKien(String[] column, JTable tb){
        ArrayList<ViTriLinhKien> list=new ArrayList<>();
        list=new DbViTriLinhKien().getListViTriLinhKien();
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
                    row[k]=list.get(j).getIdViTriLinhKien();
                else if (k==1) // cot 2
                    row[k]=list.get(j).getTenViTriLinhKien();
            }
                
            model.addRow(row);
        }
        

    }
}
