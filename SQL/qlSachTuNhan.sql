CREATE DATABASE qlSachTuNhan
GO
/*
USE master
GO
DROP DATABASE qlSachTuNhan
GO
*/
USE [qlSachTuNhan]
GO
-------------VUONG------------------------------------------------------------------------------
/****** Object:  Table [dbo].[ca]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ca](
	[maCa] [int] NOT NULL,
	[gioBatDau] [nvarchar](5) NOT NULL,
	[gioKetThuc] [nvarchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chiTietDatHang]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietNhapHang](
	[maNH] [nvarchar](5) NOT NULL,
	[maSP] [nvarchar](5) NOT NULL,
	[soLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNH] ASC,
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhanVien]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhanVien](
	[maNV] [nvarchar](5) NOT NULL,
	[tenNV] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [int] NOT NULL,
	[soDienThoai] [nvarchar](10) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[chucVu] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phanCongCa]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phanCongCa](
	[maNV] [nvarchar](5) NOT NULL,
	[maCa] [int] NOT NULL,
	[ngayLamViec] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC,
	[ngayLamViec] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phieuDatHang]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuNhap](
	[maNH] [nvarchar](5) NOT NULL,
	[maNV] [nvarchar](5) NOT NULL,
	[ngayNhap] [date] NOT NULL,
	[chietKhau] [float] NOT NULL,
	[trangThai] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[chiTietHD]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietHD](
	[maHD] [nvarchar](5) NOT NULL,
	[maSP] [nvarchar](5) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[discount] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[taiKhoan]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[taiKhoan](
	[username] [nvarchar](10) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO

-----------------------------------------------------------------------------------------------------
/****** Object:  Table [dbo].[hoaDon]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[maHD] [nvarchar](5) NOT NULL,
	[maNV] [nvarchar](5) NOT NULL,
	[maKH] [nvarchar](5) NOT NULL,
	[ngayTaoHD] [date] NULL,
	[thanhTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachHang]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachHang](
	[maKH] [nvarchar](5) NOT NULL,
	[tenKH] [nvarchar](50) NOT NULL,
	[SDT] [nvarchar](10) NOT NULL,
	[diaChi] [nvarchar](255) NOT NULL,
	[loaiKH] [nvarchar](10) NOT NULL,
	[tinhTrang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[khuyenMai]    Script Date: 11/9/2023 10:54:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khuyenMai](
	[maSP] [nvarchar](5) NOT NULL,
	[discount] [int] NULL,
	[ngayTao] [date] NULL,
	[ngayHetHan] [date] NULL,
	[maKM] [nvarchar](5) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sanPham]    Script Date: 11/2/2023 1:41:13 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanPham](
	[maSP] [nvarchar](5) NOT NULL,
	[tenSP] [nvarchar](50) NOT NULL,
	[tenTacGia] [nvarchar](50) NOT NULL,
	[danhMuc] [nvarchar](50) NOT NULL,
	[nhaXB] [nvarchar](50) NOT NULL,
	[namXB] [int] NOT NULL,
	[soLuong] [int] NULL,
	[donGiaGoc] [float] NOT NULL,
	[donGiaMua] [float] NOT NULL,
	[tinhTrang] [nvarchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[chiTietDatSach](
	[maDH] [nvarchar](5) NOT NULL,
	[maSP] [nvarchar](5) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGiaBan] [float] NOT NULL,
 CONSTRAINT [PK_details] PRIMARY KEY CLUSTERED 
(
	[maDH] ASC,
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

GO
CREATE TABLE [dbo].[datSach](
	[maDH] [nvarchar](5) NOT NULL,
	[maKH] [nvarchar](5) NOT NULL,
	[maNV] [nvarchar](5) NOT NULL,
	[ngayTaoDH] [date] NOT NULL,
	[trangThai] [int] NOT NULL,
	[tienCoc] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maDH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[khachHang] ADD UNIQUE NONCLUSTERED 
(
	[SDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhanVien__06ACB9A2BC63A908]    Script Date: 11/13/2023 9:36:20 PM ******/
