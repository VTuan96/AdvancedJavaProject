/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities;

/**
 *
 * @author dtvta
 */
public class Contants {
    public static String THEM_VI_TRI_LINH_KIEN = " THÊM VỊ TRÍ LINH KIỆN";
    public static String THEM_LOAI_LINH_KIEN = " THÊM LOẠI LINH KIỆN";
    public static String THEM_LOAI_SAN_PHAM = " THÊM LOẠI SẢN PHẨM";
    public static String THEM_DON_VI = " THÊM ĐƠN VỊ";
    
    public static String[] columnVTLK=new String[]{"ID", "Tên vị trí linh kiện"};
    public static String[] columnLLK=new String[]{"ID", "Tên loại linh kiện"};
    public static String[] columnLSP=new String[]{"ID", "Tên loại sản phẩm"};
    public static String[] columnDV=new String[]{"ID", "Tên đơn vị"};
    public static String columnLK[]={"ID", "Tên linh kiện", "Hình ảnh", "Ngày nhập", "Giá nhập",
                            "Giá bán", "Đơn vị", "Loại linh kiện", "Vị trí linh kiện"};
    public static String columnKH[]={"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"};
    public static String columnCTHD[]={"STT", "Tên linh kiện", "Đơn vị", "Đơn giá", "Số lượng", "Thành tiền"};
    
    public static String TEN_DON_VI = "Tên đơn vị";
    public static String TEN_LOAI_SAN_PHAM = "Tên loại sản phẩm";
    public static String TEN_LOAI_LINH_KIEN = "Tên loại linh kiện";
    public static String TEN_VI_TRI_LINH_KIEN = "Tên vị trí linh kiện";
    public static String TEN_LINH_KIEN = "Tên linh kiện";
    
    public static String INSERT_SUCCESS = " INSERT SUCCESS!";
    public static String INSERT_FAIL = " INSERT FAIL!";
    
    public static String UPDATE_FAIL = " UPDATE FAIL";
    public static String UPDATE_SUCCESS = " UPDATE SUCCESS";
    
    public static String DELETE_SUCCESS = " DELETE SUCCESS";
    public static String DELETE_FAIL = " DELETE FAIL";
    
    public static String ERROR_FULL_FIELD = " Bạn cần nhập đủ thông tin các trường! ";
    public static String CREATE_BILL_SUCCESS = " Tạo hóa đơn thành công! \n Bạn có thể lưu file và in hóa đơn! ";
    public static String WARNING_A_DIGIT_QUANTITY = " Thông tin số lượng phải là số! ";
    public static String WARNING_A_DIGIT_PRICE = " Thông tin về giá phải là số! ";
    
}
