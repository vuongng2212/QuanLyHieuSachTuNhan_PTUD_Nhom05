CREATE DATABASE qlsach
--DROP DATABASE qlsach
GO
USE [qlsach]
GO

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--VUONG
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[taiKhoan](
	[username] [nvarchar](10) NOT NULL,
	[pwd] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](5) NOT NULL,
	[tenNV] [nvarchar](100) NOT NULL,
	[dob] [date] NOT NULL,
	[sdt] [nvarchar](10) NOT NULL UNIQUE,
	[diaChi] [nvarchar](100) NOT NULL,
	[chucVu] [nvarchar](50) NOT NULL,
	[email] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[PhieuDatHang]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phieuNhap](
	[maNH] [nvarchar](5) NOT NULL,
	[maNV] [nvarchar](5) NOT NULL,
	[ngayNhapHang] [date] NOT NULL,
	[chietKhau] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietNhapHang](
	[maMH] [nvarchar](5) NOT NULL,
	[maSP] [nvarchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC,
	[maMH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[phanCongCa]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[phanCongCa](
	[maNV] [nvarchar](5) NOT NULL,
	[ngayLamViec] [date] NOT NULL,
	[maCa] [nvarchar](5) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ngayLamViec] ASC,
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ca]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[ca](
	[maCa] [nvarchar](5) NOT NULL,
	[startTime] [nvarchar](10) NOT NULL,
	[endTime] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





--TUAN
/****** Object:  Table [dbo].[chiTietHoaDon]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chiTietHoaDon](
	[maHD] [nvarchar](10) NOT NULL,
	[maSP] [nvarchar](10) NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC,
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDon]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[maHD] [nvarchar](10) NOT NULL,
	[maNV] [nvarchar](5) NOT NULL,
	[maKH] [nvarchar](10) NOT NULL,
	[ngayTaoHD] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachHang]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachHang](
	[maKH] [nvarchar](10) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[SDT] [nvarchar](10) NOT NULL,
	[diaChi] [nvarchar](100) NULL,
	[loaiKH] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khuyenMai]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khuyenMai](
	[maSP] [nvarchar](10) NOT NULL,
	[discount] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sanPham]    Script Date: 10/29/2023 7:12:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanPham](
	[maSP] [nvarchar](10) NOT NULL,
	[tenSP] [nvarchar](100) NOT NULL,
	[tenTG] [nvarchar](100) NOT NULL,
	[nhaXB] [nvarchar](100) NOT NULL,
	[namXB] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[tinhTrang] [nvarchar](20) NOT NULL,
	[danhMuc] [nvarchar](20) NOT NULL,
	[donGiaGoc] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/*SAMPLE DATA*/
--Nhan vien
INSERT [dbo].[NhanVien] VALUES (N'NV001', N'Nguyễn Đức Vương', CAST(N'2002-12-22' AS Date), '0799558911', N'270, ấp 8, xã Sơn Phú, huyện Giồng Trôm, tỉnh Bến Tre', N'QL', N'vuongnguyen221203@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV002', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558912', N'Ba Dinh', N'NV', N'quangD1@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV003', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558913', N'Hang Ray', N'NV', N'kimHN2@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV004', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558914', N'Ba Dinh', N'NV', N'quangD3@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV005', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558915', N'Ba Dinh', N'NV', N'quangD4@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV006', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558916', N'Ba Dinh', N'NV', N'quangD5@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV007', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558917', N'Hang Ray', N'NV', N'kimHN6@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV008', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558918', N'Hang Ray', N'NV', N'kimH7N@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV009', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558919', N'Hang Ray', N'NV', N'kimHN8@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV010', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558901', N'Hang Ray', N'NV', N'kimHN9@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV011', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558902', N'Hang Ray', N'NV', N'kim34HN@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV012', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558903', N'Ba Dinh', N'NV', N'quang34D@gmail.com')
INSERT [dbo].[NhanVien] VALUES (N'NV013', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558904', N'Ba Dinh', N'NV', N'quangD75@gmail.com')
GO

INSERT [dbo].[chiTietHoaDon] ([maHD], [maSP], [soLuong], [donGia]) VALUES (N'1', N'SP1', 20, 175000)
GO
INSERT [dbo].[hoaDon] ([maHD], [maNV], [maKH], [ngayTaoHD]) VALUES (N'1', N'NV001', N'1', CAST(N'2023-11-12' AS Date))
INSERT [dbo].[hoaDon] ([maHD], [maNV], [maKH], [ngayTaoHD]) VALUES (N'2', N'NV001', N'1', CAST(N'2023-11-12' AS Date))
INSERT [dbo].[hoaDon] ([maHD], [maNV], [maKH], [ngayTaoHD]) VALUES (N'3', N'NV002', N'3', CAST(N'2022-10-30' AS Date))
GO
INSERT [dbo].[khachHang] ([maKH], [hoTen], [SDT], [diaChi], [loaiKH]) VALUES (N'1', N'Nguyen Van A', 123456, N'Han Thuyen', N'VL')
INSERT [dbo].[khachHang] ([maKH], [hoTen], [SDT], [diaChi], [loaiKH]) VALUES (N'2', N'Nguyen Van A', 456789, N'Han Thuyen', N'TV')
INSERT [dbo].[khachHang] ([maKH], [hoTen], [SDT], [diaChi], [loaiKH]) VALUES (N'4', N'Nguyen Van D', 456012, N'Han Thuyen', N'TV')
GO
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTG], [nhaXB], [namXB], [soLuong], [donGia], [tinhTrang], [danhMuc], [donGiaGoc]) VALUES (N'SP1', N'Lam Di', N'Vu Trong Phung', N'Kim Dong', 2017, 100, 20000, N'moi', N'truyen ngu ngon', 175000)
INSERT [dbo].[sanPham] ([maSP], [tenSP], [tenTG], [nhaXB], [namXB], [soLuong], [donGia], [tinhTrang], [danhMuc], [donGiaGoc]) VALUES (N'SP3', N'Truyen Kieu', N'Nguyen Du', N'Kim Dong', 2017, 100, 20000, N'moi', N'truyen ngu ngon', 175000)
GO
/****** Object:  Index [UQ__khachHan__CA1930A58CDB00F0]    Script Date: 10/29/2023 7:12:22 PM ******/
ALTER TABLE [dbo].[khachHang] ADD UNIQUE NONCLUSTERED 
(
	[SDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NhanVien__AB6E61642B6F88D9]    Script Date: 10/29/2023 7:12:22 PM ******/
ALTER TABLE [dbo].[NhanVien] ADD UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  Index [UQ__NhanVien__DDDFB483249DA44D]    Script Date: 10/29/2023 7:12:22 PM ******/
ALTER TABLE [dbo].[NhanVien] ADD UNIQUE NONCLUSTERED 
(
	[sdt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__sanPham__FB7400556127C7FC]    Script Date: 10/29/2023 7:12:22 PM ******/
ALTER TABLE [dbo].[sanPham] ADD UNIQUE NONCLUSTERED 
(
	[tenSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[chiTietNhapHang]  WITH CHECK ADD FOREIGN KEY([maNH])
REFERENCES [dbo].[phieuNhap] ([maNH])
GO
ALTER TABLE [dbo].[chiTietDatHang]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[chiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[hoaDon] ([maHD])
GO
ALTER TABLE [dbo].[chiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__chiTietHoa__maSP__0E6E26BF] FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[chiTietHoaDon] CHECK CONSTRAINT [FK__chiTietHoa__maSP__0E6E26BF]
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[khuyenMai]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[sanPham] ([maSP])
GO
ALTER TABLE [dbo].[phanCongCa]  WITH CHECK ADD FOREIGN KEY([maCa])
REFERENCES [dbo].[ca] ([maCa])
GO
ALTER TABLE [dbo].[phanCongCa]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[phieuNhap]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[taiKhoan]  WITH CHECK ADD FOREIGN KEY([username])
REFERENCES [dbo].[NhanVien] ([sdt])
GO
ALTER TABLE [dbo].[chiTietNhapHang]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[chiTietHoaDon]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[khachHang]  WITH CHECK ADD CHECK  (([loaiKH]='TV' OR [loaiKH]='VL'))
GO
ALTER TABLE [dbo].[khuyenMai]  WITH CHECK ADD CHECK  (([discount]>(0) AND [discount]<(100)))
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD CHECK  (([chucVu]='NV' OR [chucVu]=N'QL'))
GO

/*SAMPLE DATA*/
--Nhan vien
--INSERT [dbo].[NhanVien] VALUES (N'NV001', N'Nguyễn Đức Vương', CAST(N'2002-12-22' AS Date), '0799558911', N'270, ấp 8, xã Sơn Phú, huyện Giồng Trôm, tỉnh Bến Tre', N'QL', N'vuongnguyen221203@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV002', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558912', N'Ba Dinh', N'NV', N'quangD1@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV003', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558913', N'Hang Ray', N'NV', N'kimHN2@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV004', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558914', N'Ba Dinh', N'NV', N'quangD3@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV005', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558915', N'Ba Dinh', N'NV', N'quangD4@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV006', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558916', N'Ba Dinh', N'NV', N'quangD5@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV007', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558917', N'Hang Ray', N'NV', N'kimHN6@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV008', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558918', N'Hang Ray', N'NV', N'kimH7N@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV009', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558919', N'Hang Ray', N'NV', N'kimHN8@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV010', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558901', N'Hang Ray', N'NV', N'kimHN9@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV011', N'Nguyen Kim', CAST(N'2002-12-12' AS Date), '0799558902', N'Hang Ray', N'NV', N'kim34HN@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV012', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558903', N'Ba Dinh', N'NV', N'quang34D@gmail.com')
--INSERT [dbo].[NhanVien] VALUES (N'NV013', N'Duong Quang', CAST(N'2002-12-12' AS Date), '0799558904', N'Ba Dinh', N'NV', N'quangD75@gmail.com')
--GO