ALTER TABLE [dbo].[nhanVien] ADD UNIQUE NONCLUSTERED 
(
	[soDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[hoaDon] ADD  DEFAULT (getdate()) FOR [ngayTaoHD]
GO
ALTER TABLE [dbo].[chiTietNhapHang]  WITH CHECK ADD FOREIGN KEY([maNH])
REFERENCES [dbo].[phieuNhap] ([maNH])
GO
ALTER TABLE [dbo].[chiTietNhapHang]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[chiTietDatSach]  WITH CHECK ADD FOREIGN KEY([maDH])
REFERENCES [dbo].[datSach] ([maDH])
GO
ALTER TABLE [dbo].[chiTietDatSach]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[chiTietHD]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[hoaDon] ([maHD])
GO
ALTER TABLE [dbo].[chiTietHD]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[datSach]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[khachHang] ([maKH])
GO
ALTER TABLE [dbo].[datSach]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[nhanVien] ([maNV])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[khachHang] ([maKH])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[nhanVien] ([maNV])
GO
ALTER TABLE [dbo].[khuyenMai]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[phanCongCa]  WITH CHECK ADD FOREIGN KEY([maCa])
REFERENCES [dbo].[ca] ([maCa])
GO
ALTER TABLE [dbo].[phanCongCa]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[nhanVien] ([maNV])
GO
ALTER TABLE [dbo].[phieuNhap]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[nhanVien] ([maNV])
GO
ALTER TABLE [dbo].[taiKhoan]
ADD FOREIGN KEY (username) REFERENCES [dbo].[nhanVien](soDienThoai) ON UPDATE CASCADE
GO
--ALTER TABLE [dbo].[nhanVien]
--DROP CONSTRAINT FK__nhanVien__soDien__6477ECF3;

ALTER TABLE [dbo].[chiTietNhapHang]  WITH CHECK ADD  CONSTRAINT [chk_soLg] CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[chiTietNhapHang] CHECK CONSTRAINT [chk_soLg]
GO
ALTER TABLE [dbo].[chiTietHD]  WITH CHECK ADD  CONSTRAINT [chk_donGia] CHECK  (([donGia]>(0)))
GO
ALTER TABLE [dbo].[chiTietHD] CHECK CONSTRAINT [chk_donGia]
GO
ALTER TABLE [dbo].[chiTietHD]  WITH CHECK ADD  CONSTRAINT [chk_sL] CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[chiTietHD] CHECK CONSTRAINT [chk_sL]
GO
ALTER TABLE [dbo].[khuyenMai]  WITH CHECK ADD  CONSTRAINT [chk_disc] CHECK  (([discount]>(0) AND [discount]<(100)))
GO
ALTER TABLE [dbo].[khuyenMai] CHECK CONSTRAINT [chk_disc]
GO
ALTER TABLE [dbo].[phieuNhap]  WITH CHECK ADD  CONSTRAINT [chk_chiecKhau] CHECK  (([chietKhau]>(0)))
GO
ALTER TABLE [dbo].[phieuNhap] CHECK CONSTRAINT [chk_chiecKhau]
GO
ALTER TABLE [dbo].[sanPham]  WITH CHECK ADD  CONSTRAINT [chk_donGiaGoc] CHECK  (([donGiaGoc]>(0)))
GO
ALTER TABLE [dbo].[sanPham] CHECK CONSTRAINT [chk_donGiaGoc]
GO
ALTER TABLE [dbo].[sanPham]  WITH CHECK ADD  CONSTRAINT [chk_donGiaMua] CHECK  (([donGiaMua]>(0)))
GO
ALTER TABLE [dbo].[sanPham] CHECK CONSTRAINT [chk_donGiaMua]
GO
ALTER TABLE [dbo].[sanPham]  WITH CHECK ADD  CONSTRAINT [chk_soLuong] CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[sanPham] CHECK CONSTRAINT [chk_soLuong]
GO

/****** Object:  StoredProcedure [dbo].[getMaKHTuDong]    Script Date: 11/13/2023 9:36:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getMaKHTuDong]
as
select CONCAT('KH',RIGHT(CONCAT('0',ISNULL(RIGHT(max(maKH),1),0)+1),1)) from [dbo].khachHang where maKH like 'KH%'
GO
/****** Object:  StoredProcedure [dbo].[getMaTuDong]    Script Date: 11/13/2023 9:36:20 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getMaTuDong]
as
select CONCAT('KH',RIGHT(CONCAT('000',ISNULL(RIGHT(max(maKH),3),0)+1),3)) from [dbo].khachHang where maKH like 'KH%'
GO
GO

/*SAMPLE DATA*/
--Nhan vien

INSERT [dbo].[NhanVien] VALUES (N'NV001', N'Nguyễn Đức Vương', CAST(N'2003-12-22' AS Date),1, '0799558911', N'270, ấp 8, xã Sơn Phú, huyện Giồng Trôm, tỉnh Bến Tre', N'vuongnguyen221203@gmail.com', N'Quản lý')
INSERT [dbo].[NhanVien] VALUES (N'NV002', N'Phan Anh Tuấn', CAST(N'2000-12-12' AS Date),1, '0337484060', N'Hà Nội', N'tuan123@gmail.com', N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV003', N'Nguyễn Kim Bằng', CAST(N'2001-12-12' AS Date),1, '0799558913', N'Bến Tre', N'kimHN2@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV004', N'Nguyễn Thị Cẩm Tiên', CAST(N'1999-1-21' AS Date),0, '0799558914', N'Lạng Sơn', N'quangD3@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV005', N'Lê Thị Hồng Thắm', CAST(N'2004-3-16' AS Date),0, '0799558915', N'Huế', N'quangD4@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV006', N'Bùi Trọng Anh', CAST(N'2003-7-26' AS Date),1, '0799558916', N'Cao Bằng', N'quangD5@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV007', N'Lê Thị Lựu', CAST(N'2004-4-9' AS Date),0, '0799558917', N'Bắc Cạn', N'kimHN6@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV008', N'Nguyễn Kim Tuyền', CAST(N'1996-5-30' AS Date),0, '0799558918', N'TP. Hồ CHí Minh', N'kimH7N@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV009', N'Ngô Tuấn Khải', CAST(N'2001-8-5' AS Date),1, '0799558919', N'TP. Hồ CHí Minh', N'kimHN8@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV010', N'Ngô Trung Kiên', CAST(N'2001-4-15' AS Date),1, '0799558901', N'TP. Hồ CHí Minh', N'kimHN9@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV011', N'Trịnh Đình Quang', CAST(N'1996-10-20' AS Date),1, '0799558902', N'Tiền Giang', N'kim34HN@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV012', N'Nguyễn Chí Hiếu', CAST(N'1995-6-3' AS Date),1, '0799558903', N'Bắc Cạn', N'quang34D@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV013', N'Lê Thị Hồng Duyên', CAST(N'2000-4-2' AS Date),0, '0799558904', N'Bắc Cạn', N'quangD75@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV014', N'Lê Thị Hồng', CAST(N'2004-3-16' AS Date),0, '0799558815', N'Bắc Cạn', N'quangD4@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV015', N'Bùi Trọng Phúc', CAST(N'2003-7-26' AS Date),1, '0799558816', N'Tiền Giang', N'quangD5@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV016', N'Lê Thị Hiếu', CAST(N'2004-4-9' AS Date),0, '0799558817', N'Long An', N'kimHN6@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV017', N'Nguyễn Thị Kim Chi', CAST(N'1996-5-30' AS Date),0, '0799558818', N'TP. Hồ CHí Minh', N'kimH7N@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV018', N'Ngô Tuấn Tú', CAST(N'2001-8-5' AS Date),1, '0799558819', N'TP. Hồ CHí Minh', N'kimHN8@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV019', N'Ngô Trung Hậu', CAST(N'2001-4-15' AS Date),1, '0799558801', N'TP. Hồ CHí Minh', N'kimHN9@gmail.com',  N'Nhân viên')
INSERT [dbo].[NhanVien] VALUES (N'NV020', N'Trịnh Nguyên', CAST(N'1996-10-20' AS Date),1, '0799558882', N'TP. Hồ CHí Minh', N'kim34HN@gmail.com',  N'Nhân viên')


Insert taiKhoan values ('0799558911','1111')
Insert taiKhoan values ('0337484060','1111')
Insert taiKhoan values ('0799558913','1111')
Insert taiKhoan values ('0799558914','1111')
Insert taiKhoan values ('0799558915','1111')
Insert taiKhoan values ('0799558916','1111')
Insert taiKhoan values ('0799558917','1111')
Insert taiKhoan values ('0799558918','1111')
Insert taiKhoan values ('0799558919','1111')
Insert taiKhoan values ('0799558901','1111')
Insert taiKhoan values ('0799558902','1111')
Insert taiKhoan values ('0799558903','1111')
Insert taiKhoan values ('0799558904','1111')
Insert taiKhoan values ('0799558815','1111')
Insert taiKhoan values ('0799558816','1111')
Insert taiKhoan values ('0799558817','1111')
Insert taiKhoan values ('0799558818','1111')
Insert taiKhoan values ('0799558819','1111')
Insert taiKhoan values ('0799558801','1111')
Insert taiKhoan values ('0799558882','1111')


insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP001',N'Dế Mèn Phiêu Lưu Kí',N'Tô Hoài',N'Truyện Ngụ Ngôn',N'Kim Đồng',2020,120,17500,30000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP002',N'Chàng Trai Xinh Đẹp',N'Yuu Nagira',N'Ngôn Tình',N'Dân Trí',2021,50,60000,70000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP003',N'Lý Thuyết Trò Chơi',N'Trần Phách Hàm',N'Tâm Lý - Kĩ Năng',N'Dân Trí',2020,130,153000,163000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP004',N'Oxford Learner’s Pocket Dictionary',N'Oxford',N'DICTIONARIES',N'Oxford',2020,120,60000,83000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP005',N'Tết Ở Làng Địa Ngục',N'Thảo Trang',N'Huyền Bi - Giả Tưởng',N'NXB Thanh Niên',2022,130,100000,116000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP006',N'Thương',N'Tô Hoài',N'Thơ Ca',N'Phụ Nữ Việt Nam',2020,120,63000,75000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP007',N'Trong Cái Không Có Gì Không?',N'Thích Nhất Hạnh',N'Truyện Thiếu Nhi',N'Kim Đồng',2020,120,100000,128000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP008',N'Niềm Vui Của Việc Bỏ Lỡ',N'Tanya Dalton',N'Sách Tâm Lí',N'Công Thương',2020,120,65000,80000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP009',N'Thuật Thao Túng',N'Wladislaw Jachtchenko',N'Sách Tâm Lí',N'AZ Việt Nam',2020,120,65000,69000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP010',N'Tuổi Trẻ Đáng Giá Bao Nhiêu',N'Tô Hoài',N'Truyện Ngụ Ngôn',N'Kim Đồng',2020,120,18000,210000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP011',N'Cây Cam Ngọt Của Tôi',N'José Mauro',N'Tiểu Thuyết',N'Hội Nhà Văn',2020,120,185000,190000,1)
insert into sanPham(maSP,tenSP,tenTacGia,danhMuc,nhaXB,namXB,soLuong,donGiaGoc,donGiaMua,tinhTrang) values ('SP012',N'Nhà Giả Kim',N'Paulo Coelho',N'Tiểu Thuyết',N'Kim Đồng',2020,110,140000,165000,1)

--KH
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH001',N'Phan Anh Tuấn',N'0337484060',N'Bình Định','TV',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH002',N'Nguyễn Đức Vương',N'0156897452',N'Bình Dươn','TV',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH003',N'Trần Lê Thiên Trí',N'0123456789',N'Kiên Giang','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH004',N'Trần Gia Bảo',N'0335454060',N'Bình Định','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH005',N'Nguyễn Văn Linh',N'0687484060',N'Hà Nội','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH006',N'Nguyễn Thị Linh',N'0339684060',N'Hà Tĩnh','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH007',N'Đinh Lệ Phương',N'0337484642',N'BÌnh Thuận','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH008',N'Nguyễn Thị Hồng Hải',N'0157484642',N'Kiên Giang','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH009',N'Nguyễn Thị Bảy',N'0335284642',N'Bắc Giang','VL',1)
insert into khachHang(maKH,tenKH,SDT,diaChi,loaiKH,tinhTrang) values ('KH010',N'Phạm Trúc Phương',N'0427484642',N'Bến Tre','VL',1)

--KM
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP1',20,'2023-11-01','2023-11-15','KM1')
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP3',7,'2023-11-01','2023-11-15','KM1')
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP5',3,'2023-11-01','2023-11-15','KM1')
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP8',2,'2023-11-01','2023-11-15','KM1')
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP10',9,'2023-11-01','2023-11-15','KM1')

--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP1',9,'2023-10-01','2023-10-15','KM2')
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP3',8,'2023-10-01','2023-10-15','KM2')
--insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP4',6,'2023-10-01','2023-10-15','KM2')

insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP001',20,'2023-10-11','2023-12-12','KM001')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP002',10,'2023-10-11','2023-12-12','KM001')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP003',30,'2023-10-11','2023-12-12','KM001')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP004',40,'2023-10-11','2023-12-12','KM001')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP005',50,'2023-10-11','2023-12-12','KM001')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP006',8,'2023-10-11','2023-12-12','KM001')


insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP001',8,'2023-10-11','2023-12-12','KM002')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP002',15,'2023-10-11','2023-12-12','KM002')

insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP003',17,'2023-10-11','2023-12-12','KM002')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP004',26,'2023-10-11','2023-12-12','KM002')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP005',18,'2023-10-11','2023-12-12','KM002')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP006',28,'2023-10-11','2023-12-12','KM002')


insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP005',70,'2023-12-01','2023-12-23','KM003')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP006',20,'2023-12-01','2023-12-23','KM003')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP007',19,'2023-12-01','2023-12-23','KM003')
insert into khuyenMai(maSP,discount,ngayTao,ngayHetHan,maKM) values ('SP008',22,'2023-12-01','2023-12-23','KM003')


--insert into hoaDon(maHD,maNV,maKH,ngayTaoHD,thanhTien) values ('HD7','NV001','KH1','2023-11-12',350000)
--insert into hoaDon(maHD,maNV,maKH,ngayTaoHD,thanhTien) values ('HD8','NV001','KH2','2023-11-12',450000)


--insert into chiTietHD(maHD,maSP,soLuong,donGia,discount) values ('HD7','SP1',2,30000,4)
--insert into chiTietHD(maHD,maSP,soLuong,donGia,discount) values ('HD7','SP2',2,45000,4)

