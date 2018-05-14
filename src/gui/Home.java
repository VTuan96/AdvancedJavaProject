/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import databases.DbDonVi;
import databases.DbGiaLinhKien;
import databases.DbLinhKien;
import databases.DbLoaiLinhKien;
import databases.DbLoaiSanPham;
import databases.DbViTriLinhKien;
import gui.ThemLoaiLinhKien;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.DonVi;
import model.GiaLinhKien;
import model.LinhKien;
import model.LoaiLinhKien;
import model.LoaiSanPham;
import model.ViTriLinhKien;
import ultilities.Contants;
import ultilities.ImageProcess;
import ultilities.TableModelCustom;

/**
 *
 * @author dtvta
 */
public class Home extends javax.swing.JFrame {
    
    private String urlHinhAnh;
    private String loaiLK;
    private String viTriLK;
    
    private String loaiSP = "";
    
    private String search = "";
    
    private LinhKien selectionLK = new LinhKien();
    private GiaLinhKien selectionGLK = new GiaLinhKien();
    private String ngayNhap = "";
    
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        
        setLocationRelativeTo(null);
        setupDataForAllCombobox();
        
        cbSearch.addItem(Contants.TEN_LINH_KIEN);
        cbSearch.addItem(Contants.TEN_LOAI_LINH_KIEN);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format=new SimpleDateFormat("yyy/MM/dd");
        Date date = cal.getTime();
        ngayNhap=format.format(date).toString();
        
        loaiSP = cbLoaiSanPham.getSelectedItem().toString();
        
