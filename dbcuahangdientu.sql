-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 12, 2018 lúc 10:23 AM
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
-- Cấu trúc bảng cho bảng `tblinhkien`
--

CREATE TABLE `tblinhkien` (
  `Id_linh_kien` int(11) NOT NULL,
  `Ten_linh_kien` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Hinh_anh` text COLLATE utf8_unicode_ci NOT NULL,
  `Ngay_nhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gia_nhap` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Gia_ban` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Loai_linh_kien_id` int(11) NOT NULL,
  `Vi_tri_linh_kien_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tblinhkien`
--

INSERT INTO `tblinhkien` (`Id_linh_kien`, `Ten_linh_kien`, `Hinh_anh`, `Ngay_nhap`, `Gia_nhap`, `Gia_ban`, `Loai_linh_kien_id`, `Vi_tri_linh_kien_id`) VALUES
(5, 'Điện trở 10 ôm', 'C:UsersdtvtaPicturesScreenshots	ải xuống.jpg', '2018/05/11', '20000', '50000', 5, 8),
(6, 'Bóng đèn 100w', 'C:UsersdtvtaPicturesScreenshotsScreenshot (1).png', '2018/05/11', '30000', '50000', 25, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbloailinhkien`
--

CREATE TABLE `tbloailinhkien` (
  `Id_loai_linh_kien` int(11) NOT NULL,
  `Ten_loai_linh_kien` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbloailinhkien`
--

INSERT INTO `tbloailinhkien` (`Id_loai_linh_kien`, `Ten_loai_linh_kien`) VALUES
(5, 'điện trở'),
(24, 'abc'),
(25, 'bóng đèn'),
(26, 'điện trở'),
(27, 'biến trở'),
(28, 'abe'),
(29, 'aw'),
(30, 'awe'),
(31, 'abcd'),
(32, 'w'),
(33, 'ae');

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
-- AUTO_INCREMENT cho bảng `tbvitrilinhkien`
--
ALTER TABLE `tbvitrilinhkien`
  MODIFY `Id_vi_tri_linh_kien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