--insert into chiTietHD(maHD,maSP,soLuong,donGia,discount) values ('HD8','SP2',3,45000,4)
--insert into chiTietHD(maHD,maSP,soLuong,donGia,discount) values ('HD8','SP1',3,90000,4)


INSERT ca values (1,N'7:00',N'12:00')
INSERT ca values (2,N'13:00',N'18:00')
--PCC
INSERT phanCongCa values (N'NV001',1,CAST(N'2023-11-4' AS Date))
INSERT phanCongCa values (N'NV002',2,CAST(N'2023-11-4' AS Date))
INSERT phanCongCa values (N'NV003',1,CAST(N'2023-11-5' AS Date))
INSERT phanCongCa values (N'NV004',2,CAST(N'2023-11-5' AS Date))
INSERT phanCongCa values (N'NV005',1,CAST(N'2023-11-6' AS Date))
INSERT phanCongCa values (N'NV006',2,CAST(N'2023-11-6' AS Date))
INSERT phanCongCa values (N'NV001',1,CAST(N'2023-11-7' AS Date))
go















--Create view thuChi_Nhap as Select pn.maNH, ngayNhap , chietKhau ,thanhTien = SUM(ctPNH.soLuong*sp.donGiaGoc*(100-pn.chietKhau)/100) 
--from phieuNhap pn join chiTietNhapHang ctPNH on pn.maNH = ctPNH.maNH join sanPham sp on sp.maSP = ctPNH.maSP
--where trangThai = 1
--group by pn.maNH, ngayNhap, chietKhau;
--go
--select * from thuChi_Nhap

