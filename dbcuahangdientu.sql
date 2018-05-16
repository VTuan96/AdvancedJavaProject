-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 16, 2018 lúc 02:55 PM
-- Phiên bản máy phục vụ: 10.1.31-MariaDB
-- Phiên bản PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dbcuahangdientu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbchitiethoadon`
--

CREATE TABLE `tbchitiethoadon` (
  `Id_chi_tiet_hoa_don` int(11) NOT NULL,
  `So_luong` int(11) NOT NULL,
  `Id_gia_linh_kien` int(11) NOT NULL,
  `Ma_hoa_don` varchar(15) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbdonvi`
--

CREATE TABLE `tbdonvi` (
  `Id_don_vi` int(11) NOT NULL,
  `Ten_don_vi` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbdonvi`
--

INSERT INTO `tbdonvi` (`Id_don_vi`, `Ten_don_vi`) VALUES
(1, 'chiếc'),
(2, 'cái'),
(3, 'hộp'),
(4, 'thùng'),
(5, 'con');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbgialinhkien`
--

CREATE TABLE `tbgialinhkien` (
  `Id_gia_linh_kien` int(11) NOT NULL,
  `Gia_nhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gia_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ngay_nhap` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Id_don_vi` int(11) NOT NULL,
  `Id_linh_kien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbhoadon`
--

CREATE TABLE `tbhoadon` (
  `Ma_hoa_don` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Ngay_nhap` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Ma_khach_hang` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Tong_tien` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbkhachhang`
--

CREATE TABLE `tbkhachhang` (
  `Ma_khach_hang` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Ten_khach_hang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `So_dien_thoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbkhachhang`
--

INSERT INTO `tbkhachhang` (`Ma_khach_hang`, `Ten_khach_hang`, `Dia_chi`, `So_dien_thoai`) VALUES
('KH01', 'Đỗ Minh Anh', 'Số 10, ngõ 124 Minh Khai, Hai Bà Trưng, Hà Nội', '0123456788'),
('KH02', 'Nguyen Van Hung', 'Ta Quang Buu, Ha Noi', '96587120025'),
('KH03', 'Vu Anh Tuan', 'Hai Ba Trung, Ha Noi', '0123456789');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblinhkien`
--

CREATE TABLE `tblinhkien` (
  `Id_linh_kien` int(11) NOT NULL,
  `Ten_linh_kien` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Hinh_anh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Loai_linh_kien_id` int(11) NOT NULL,
  `Vi_tri_linh_kien_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbloailinhkien`
--

CREATE TABLE `tbloailinhkien` (
  `Id_loai_linh_kien` int(11) NOT NULL,
  `Ten_loai_linh_kien` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Id_loai_san_pham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbloailinhkien`
--

INSERT INTO `tbloailinhkien` (`Id_loai_linh_kien`, `Ten_loai_linh_kien`, `Id_loai_san_pham`) VALUES
(34, 'Cảm biến khoảng cách', 1),
(35, 'Cảm biến nhiệt độ, độ ẩm', 1),
(36, 'Cảm biến dòng', 1),
(37, 'Cảm biến khí', 1),
(41, '8051', 2),
(42, 'AVR', 2),
(43, 'STM', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbloaisanpham`
--

CREATE TABLE `tbloaisanpham` (
  `Id_loai_san_pham` int(11) NOT NULL,
  `Ten_loai_san_pham` varchar(150) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbloaisanpham`
--

INSERT INTO `tbloaisanpham` (`Id_loai_san_pham`, `Ten_loai_san_pham`) VALUES
(1, 'Cảm biến'),
(2, 'Vi điều khiển'),
(3, 'Mạch nạp'),
(4, 'LCD');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbnguoidung`
--

CREATE TABLE `tbnguoidung` (
  `Ten_nguoi_dung` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Mat_khau` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbnguoidung`
--

INSERT INTO `tbnguoidung` (`Ten_nguoi_dung`, `Mat_khau`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbvitrilinhkien`
--

CREATE TABLE `tbvitrilinhkien` (
  `Id_vi_tri_linh_kien` int(11) NOT NULL,
  `Ten_vi_tri_linh_kien` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbvitrilinhkien`
--

INSERT INTO `tbvitrilinhkien` (`Id_vi_tri_linh_kien`, `Ten_vi_tri_linh_kien`) VALUES
(8, 'a1'),
(9, 'a2'),
(10, 'a3'),
(11, 'a4'),
(12, 'a5'),
(13, 'a6'),
(14, 'a7'),
(15, 'a8');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbchitiethoadon`
--
ALTER TABLE `tbchitiethoadon`
  ADD PRIMARY KEY (`Id_chi_tiet_hoa_don`);

--
-- Chỉ mục cho bảng `tbdonvi`
--
ALTER TABLE `tbdonvi`
  ADD PRIMARY KEY (`Id_don_vi`);

--
-- Chỉ mục cho bảng `tbgialinhkien`
--
ALTER TABLE `tbgialinhkien`
  ADD PRIMARY KEY (`Id_gia_linh_kien`);

--
-- Chỉ mục cho bảng `tbhoadon`
--
ALTER TABLE `tbhoadon`
  ADD PRIMARY KEY (`Ma_hoa_don`);

--
-- Chỉ mục cho bảng `tbkhachhang`
--
ALTER TABLE `tbkhachhang`
  ADD PRIMARY KEY (`Ma_khach_hang`);

--
-- Chỉ mục cho bảng `tblinhkien`
--
ALTER TABLE `tblinhkien`
  ADD PRIMARY KEY (`Id_linh_kien`);

--
-- Chỉ mục cho bảng `tbloailinhkien`
--
ALTER TABLE `tbloailinhkien`
  ADD PRIMARY KEY (`Id_loai_linh_kien`);

--
-- Chỉ mục cho bảng `tbloaisanpham`
--
ALTER TABLE `tbloaisanpham`
  ADD PRIMARY KEY (`Id_loai_san_pham`);

--
-- Chỉ mục cho bảng `tbnguoidung`
--
ALTER TABLE `tbnguoidung`
  ADD PRIMARY KEY (`Ten_nguoi_dung`);

--
-- Chỉ mục cho bảng `tbvitrilinhkien`
--
ALTER TABLE `tbvitrilinhkien`
  ADD PRIMARY KEY (`Id_vi_tri_linh_kien`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbchitiethoadon`
--
ALTER TABLE `tbchitiethoadon`
  MODIFY `Id_chi_tiet_hoa_don` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT cho bảng `tbdonvi`
--
ALTER TABLE `tbdonvi`
  MODIFY `Id_don_vi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tbgialinhkien`
--
ALTER TABLE `tbgialinhkien`
  MODIFY `Id_gia_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `tblinhkien`
--
ALTER TABLE `tblinhkien`
  MODIFY `Id_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `tbloailinhkien`
--
ALTER TABLE `tbloailinhkien`
  MODIFY `Id_loai_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT cho bảng `tbloaisanpham`
--
ALTER TABLE `tbloaisanpham`
  MODIFY `Id_loai_san_pham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tbvitrilinhkien`
--
ALTER TABLE `tbvitrilinhkien`
  MODIFY `Id_vi_tri_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