        //item listener cho combo box Loai San Pham
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //kiem tra gia tri thay doi co bang gia tri chon trong combo box khong?
                if (e.getStateChange() == ItemEvent.SELECTED){ 
                    loaiSP = e.getItem().toString();
                    setupDataForCbLoaiLinhKien();
                }
            }
        };
        
        cbLoaiSanPham.addItemListener(itemListener);
        
        ArrayList<GiaLinhKien> list=new ArrayList<>();
        list=new DbGiaLinhKien().getListGiaLinhKien();
        updateTable(list);
        
        tbLinhKien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tbLinhKien.getModel().getRowCount() > 0 ){
                    int idLK = (int) tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 0);
                    String tenLK = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 1).toString();
                    String hinhAnh = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 2).toString();
                    String ngayNhap = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 3).toString();
                    String giaNhap = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 4).toString();
                    String giaBan = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 5).toString();
                    String donVi = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 6).toString();
                    String loaiLK = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 7).toString();
                    String viTriLK = tbLinhKien.getValueAt(tbLinhKien.getSelectedRow(), 8).toString();

                    int idLLK = new DbLoaiLinhKien().getIdByName(loaiLK);
                    int idVTLK = new DbViTriLinhKien().getIdByName(viTriLK);

                    selectionLK = new LinhKien(idLK, tenLK, hinhAnh, idLLK, idVTLK);
                    selectionGLK = new DbGiaLinhKien().getGiaLinhKien(idLK);

                    txtTenLinhKien.setText(tenLK);
                    txtGiaBan.setText(giaBan);
                    txtGiaNhap.setText(giaNhap);
                    txtHinhAnh.setText(hinhAnh);

                    cbDonVi.setSelectedItem(donVi);
                    cbLoaiLinhKien.setSelectedItem(loaiLK);
                    cbViTriLinhKien.setSelectedItem(viTriLK);

                    try{
                        File file = new File(hinhAnh);
                        BufferedImage buff=ImageIO.read(file);
                        BufferedImage img=new ImageProcess(buff).resizeImage(buff,lblHinhAnh.getWidth(), lblHinhAnh.getHeight());

                        lblHinhAnh.setIcon(new ImageIcon(img));
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }   
            }
        });
        
    }
    
    private void setupDataForCbDonVi(){
        cbDonVi.removeAllItems();
        ArrayList<DonVi> listDV=new ArrayList<>();
        listDV=new DbDonVi().getListDonVi();
        int lenDV=listDV.size();
        System.err.println(lenDV);
        for (int i=0 ; i<lenDV; i++){
            cbDonVi.addItem(listDV.get(i).getTenDonVi());
        }
    }
    
    private void setupDataForCbLoaiSanPham(){
        cbLoaiLinhKien.removeAllItems();
        ArrayList<LoaiSanPham> listLSP=new ArrayList<>();
        listLSP=new DbLoaiSanPham().getListLoaiSanPham();
        int lenLSP=listLSP.size();
        for (int i=0 ; i<lenLSP; i++){
            cbLoaiSanPham.addItem(listLSP.get(i).getTenLoaiSanPham());
        }
    }
    
    private void setupDataForCbLoaiLinhKien(){
        cbLoaiLinhKien.removeAllItems();
        loaiSP = cbLoaiSanPham.getSelectedItem().toString();
        ArrayList<LoaiLinhKien> listLoaiLK=new ArrayList<>();
        listLoaiLK=new DbLoaiLinhKien().getListLoaiLinhKienByLoaiSP(loaiSP);
        int lenLLK=listLoaiLK.size();
        for (int i=0 ; i<lenLLK; i++){
            cbLoaiLinhKien.addItem(listLoaiLK.get(i).getTenLoaiLinhKien());
        }
    }
    
    private void setupDataForCbViTriLinhKien(){
        cbViTriLinhKien.removeAllItems();
        ArrayList<ViTriLinhKien> listVTLK=new ArrayList<>();
        listVTLK=new DbViTriLinhKien().getListViTriLinhKien();
        int lenVTLK=listVTLK.size();
        for (int i=0 ; i<lenVTLK; i++){
            cbViTriLinhKien.addItem(listVTLK.get(i).getTenViTriLinhKien());
        }
    }
    
    private void setupDataForAllCombobox(){
        //set data for combobox
        setupDataForCbLoaiSanPham();
        setupDataForCbDonVi();
        setupDataForCbLoaiLinhKien();
        setupDataForCbViTriLinhKien();
        
    }
    
    public void updateTable(ArrayList<GiaLinhKien> list) {
        
        //cap nhat lai model cho table
        DefaultTableModel model=(DefaultTableModel) tbLinhKien.getModel();
        model.setRowCount(0); //set so dong = 0
        model.setColumnCount(0); //set so cot =0
        
        //them cot vao model
        for( int i=0 ; i<Contants.columnLK.length ; i++){
            model.addColumn(Contants.columnLK[i]);
        }
        
        //them dong vao model
        Object[] row=new Object[Contants.columnLK.length];
        for (int j=0 ; j<list.size() ; j++){
            int idLK = list.get(j).getIdLinhKien();
            LinhKien lk = new DbLinhKien().getLinhKien(idLK);
            
            //k cot
            for (int k=0 ; k<Contants.columnLK.length ; k++){
                if(k==0) //cot 1, ID
                {
                    row[k]=idLK;
                } 
                else if (k==1) // cot 2, Ten linh kien
                {
                    String tenLK = new DbLinhKien().getNameById(idLK);
                    row[k]= tenLK;
                } 
                else if (k==2) //hinh anh
                    row[k] = lk.getHinhAnh();
                else if (k==3) //ngay nhap
                    row[k] = list.get(j).getNgayNhap();
                else if (k==4) //gia nhap
                    row[k] = list.get(j).getGiaNhap();
                else if (k==5) //gia ban
                    row[k] = list.get(j).getGiaBan();
                else if (k==6) //don vi
                {
                    int idDV = list.get(j).getIdDonVi();
                    row[k] = new DbDonVi().getNameById(idDV);
                }
                else if (k==7) //Ten loai linh kien
                {
                    int idLLK = lk.getLoaiLinhKienId();
                    row[k] = new DbLoaiLinhKien().getNameById(idLLK);
                }
                else if (k==8) //Vi tri linh kien
                {
                    int idVTLK = lk.getViTriLinhKienId();
                    row[k] = new DbViTriLinhKien().getNameById(idVTLK);
                }             
            }              
            model.addRow(row);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbLoaiLinhKien = new javax.swing.JComboBox<>();
        cbViTriLinhKien = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtHinhAnh = new javax.swing.JTextField();
        btnBrowser = new javax.swing.JButton();
        lblHinhAnh = new javax.swing.JLabel();
        btnThemLinhKien = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbDonVi = new javax.swing.JComboBox<>();
        cbLoaiSanPham = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenLinhKien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLinhKien = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cbSearch = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnuThemLoaiLinhKien = new javax.swing.JMenuItem();
        mnuThemViTriLinhKien = new javax.swing.JMenuItem();
        mnuThemDonVi = new javax.swing.JMenuItem();
        mnuThemLoaiSanPham = new javax.swing.JMenuItem();
        mnuSapXepTang = new javax.swing.JMenu();
        mnuSortDown = new javax.swing.JMenuItem();
        mnuSortUp = new javax.swing.JMenuItem();
        mnuTaoHoaDon = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm linh kiện"));

        jLabel5.setText("Loại sản phẩm");

        jLabel6.setText("Vị trí linh kiện");

        cbLoaiLinhKien.setForeground(new java.awt.Color(255, 255, 255));
        cbLoaiLinhKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiLinhKienActionPerformed(evt);
            }
        });

        cbViTriLinhKien.setPreferredSize(new java.awt.Dimension(20, 20));
        cbViTriLinhKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbViTriLinhKienActionPerformed(evt);
            }
        });

        jLabel7.setText("Hình ảnh");

        btnBrowser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_search.png"))); // NOI18N
        btnBrowser.setText("Browser");
        btnBrowser.setIconTextGap(10);
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });

        lblHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinhAnh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThemLinhKien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_add.png"))); // NOI18N
        btnThemLinhKien.setText("Thêm");
        btnThemLinhKien.setIconTextGap(10);
        btnThemLinhKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLinhKienActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_edit.png"))); // NOI18N
        btnEdit.setText("Cập nhật");
        btnEdit.setIconTextGap(10);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setIconTextGap(10);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá nhập");
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 15));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("(Hình ảnh)");

        cbDonVi.setForeground(new java.awt.Color(255, 255, 255));
        cbDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDonViActionPerformed(evt);
            }
        });

        cbLoaiSanPham.setPreferredSize(new java.awt.Dimension(20, 20));
        cbLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel10.setText("Loại linh kiện");

        jLabel11.setText("Đơn vị");

        jLabel4.setText("Giá bán");
        jLabel4.setPreferredSize(new java.awt.Dimension(40, 15));

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên linh kiện");
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 15));

        txtTenLinhKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLinhKienActionPerformed(evt);
            }
        });

        jLabel8.setText("VNĐ");

        jLabel9.setText("VNĐ");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setIconTextGap(8);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTenLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbLoaiLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThemLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEdit)
                                        .addGap(52, 52, 52)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbViTriLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(298, 298, 298))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel9)
                                    .addGap(40, 40, 40)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135)))
                        .addComponent(btnBrowser)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBrowser)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbViTriLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbLoaiLinhKien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemLinhKien)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete)
                            .addComponent(btnRefresh)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng linh kiện"));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setIconTextGap(10);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tbLinhKien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbLinhKien);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_print.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.setIconTextGap(10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(92, 92, 92))
        );

        jMenu2.setText("Thêm");

        mnuThemLoaiLinhKien.setText("Thêm loại linh kiện");
        mnuThemLoaiLinhKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThemLoaiLinhKienActionPerformed(evt);
            }
        });
        jMenu2.add(mnuThemLoaiLinhKien);

        mnuThemViTriLinhKien.setText("Thêm vị trí linh kiện");
        mnuThemViTriLinhKien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThemViTriLinhKienActionPerformed(evt);
            }
        });
        jMenu2.add(mnuThemViTriLinhKien);

        mnuThemDonVi.setText("Thêm đơn vị");
        mnuThemDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThemDonViActionPerformed(evt);
            }
        });
        jMenu2.add(mnuThemDonVi);

        mnuThemLoaiSanPham.setText("Thêm loại sản phẩm");
        mnuThemLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuThemLoaiSanPhamActionPerformed(evt);
            }
        });
        jMenu2.add(mnuThemLoaiSanPham);

        jMenuBar1.add(jMenu2);

        mnuSapXepTang.setText("Sắp xếp linh kiện");

        mnuSortDown.setText("Theo bảng chữ cái từ A-Z");
        mnuSortDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSortDownActionPerformed(evt);
            }
        });
        mnuSapXepTang.add(mnuSortDown);

        mnuSortUp.setText("Theo bảng chữ cái từ Z-A");
        mnuSortUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSortUpActionPerformed(evt);
            }
        });
        mnuSapXepTang.add(mnuSortUp);

        jMenuBar1.add(mnuSapXepTang);

        mnuTaoHoaDon.setText("Tạo hóa đơn");
        mnuTaoHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuTaoHoaDonMouseClicked(evt);
            }
        });
        mnuTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTaoHoaDonActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuTaoHoaDon);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1351, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSortDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSortDownActionPerformed
        // TODO add your handling code here:
        ArrayList<LinhKien> listLK = new ArrayList<>();
        listLK = new DbLinhKien().getListLinhKienSortDown();
        
        ArrayList<GiaLinhKien> list=new ArrayList<>();
        for (LinhKien lk : listLK ){
            GiaLinhKien glk = new DbGiaLinhKien().getGiaLinhKien(lk.getIdLinhKien());
            list.add(glk);
        }
        updateTable(list);
        
    }//GEN-LAST:event_mnuSortDownActionPerformed

    private void mnuThemLoaiLinhKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThemLoaiLinhKienActionPerformed
        // TODO add your handling code here:
        ThemLoaiLinhKien them = new ThemLoaiLinhKien();
        them.show();
    }//GEN-LAST:event_mnuThemLoaiLinhKienActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void mnuThemViTriLinhKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThemViTriLinhKienActionPerformed
        // TODO add your handling code here:
        Them them = new Them(Contants.THEM_VI_TRI_LINH_KIEN);
        them.show();
    }//GEN-LAST:event_mnuThemViTriLinhKienActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void mnuSortUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSortUpActionPerformed
        // TODO add your handling code here:
        ArrayList<LinhKien> listLK = new ArrayList<>();
        listLK = new DbLinhKien().getListLinhKienSortUp();
        
        ArrayList<GiaLinhKien> list=new ArrayList<>();
        for (LinhKien lk : listLK ){
            GiaLinhKien glk = new DbGiaLinhKien().getGiaLinhKien(lk.getIdLinhKien());
            list.add(glk);
        }
        updateTable(list);
    }//GEN-LAST:event_mnuSortUpActionPerformed

    private void txtTenLinhKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLinhKienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLinhKienActionPerformed

    private void btnThemLinhKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLinhKienActionPerformed
        // TODO add your handling code here:

        String tenLK = txtTenLinhKien.getText().toString();
        String giaNhap = txtGiaNhap.getText().toString();
        String giaBan = txtGiaBan.getText().toString();

        loaiLK = cbLoaiLinhKien.getSelectedItem().toString();
        int idLoaiLK=new DbLoaiLinhKien().getIdByName(loaiLK);

        viTriLK = cbViTriLinhKien.getSelectedItem().toString();
        int idVTLK=new DbViTriLinhKien().getIdByName(viTriLK);

        String donVi = cbDonVi.getSelectedItem().toString();
        int idDV = new DbDonVi().getIdByName(donVi);
       
        LinhKien lk=new LinhKien(tenLK,urlHinhAnh, idLoaiLK, idVTLK);
        boolean check = new DbLinhKien().insertLinhKien(lk);
        if(!check){
            int idLK = new DbLinhKien().getIdLinhKien(tenLK, idLoaiLK, idVTLK);
            System.err.println(idLK);
            if (idLK > 0){
                GiaLinhKien glk = new GiaLinhKien(giaNhap, giaBan, ngayNhap, idDV, idLK);
                boolean checkInsert = new DbGiaLinhKien().insertGiaLinhKien(glk);
            
                if (!checkInsert){
                    ThongBao thongBao = new ThongBao(Contants.INSERT_SUCCESS);
                    thongBao.show();

                    //xoa het du lieu trong cac text component
                    clearAllTextField();
                    lblHinhAnh.setIcon(null);

                    //cap nhat lai bang linh kien
                    ArrayList<GiaLinhKien> list=new ArrayList<>();
                    list=new DbGiaLinhKien().getListGiaLinhKien();
                    updateTable(list);
                }  
            }
        } else {
            ThongBao thongBao = new ThongBao(Contants.INSERT_FAIL);
            thongBao.show();
        }
    }//GEN-LAST:event_btnThemLinhKienActionPerformed

    private void btnBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();

            //lay duong dan link anh
            String pathFile = file.getAbsolutePath();
            urlHinhAnh = pathFile;
            
            //thay the dau \ = dau \\\  ( 1 dau \ = 1 dau \\
            urlHinhAnh = urlHinhAnh.replace("\\" , "\\\\"  );
            
            //luu link anh vao co so du lieu
            try {
                BufferedImage buff=ImageIO.read(file);
                BufferedImage img=new ImageProcess(buff).resizeImage(buff,lblHinhAnh.getWidth(), lblHinhAnh.getHeight());

                lblHinhAnh.setIcon(new ImageIcon(img));
                txtHinhAnh.setText(urlHinhAnh);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBrowserActionPerformed

    private void cbViTriLinhKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbViTriLinhKienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbViTriLinhKienActionPerformed

    private void cbLoaiLinhKienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiLinhKienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiLinhKienActionPerformed

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        ArrayList<GiaLinhKien> listGLK = new ArrayList<>();
        search = txtSearch.getText().toString();
        String selectSearch = cbSearch.getSelectedItem().toString();

        if (selectSearch.equals(Contants.TEN_LINH_KIEN)){
            System.err.println(Contants.TEN_LINH_KIEN);
            ArrayList<LinhKien> listLK = new DbLinhKien().getListLinhKien(search);
            for (LinhKien item : listLK){
                GiaLinhKien glk = new DbGiaLinhKien().getGiaLinhKien(item.getIdLinhKien());
                listGLK.add(glk);
            }
            
        } else if (selectSearch.equals(Contants.TEN_LOAI_LINH_KIEN)){
            int idLLK = new DbLoaiLinhKien().getIdByName(search);
            ArrayList<LinhKien> listLK = new DbLinhKien().getListLinhKien(idLLK);
            for (LinhKien item : listLK){
                GiaLinhKien glk = new DbGiaLinhKien().getGiaLinhKien(item.getIdLinhKien());
                listGLK.add(glk);
            }
            System.err.println(Contants.TEN_LOAI_LINH_KIEN);
        }
        
        
        updateTable(listGLK);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDonViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDonViActionPerformed

    private void cbLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiSanPhamActionPerformed

    private void mnuThemDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThemDonViActionPerformed
        // TODO add your handling code here:
        Them them = new Them(Contants.THEM_DON_VI);
        them.show();
    }//GEN-LAST:event_mnuThemDonViActionPerformed

    private void mnuThemLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuThemLoaiSanPhamActionPerformed
        // TODO add your handling code here:
        Them them = new Them(Contants.THEM_LOAI_SAN_PHAM);
        them.show();
    }//GEN-LAST:event_mnuThemLoaiSanPhamActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clearAllField();
        setupDataForAllCombobox();
        
        //cap nhat lai bang linh kien
        ArrayList<GiaLinhKien> list = new ArrayList<>();
        list = new DbGiaLinhKien().getListGiaLinhKien();
        updateTable(list);
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String tenLK = txtTenLinhKien.getText().toString();
        String hinhAnh = txtHinhAnh.getText().toString();
        hinhAnh = hinhAnh.replace("\\", "\\\\");
        String viTriLK = cbViTriLinhKien.getSelectedItem().toString();
        int idVTLK = new DbViTriLinhKien().getIdByName(viTriLK);
        String loaiLK = cbLoaiLinhKien.getSelectedItem().toString();
        int idLLK = new DbLoaiLinhKien().getIdByName(loaiLK);
        int idLK = selectionLK.getIdLinhKien();
        
        String giaNhap = txtGiaNhap.getText().toString();
        String giaBan = txtGiaBan.getText().toString();
        String donVi = cbDonVi.getSelectedItem().toString();
        int idDV = new DbDonVi().getIdByName(donVi);
        String loaiSP = cbLoaiSanPham.getSelectedItem().toString();
        int idLSP = new DbLoaiSanPham().getIdByName(loaiSP );
        
        selectionLK = new LinhKien(idLK, tenLK, hinhAnh, idLLK, idVTLK);
        int res = new DbLinhKien().updateLinhKien(selectionLK);
        if (res > 0 ){
            int idGLK = selectionGLK.getIdGiaLinhKien();
            selectionGLK = new GiaLinhKien(idGLK, giaNhap, giaBan,ngayNhap, idDV, idLK);
            int res_final = new DbGiaLinhKien().updateGiaLinhKien(selectionGLK);
            if (res_final > 0){
                ThongBao thongBao = new ThongBao(Contants.UPDATE_SUCCESS);
                thongBao.show();
                
                //cap nhat lai bang linh kien
                ArrayList<GiaLinhKien> list = new ArrayList<>();
                list = new DbGiaLinhKien().getListGiaLinhKien();
                updateTable(list);
            }
        } else {
            ThongBao thongBao = new ThongBao(Contants.UPDATE_FAIL);
            thongBao.show();
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int res = new DbLinhKien().deleteLinhKien(selectionLK);
        if (res > 0 ){
            int res_final = new DbGiaLinhKien().deleteGiaLinhKien(selectionGLK);
            if (res_final > 0){
                ThongBao thongBao = new ThongBao(Contants.DELETE_SUCCESS);
                thongBao.show();
                
                //cap nhat lai bang linh kien
                ArrayList<GiaLinhKien> list = new ArrayList<>();
                list = new DbGiaLinhKien().getListGiaLinhKien();
                updateTable(list);
            }
        } else {
            ThongBao thongBao = new ThongBao(Contants.DELETE_FAIL);
            thongBao.show();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void mnuTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTaoHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuTaoHoaDonActionPerformed

    private void mnuTaoHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuTaoHoaDonMouseClicked
        // TODO add your handling code here:
//        this.setVisible(false);
        TaoHoaDon taoHD = new TaoHoaDon();
        taoHD.show();
    }//GEN-LAST:event_mnuTaoHoaDonMouseClicked
    
    private void clearAllTextField(){
        txtTenLinhKien.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtHinhAnh.setText("");
        txtSearch.setText("");
        txtTenLinhKien.requestFocus(true);
    }
    private void clearAllField(){
        clearAllTextField();
        lblHinhAnh.setIcon(null);
        cbDonVi.removeAllItems();
        cbLoaiLinhKien.removeAllItems();
        cbLoaiSanPham.removeAllItems();
        cbViTriLinhKien.removeAllItems();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowser;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThemLinhKien;
    private javax.swing.JComboBox<String> cbDonVi;
    private javax.swing.JComboBox<String> cbLoaiLinhKien;
    private javax.swing.JComboBox<String> cbLoaiSanPham;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JComboBox<String> cbViTriLinhKien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JMenu mnuSapXepTang;
    private javax.swing.JMenuItem mnuSortDown;
    private javax.swing.JMenuItem mnuSortUp;
    private javax.swing.JMenu mnuTaoHoaDon;
    private javax.swing.JMenuItem mnuThemDonVi;
    private javax.swing.JMenuItem mnuThemLoaiLinhKien;
    private javax.swing.JMenuItem mnuThemLoaiSanPham;
    private javax.swing.JMenuItem mnuThemViTriLinhKien;
    private javax.swing.JTable tbLinhKien;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHinhAnh;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenLinhKien;
    // End of variables declaration//GEN-END:variables
}