--drop view thuChi_Nhap
-----------------------------------------------------------------------------------------------
--Select sp.maSP , tenSP, soLuongNhap = SUM(ctPNH.soLuong), soLuongGoc = sp.soLuong - SUM(ctPNH.soLuong), sp.soLuong 
--from phieuNhap pn join chiTietNhapHang ctPNH on pn.maNH = ctPNH.maNH join sanPham sp on sp.maSP = ctPNH.maSP
--group by sp.maSP, tenSP, sp.soLuong
--where ngayNhap BETWEEN CAST('"+start+"' AS DATE) AND CAST('"+end+"' AS DATE) and trangThai = 1

--INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'ggg', 13, CAST(N'2023-11-01' AS Date), CAST(N'2023-11-23' AS Date), N'KM1')
--INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'abc', 15, CAST(N'2023-11-01' AS Date), CAST(N'2023-11-23' AS Date), N'KM1')
--INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'111', 14, CAST(N'2023-11-03' AS Date), CAST(N'2023-11-30' AS Date), N'')
--INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'abc', 20, CAST(N'2023-11-03' AS Date), CAST(N'2023-11-30' AS Date), N'')
--Chi tieu nhap sach
--Select pdh.maDatHang, pdh.ngayDatHang , pdh.chietKhau ,thanhTien = SUM(ctPDH.soLuong*sp.donGiaGoc*(100-pdh.chietKhau)/100) from phieuDatHang pdh join chiTietDatHang ctPDH on pdh.maDatHang = ctPDH.maDH join sanPham sp on sp.maSP = ctPDH.maSP
--where ngayDatHang BETWEEN CAST('2023-11-10' AS DATE) AND CAST('2023-11-13' AS DATE) and trangThai = 1
--group by pdh.maDatHang, pdh.ngayDatHang, pdh.chietKhau

