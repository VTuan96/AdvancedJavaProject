-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 13, 2018 lúc 11:12 AM
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
  `Linh_kien_Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbdonvi`
--

CREATE TABLE `tbdonvi` (
  `Id_don_vi` int(11) NOT NULL,
  `Ten_don_vi` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbgialinhkien`
--

CREATE TABLE `tbgialinhkien` (
  `Id_gia_linh_kien` int(11) NOT NULL,
  `Gia_nhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gia_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Ngay_nhap` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Id_don_vi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbhoadon`
--

CREATE TABLE `tbhoadon` (
  `Id_hoa_don` int(11) NOT NULL,
  `Ngay_nhap` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Khach_hang_Id` int(11) NOT NULL,
  `Chi_tiet_hoa_don_Id` int(11) NOT NULL,
  `Tong_tien` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbkhachhang`
--

CREATE TABLE `tbkhachhang` (
  `Id_khach_hang` int(11) NOT NULL,
  `Ten_khach_hang` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Dia_chi` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `So_dien_thoai` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblinhkien`
--

CREATE TABLE `tblinhkien` (
  `Id_linh_kien` int(11) NOT NULL,
  `Ten_linh_kien` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Hinh_anh` text COLLATE utf8_unicode_ci NOT NULL,
  `Loai_linh_kien_id` int(11) NOT NULL,
  `Vi_tri_linh_kien_id` int(11) NOT NULL,
  `Id_gia_linh_kien` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblinhkien`
--

INSERT INTO `tblinhkien` (`Id_linh_kien`, `Ten_linh_kien`, `Hinh_anh`, `Loai_linh_kien_id`, `Vi_tri_linh_kien_id`, `Id_gia_linh_kien`) VALUES
(5, 'Điện trở 10 ôm', 'C:UsersdtvtaPicturesScreenshots	ải xuống.jpg', 5, 8, 0),
(6, 'Bóng đèn 100w', 'C:UsersdtvtaPicturesScreenshotsScreenshot (1).png', 25, 2, 0);

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
(5, 'điện trở', 0),
(24, 'abc', 0),
(25, 'bóng đèn', 0),
(26, 'điện trở', 0),
(27, 'biến trở', 0),
(28, 'abe', 0),
(29, 'aw', 0),
(30, 'awe', 0),
(31, 'abcd', 0),
(32, 'w', 0),
(33, 'ae', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbloaisanpham`
--

CREATE TABLE `tbloaisanpham` (
  `Id_loai_san_pham` int(11) NOT NULL,
  `Ten_loai_san_pham` varchar(150) CHARACTER SET utf32 COLLATE utf32_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(1, 'a'),
(2, 'q'),
(3, 'we'),
(4, 'we'),
(5, 'wew'),
(6, 'wew3223'),
(7, 'cộng hòa xã hội chủ nghĩa'),
(8, 'a1'),
(9, 'a2'),
(10, 'a');

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
  ADD PRIMARY KEY (`Id_hoa_don`);

--
-- Chỉ mục cho bảng `tbkhachhang`
--
ALTER TABLE `tbkhachhang`
  ADD PRIMARY KEY (`Id_khach_hang`);

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
  MODIFY `Id_chi_tiet_hoa_don` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbdonvi`
--
ALTER TABLE `tbdonvi`
  MODIFY `Id_don_vi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbgialinhkien`
--
ALTER TABLE `tbgialinhkien`
  MODIFY `Id_gia_linh_kien` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbhoadon`
--
ALTER TABLE `tbhoadon`
  MODIFY `Id_hoa_don` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbkhachhang`
--
ALTER TABLE `tbkhachhang`
  MODIFY `Id_khach_hang` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tblinhkien`
--
ALTER TABLE `tblinhkien`
  MODIFY `Id_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tbloailinhkien`
--
ALTER TABLE `tbloailinhkien`
  MODIFY `Id_loai_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT cho bảng `tbloaisanpham`
--
ALTER TABLE `tbloaisanpham`
  MODIFY `Id_loai_san_pham` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tbvitrilinhkien`
--
ALTER TABLE `tbvitrilinhkien`
  MODIFY `Id_vi_tri_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
