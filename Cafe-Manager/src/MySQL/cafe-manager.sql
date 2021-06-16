-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 01, 2020 lúc 08:10 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `cafe-manager`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `MaBan` int(11) NOT NULL,
  `TenBan` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`MaBan`, `TenBan`, `TrangThai`) VALUES
(1, 'Bàn 1', 'Trống'),
(2, 'Bàn 2', 'Trống'),
(3, 'Bàn 3', 'Trống'),
(4, 'Bàn 4', 'Trống'),
(5, 'Bàn 5', 'Trống'),
(6, 'Bàn 6', 'Trống'),
(7, 'Bàn 7', 'Trống'),
(8, 'Bàn 8', 'Trống'),
(9, 'Bàn 9', 'Trống'),
(10, 'Bàn 10', 'Trống'),
(11, 'Bàn 11', 'Trống'),
(12, 'Bàn 12', 'Trống'),
(13, 'Bàn 13', 'Trống'),
(14, 'Bàn 14', 'Trống'),
(15, 'Bàn 15', 'Trống'),
(16, 'Bàn 16', 'Trống'),
(17, 'Bàn 17', 'Trống'),
(18, 'Bàn 18', 'Trống'),
(19, 'Bàn 19', 'Trống'),
(20, 'Bàn 20', 'Trống'),
(21, 'Bàn 21', 'Trống'),
(22, 'Bàn 22', 'Trống'),
(23, 'Bàn 23', 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaChiTietHD` int(11) NOT NULL,
  `MaHoaDon` int(11) NOT NULL,
  `MaMon` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiethd`
--

INSERT INTO `chitiethd` (`MaChiTietHD`, `MaHoaDon`, `MaMon`, `SoLuong`, `Gia`) VALUES
(1, 1, 18, 1, 50000),
(2, 1, 26, 1, 45000),
(3, 2, 24, 1, 59000),
(4, 2, 34, 2, 20000),
(5, 3, 20, 3, 50000),
(6, 3, 37, 1, 59000),
(7, 4, 12, 1, 59000),
(8, 4, 17, 6, 49000),
(9, 4, 32, 5, 20000),
(10, 5, 3, 1, 50000),
(11, 5, 7, 1, 59000),
(12, 6, 22, 1, 55000),
(13, 7, 9, 3, 45000),
(14, 7, 7, 1, 59000),
(15, 8, 33, 3, 10000),
(16, 8, 35, 4, 59000),
(17, 9, 29, 4, 50000),
(18, 10, 38, 1, 60000),
(19, 11, 10, 1, 59000),
(21, 13, 24, 1, 59000),
(23, 15, 12, 1, 59000),
(24, 16, 24, 1, 59000),
(26, 18, 24, 1, 59000),
(27, 18, 25, 1, 59000),
(28, 19, 12, 1, 59000),
(29, 20, 20, 1, 50000),
(30, 21, 14, 1, 62000),
(31, 22, 20, 1, 50000),
(32, 23, 20, 1, 50000),
(33, 24, 12, 1, 59000),
(34, 25, 22, 1, 55000),
(38, 27, 24, 1, 59000),
(43, 31, 12, 1, 59000),
(44, 32, 24, 1, 59000),
(45, 33, 12, 2, 59000),
(47, 35, 22, 1, 55000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `GiamGia` int(11) DEFAULT NULL,
  `MaBan` int(11) NOT NULL,
  `GioDen` datetime NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `GiamGia`, `MaBan`, `GioDen`, `TongTien`, `TrangThai`) VALUES
(1, NULL, 7, '2020-05-01 11:09:02', 95000, 1),
(2, NULL, 8, '2020-05-03 23:05:46', 99000, 1),
(3, NULL, 18, '2020-05-03 23:06:04', 209000, 1),
(4, NULL, 12, '2020-05-03 23:06:25', 453000, 1),
(5, NULL, 12, '2020-05-03 23:06:53', 109000, 1),
(6, NULL, 8, '2020-05-03 23:07:14', 55000, 1),
(7, NULL, 2, '2020-05-03 23:07:25', 194000, 1),
(8, NULL, 22, '2020-05-03 23:09:24', 266000, 1),
(9, NULL, 14, '2020-05-03 23:09:51', 200000, 1),
(10, NULL, 12, '2020-05-03 23:10:09', 60000, 1),
(11, NULL, 1, '2020-05-26 09:03:05', 59000, 1),
(13, NULL, 4, '2020-05-26 16:42:38', 59000, 1),
(15, NULL, 5, '2020-05-26 16:46:23', 59000, 1),
(16, NULL, 9, '2020-05-26 16:58:15', 59000, 1),
(18, 50, 8, '2020-05-26 17:03:25', 59000, 1),
(19, NULL, 3, '2020-05-26 17:05:20', 59000, 1),
(20, NULL, 2, '2020-05-26 17:09:08', 50000, 1),
(21, NULL, 4, '2020-05-28 17:43:09', 62000, 1),
(22, NULL, 4, '2020-05-28 17:43:48', 50000, 1),
(23, NULL, 4, '2020-05-28 19:20:39', 50000, 1),
(24, NULL, 4, '2020-05-28 19:25:06', 59000, 1),
(25, NULL, 5, '2020-05-28 19:39:20', 55000, 1),
(27, NULL, 15, '2020-05-29 10:25:43', 59000, 1),
(31, NULL, 4, '2020-05-31 19:57:56', 59000, 1),
(32, NULL, 5, '2020-05-31 21:04:03', 59000, 1),
(33, 25, 5, '2020-06-01 12:13:52', 88500, 1),
(35, NULL, 15, '2020-06-01 12:25:39', 55000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhommon`
--

CREATE TABLE `nhommon` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MauSac` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhommon`
--

INSERT INTO `nhommon` (`MaLoai`, `TenLoai`, `MauSac`) VALUES
(1, 'Món được yêu thích', '#ccffff'),
(2, 'Cà phê', '#ccccff'),
(3, 'Thức uống đá xay', '#ffccff'),
(4, 'Trà trái cây', '#ffcccc'),
(5, 'Thức uống trái cây', '#ccffcc'),
(6, 'Macchiato', '#ccccff'),
(7, 'Thức ăn nhẹ', '#ffccff'),
(8, 'Choco-Matcha', '#ffcccc'),
(9, 'Cà phê gói', '#ccffcc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `username` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `lv` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`, `lv`) VALUES
(1, 'admin', 'admin', 1),
(2, 'huan.pt', 'huan', 1),
(3, 'hoang.dv', 'hoang', 1),
(4, 'cong.vm', 'cong', 1),
(5, 'quyt.bl', 'quyet', 1),
(6, 'nhanvien_1', '123456', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thucdon`
--

CREATE TABLE `thucdon` (
  `MaMon` int(11) NOT NULL,
  `TenMon` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `DVT` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thucdon`
--

INSERT INTO `thucdon` (`MaMon`, `TenMon`, `MaLoai`, `DonGia`, `DVT`) VALUES
(1, 'Cà phê sữa đá', 2, 29000, 'Ly'),
(2, 'Bạc xỉu', 2, 29000, 'Ly'),
(3, 'Caramel Macchiato', 2, 50000, 'Ly'),
(4, 'Cà phê nóng', 2, 59000, 'Ly'),
(5, 'Cold Brew cam sả', 2, 50000, 'Ly'),
(6, 'Latte đá', 2, 50000, 'Ly'),
(7, 'Trà cà phê đá xay', 2, 59000, 'Ly'),
(8, 'Cold Brew', 2, 50000, 'Ly'),
(9, 'Cold Brew cổ truyền', 2, 45000, 'Ly'),
(10, 'Phúc bồn tử cam', 3, 59000, 'Ly'),
(11, 'Cà phê đá xay', 3, 59000, 'Ly'),
(12, 'Cookie đá xay', 3, 59000, 'Ly'),
(13, 'Đào việt quất đá', 3, 59000, 'Ly'),
(14, 'Cam vàng canh đá', 3, 62000, 'Ly'),
(15, 'Chocolate đá xay', 3, 59000, 'Ly'),
(16, 'Matcha đá xay', 3, 59000, 'Ly'),
(17, 'Chanh sả đá xay', 3, 49000, 'Ly'),
(18, 'Trà phúc bồn tử', 4, 50000, 'Ly'),
(19, 'Trà đào cam sả', 4, 45000, 'Ly'),
(20, 'Trà bưởi mật ong', 4, 50000, 'Ly'),
(21, 'Oolong hạt sen', 4, 52000, 'Ly'),
(22, 'Trà cam vàng', 4, 55000, 'Ly'),
(23, 'Trà bưởi mật ong', 4, 55000, 'Ly'),
(24, 'Sinh tố cam xoài', 5, 59000, 'Ly'),
(25, 'Sinh tố việt quất', 5, 59000, 'Ly'),
(26, 'Trà sữa mắc ca', 6, 45000, 'Ly'),
(27, 'Trà đen Macchiato', 6, 42000, 'Ly'),
(28, 'Matcha Macchiato', 6, 45000, 'Ly'),
(29, 'Trà xoài Macchiato', 6, 50000, 'Ly'),
(30, 'Trà lài Macchiato', 6, 42000, 'Ly'),
(31, 'Cherry Macchiato', 6, 50000, 'Ly'),
(32, 'Điều vàng rang', 7, 20000, 'Gói'),
(33, 'Đậu phộng tỏi ớt', 7, 10000, 'Goi'),
(34, 'Mít sấy', 7, 20000, 'Gói'),
(35, 'Trà Matcha nóng', 8, 59000, 'Ly'),
(36, 'Trà Matcha đá', 8, 59000, 'Ly'),
(37, 'Socola đá', 8, 59000, 'Ly'),
(38, 'Cà phê phin TCH ', 9, 60000, 'Gói'),
(39, 'Cà phê Arabica TCH', 9, 100000, 'Gói');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaChiTietHD`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaMon` (`MaMon`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Chỉ mục cho bảng `nhommon`
--
ALTER TABLE `nhommon`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaMon`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT cho bảng `nhommon`
--
ALTER TABLE `nhommon`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`),
  ADD CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`MaMon`) REFERENCES `thucdon` (`MaMon`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);

--
-- Các ràng buộc cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD CONSTRAINT `thucdon_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `nhommon` (`MaLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