--select * from sanPham

--select * from chiTietDatHang 

--Select sp.maSP ,tenSP ,soLuongNhap = SUM(ctPDH.soLuong), soLuongGoc = sp.soLuong - SUM(ctPDH.soLuong), sp.soLuong from phieuDatHang pdh join chiTietDatHang ctPDH on pdh.maDatHang = ctPDH.maDH join sanPham sp on sp.maSP = ctPDH.maSP
--where ngayDatHang BETWEEN CAST('2023-11-10' AS DATE) AND CAST('2023-11-13' AS DATE) and trangThai = 1
--group by sp.maSP,tenSP,sp.soLuong


--Select pdh.maDatHang, ngayDatHang , chietKhau ,thanhTien = SUM(ctPDH.soLuong*sp.donGiaGoc*(100-pdh.chietKhau)/100) 
--from phieuDatHang pdh join chiTietDatHang ctPDH on pdh.maDatHang = ctPDH.maDH join sanPham sp on sp.maSP = ctPDH.maSP 
--where ngayDatHang BETWEEN CAST('2023-11-11' AS DATE) AND CAST('2023-11-12' AS DATE) and trangThai = 1 
--group by pdh.maDatHang, ngayDatHang, chietKhau


--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'DH1', N'SP9', 2, 69000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'DH2', N'SP4', 3, 83000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'DH2', N'SP5', 5, 116000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'DH2', N'SP6', 3, 75000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD3', N'SP2', 3, 70000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD3', N'SP8', 10, 80000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD4', N'SP5', 3, 116000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD4', N'SP8', 10, 80000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD5', N'SP2', 5, 70000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD5', N'SP6', 2, 75000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD6', N'SP15', 10, 160000)
--INSERT [dbo].[chiTietDatSach] ([maDH], [maSP], [soLuong], [donGiaBan]) VALUES (N'HD6', N'SP6', 3, 75000)
--GO
--INSERT [dbo].[chiTietHD] ([maHD], [maSP], [soLuong], [donGia], [discount]) VALUES (N'DH2', N'SP4', 3, 83000, 3)
--INSERT [dbo].[chiTietHD] ([maHD], [maSP], [soLuong], [donGia], [discount]) VALUES (N'DH2', N'SP5', 5, 116000, 3)
--INSERT [dbo].[chiTietHD] ([maHD], [maSP], [soLuong], [donGia], [discount]) VALUES (N'DH2', N'SP6', 3, 75000, 3)
--INSERT [dbo].[chiTietHD] ([maHD], [maSP], [soLuong], [donGia], [discount]) VALUES (N'DH2', N'SP15', 1, 160000, 3)
--GO
--INSERT [dbo].[datSach] ([maDH], [maKH], [maNV], [ngayTaoDH], [trangThai], [tienCoc]) VALUES (N'DH1', N'KH101', N'NV001', CAST(N'2023-11-21' AS Date), -1, 0)
--INSERT [dbo].[datSach] ([maDH], [maKH], [maNV], [ngayTaoDH], [trangThai], [tienCoc]) VALUES (N'DH2', N'KH10', N'NV001', CAST(N'2023-11-21' AS Date), 1, 360000)
--INSERT [dbo].[datSach] ([maDH], [maKH], [maNV], [ngayTaoDH], [trangThai], [tienCoc]) VALUES (N'HD3', N'KH11', N'NV001', CAST(N'2023-11-21' AS Date), -1, 400000)
--INSERT [dbo].[datSach] ([maDH], [maKH], [maNV], [ngayTaoDH], [trangThai], [tienCoc]) VALUES (N'HD4', N'KH1', N'NV001', CAST(N'2023-11-22' AS Date), -1, 350000)
--INSERT [dbo].[datSach] ([maDH], [maKH], [maNV], [ngayTaoDH], [trangThai], [tienCoc]) VALUES (N'HD5', N'KH1', N'NV001', CAST(N'2023-11-22' AS Date), -1, 0)
--INSERT [dbo].[datSach] ([maDH], [maKH], [maNV], [ngayTaoDH], [trangThai], [tienCoc]) VALUES (N'HD6', N'KH1', N'NV001', CAST(N'2023-11-22' AS Date), -1, 550000)
--GO
--INSERT [dbo].[hoaDon] ([maHD], [maNV], [maKH], [ngayTaoHD], [thanhTien]) VALUES (N'DH2', N'NV001', N'KH10', CAST(N'2023-11-22' AS Date), 1177580)
--GO