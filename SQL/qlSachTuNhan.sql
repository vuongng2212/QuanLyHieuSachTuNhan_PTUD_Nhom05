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
CREATE TABLE [dbo].[chiTietDatHang](
	[maDH] [nvarchar](5) NOT NULL,
	[maSP] [nvarchar](5) NOT NULL,
	[soLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maDH] ASC,
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
CREATE TABLE [dbo].[phieuDatHang](
	[maDatHang] [nvarchar](5) NOT NULL,
	[maNv] [nvarchar](5) NOT NULL,
	[ngayDatHang] [date] NOT NULL,
	[chietKhau] [float] NOT NULL,
	[trangThai] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maDatHang] ASC
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
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--/****** Object:  Table [dbo].[khuyenMai]    Script Date: 11/2/2023 1:41:13 AM ******/
--SET ANSI_NULLS ON
--GO
--SET QUOTED_IDENTIFIER ON
--GO
--CREATE TABLE [dbo].[khuyenMai](
--	[maSP] [nvarchar](5) NOT NULL,
--	[discount] [int] NULL,
--	[ngayTao] [date] NULL,
--	[ngayHetHan] [date] NULL,
--	[maKM] [nvarchar](5) NULL
--PRIMARY KEY CLUSTERED 
--(
--	[maSP] ASC
--)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
--) ON [PRIMARY]
--GO
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
/****** Object:  Index [UQ__khachHan__CA1930A536157F62]    Script Date: 11/2/2023 1:41:13 AM ******/
ALTER TABLE [dbo].[khachHang] ADD UNIQUE NONCLUSTERED 
(
	[SDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__nhanVien__06ACB9A23FB7E18A]    Script Date: 11/2/2023 1:41:13 AM ******/
ALTER TABLE [dbo].[nhanVien] ADD UNIQUE NONCLUSTERED 
(
	[soDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[hoaDon] ADD  DEFAULT (getdate()) FOR [ngayTaoHD]
GO
ALTER TABLE [dbo].[chiTietDatHang]  WITH CHECK ADD FOREIGN KEY([maDH])
REFERENCES [dbo].[phieuDatHang] ([maDatHang])
GO
ALTER TABLE [dbo].[chiTietDatHang]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[chiTietHD]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[hoaDon] ([maHD])
GO
ALTER TABLE [dbo].[chiTietHD]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
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
ALTER TABLE [dbo].[phieuDatHang]  WITH CHECK ADD FOREIGN KEY([maNv])
REFERENCES [dbo].[nhanVien] ([maNV])
GO
ALTER TABLE [dbo].[taiKhoan]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[nhanVien] ([soDienThoai])
GO
--ALTER TABLE [dbo].[chiTietDatHang]  WITH CHECK ADD  CONSTRAINT [chk_donGiaNhap] CHECK  (([donGiaNhap]>(0)))
--GO
--ALTER TABLE [dbo].[chiTietDatHang] CHECK CONSTRAINT [chk_donGiaNhap]
GO
ALTER TABLE [dbo].[chiTietDatHang]  WITH CHECK ADD  CONSTRAINT [chk_soLg] CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[chiTietDatHang] CHECK CONSTRAINT [chk_soLg]
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
ALTER TABLE [dbo].[phieuDatHang]  WITH CHECK ADD  CONSTRAINT [chk_chiecKhau] CHECK  (([chietKhau]>(0)))
GO
ALTER TABLE [dbo].[phieuDatHang] CHECK CONSTRAINT [chk_chiecKhau]
GO
--ALTER TABLE [dbo].[phieuDatHang]  WITH CHECK ADD  CONSTRAINT [chk_ngayDH] CHECK  (([ngayDatHang]>=getdate()))
--GO
--ALTER TABLE [dbo].[phieuDatHang] CHECK CONSTRAINT [chk_ngayDH]
--GO
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

--Ca
INSERT ca values (1,N'7:00',N'12:00')
INSERT ca values (2,N'13:00',N'18:00')

----test sp
--INSERT sanPham values (N'SP001',N'SGK Toán 7',N'Trần Nam Dũng',N'Giáo dục',N'NXB Giáo dục',2022,25,300000,350000,N'Good')
--INSERT sanPham values (N'SP002',N'Ăn khế trả vàng',N'Tung A',N'tich',N'Kim Dong',2021,12,312000,417000,N'Bad')
--INSERT sanPham values (N'SP003',N'Co',N'Tung B',N'cuoi',N'Kim Dong',2023,76,412213,430000,N'Good')
--INSERT sanPham values (N'SP004',N'Co Tich dâdadsads',N'Tung B',N'cuoi',N'Kim Dong',2023,76,412213,430000,N'Good')

INSERT phanCongCa values (N'NV001',1,CAST(N'2023-11-4' AS Date))
INSERT phanCongCa values (N'NV002',2,CAST(N'2023-11-4' AS Date))
INSERT phanCongCa values (N'NV003',1,CAST(N'2023-11-5' AS Date))
INSERT phanCongCa values (N'NV004',2,CAST(N'2023-11-5' AS Date))
INSERT phanCongCa values (N'NV005',1,CAST(N'2023-11-6' AS Date))
INSERT phanCongCa values (N'NV006',2,CAST(N'2023-11-6' AS Date))
INSERT phanCongCa values (N'NV001',1,CAST(N'2023-11-7' AS Date))

--INSERT phieuDatHang values (N'DH001',N'NV001',CAST(N'2002-11-5' AS Date),5,0)
--INSERT phieuDatHang values (N'DH002',N'NV002',CAST(N'2002-11-6' AS Date),9,0)

--INSERT chiTietDatHang values (N'DH001',N'SP001',1)
--INSERT chiTietDatHang values (N'DH001',N'SP002',2)
--INSERT chiTietDatHang values (N'DH001',N'SP003',3)

--select maDatHang,pdh.maNv,nv.tenNV,ngayDatHang,chietKhau from phieuDatHang pdh join nhanVien nv on pdh.maNv = nv.maNV
--where ngayDatHang BETWEEN CAST('2002-11-04' AS DATE) AND CAST('2002-11-05' AS DATE)

--select maDH,ctdh.maSP,tenSP,ctdh.soLuong from chiTietDatHang ctdh join sanPham sp on ctdh.maSP = sp.maSP
--where maDH = 'DH020'

--UPDATE sanPham set soLuong = soLuong + 8
--where maSP = 'SP001'

--select * from sanPham
--select * from taiKhoan where username = N'0799558911'
---------------------------------------------------------------------------------------------
INSERT [dbo].[khachHang] ([maKH], [tenKH], [SDT], [diaChi], [loaiKH]) VALUES (N'ád', N'ád', N'sdsd', N'ád', N'ád')
INSERT [dbo].[khachHang] ([maKH], [tenKH], [SDT], [diaChi], [loaiKH]) VALUES (N'KH1', N'Nguyễn Văn A', N'0123456', N'Gò Vấp', N'Vip')
INSERT [dbo].[khachHang] ([maKH], [tenKH], [SDT], [diaChi], [loaiKH]) VALUES (N'sach1', N'nguyễn văn a', N'123456', N'ádasdansdasd', N'Vip')
INSERT [dbo].[khachHang] ([maKH], [tenKH], [SDT], [diaChi], [loaiKH]) VALUES (N'sach2', N'Nguyễn Văn A', N'156663', N'Gò Dơ', N'Bth')
INSERT [dbo].[khachHang] ([maKH], [tenKH], [SDT], [diaChi], [loaiKH]) VALUES (N'sach3', N'abc', N'23031', N'Gò Dưa', N'Bth')
GO
INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'ggg', 13, CAST(N'2023-11-01' AS Date), CAST(N'2023-11-23' AS Date), N'KM1')
INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'abc', 15, CAST(N'2023-11-01' AS Date), CAST(N'2023-11-23' AS Date), N'KM1')
INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'111', 14, CAST(N'2023-11-03' AS Date), CAST(N'2023-11-30' AS Date), N'')
INSERT [dbo].[khuyenMai] ([maSP], [discount], [ngayTao], [ngayHetHan], [maKM]) VALUES (N'abc', 20, CAST(N'2023-11-03' AS Date), CAST(N'2023-11-30' AS Date), N'')
GO
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'111', N'abf', N'ádsd', N'ád', N'123', 123, 2, 12, 12, N'ms')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'abc', N'asd', N'asd', N'asd', N'ds', 12, 2, 12, 12, N'sd')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'ggg', N'abf', N'asd', N'asd', N'12e', 12, 3, 13, 15, N'asd')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'SP1', N'D? Mèn Phiêu Lưu Kí', N'Kim Lân', N'Truy?n Tranh', N'Kim Đ?ng', 2020, 100, 17000, 20000, N'm?i')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'SP17', N'Cha Giàu Cha Nghèo', N'Kim Lân', N'Truy?n Đ?i', N'Kim Đ?ng', 2020, 100, 18000, 28000, N'm?i')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'SP2', N'Truy?n Ki?u', N'Nguy?n Du Thiên', N'Truy?n Trinh Thám', N'Nhà Xu?t B?n Tr?', 2020, 100, 17500, 22000, N'c?')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'SP3', N'Ch? D?u', N'Kim Oanh', N'Truy?n Ng? Ngôn', N'Chính Tr? S? Th?t', 2022, 120, 19000, 23000, N'm?i')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'SP5', N'Chú Cá Vàng', N'Kim Liên', N'Truy?n Cư?i', N'Kim Đ?ng', 2022, 160, 19000, 21000, N'm?i')
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTacGia], [danhMuc], [nhaXB], [namXB], [soLuong], [donGiaGoc], [donGiaMua], [tinhTrang]) VALUES (N'SP6', N'D? Mèn Phiêu Lưu Kí', N'Kim Lân', N'Truy?n Tranh', N'Kim Đ?ng', 2020, 100, 17000, 20000, N'm?i')

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