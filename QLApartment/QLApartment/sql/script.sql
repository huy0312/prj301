USE [Quan_Ly_Nha_Tro]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/21/2023 05:44:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[roll] [int] NOT NULL,
	[role_id] [int] NULL,
	[idKH] [int] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Apartment]    Script Date: 6/21/2023 05:44:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Apartment](
	[idPhong] [int] IDENTITY(1,1) NOT NULL,
	[idKH] [int] NULL,
	[thangThue] [int] NOT NULL,
	[giaThue] [float] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_Apartment] PRIMARY KEY CLUSTERED 
(
	[idPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 6/21/2023 05:44:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[idKH] [int] IDENTITY(1,1) NOT NULL,
	[tenKH] [nvarchar](50) NOT NULL,
	[SDT] [nchar](15) NOT NULL,
	[CMND] [nchar](15) NOT NULL,
	[gioiTinh] [int] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[idKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 6/21/2023 05:44:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[idInvoice] [int] IDENTITY(1,1) NOT NULL,
	[idPhong] [int] NOT NULL,
	[tongTien] [float] NOT NULL,
	[soDien] [int] NOT NULL,
	[soNuoc] [int] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_Invoice] PRIMARY KEY CLUSTERED 
(
	[idInvoice] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 6/21/2023 05:44:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 6/21/2023 05:44:48 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[idDV] [int] IDENTITY(1,1) NOT NULL,
	[idInvoice] [int] NOT NULL,
	[tenDV] [nvarchar](50) NOT NULL,
	[giaDV] [float] NOT NULL,
	[trangThai] [int] NOT NULL,
 CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED 
(
	[idDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'KM', N'123456', 0, 1, NULL)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'LinhNVB', N'123456', 0, 1, NULL)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'Manh', N'123456', 0, 2, 39)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'NamDH', N'123456', 0, 2, 38)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'NamDH2', N'123456', 0, 2, 1028)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'NamDH3', N'123456', 0, 2, 1029)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'NamDH4', N'123456', 0, 2, 1030)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'NamDH5', N'123456', 0, 2, 2027)
INSERT [dbo].[Account] ([username], [password], [roll], [role_id], [idKH]) VALUES (N'Thanh', N'123456', 0, 2, 29)
GO
SET IDENTITY_INSERT [dbo].[Apartment] ON 

INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (1, 12, 1, 1000000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (2, 13, 3, 1000000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (3, 14, 3, 1500000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (4, 16, 1, 1500000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (5, 17, 1, 1000000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (6, 20, 1, 1300000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (7, 18, 2, 1000000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (8, 19, 1, 1800000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (9, 22, 1, 1000000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (10, 29, 1, 1800000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (11, 38, 3, 1000000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (12, NULL, 2, 1300000, 2)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (13, NULL, 0, 1000000, 3)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (14, 21, 0, 0, 0)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (15, NULL, 0, 0, 0)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (16, NULL, 0, 0, 0)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (17, NULL, 0, 0, 0)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (18, NULL, 0, 0, 0)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (19, NULL, 0, 1500000, 3)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (20, 12, 1, 12, 0)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (21, 14, 1, 10000, 1)
INSERT [dbo].[Apartment] ([idPhong], [idKH], [thangThue], [giaThue], [trangThai]) VALUES (22, 12, 1, 11111, 1)
SET IDENTITY_INSERT [dbo].[Apartment] OFF
GO
SET IDENTITY_INSERT [dbo].[Customers] ON 

INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (11, N'Nguyễn Văn Bảo Linh', N'0934412001     ', N'092200006400   ', 1, 0)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (12, N'Phùng Duy Khương', N'0915994525     ', N'098200005500   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (13, N'Lê Hải', N'0789123123     ', N'092200004450   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (14, N'Lê Minh Anh', N'0789124561     ', N'092201110600   ', 2, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (15, N'Phan Ngọc Linh', N'0917359115     ', N'091234712472   ', 2, 0)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (16, N'Lê Đình Tuấn', N'0915994123     ', N'092200789123   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (17, N'Nguyễn Đức Mạnh', N'0915789321     ', N'092211116400   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (18, N'Nguyễn Văn Trung', N'0913022123     ', N'092200001210   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (19, N'Nguyễn Trà My', N'0915444222     ', N'091122006400   ', 2, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (20, N'Hoàng Văn Long', N'0913022010     ', N'082208880600   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (21, N'Mai Quang Trường', N'0789123741     ', N'092201110666   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (22, N'Hoàng Tuấn Tú', N'0789123741     ', N'092201110666   ', 1, 0)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (23, N'Lê Trung Đức', N'0912366947     ', N'052201235600   ', 1, 0)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (24, N'Hoàng Ngọc Long', N'0913022909     ', N'078901235678   ', 1, 0)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (25, N'Nguyễn Văn Hùng', N'0789123259     ', N'072201133440   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (26, N'Lê Bảo Chân', N'0912325456     ', N'062211123567   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (29, N'Nguyễn Thành', N'0987654321     ', N'062211123567   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (38, N'Đinh H Nam', N'0123456789     ', N'012345678912   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (39, N'Nguyễn Hoài Nam', N'0375801453     ', N'123456789      ', 2, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (1027, N'Đinh H Nam', N'0123456789     ', N'012345678912   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (1028, N'Đinh H Nam', N'0123456789     ', N'012345678912   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (1029, N'Đinh H Nam3', N'0123456789     ', N'012345678912   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (1030, N'Đinh H Nam3', N'0123456789     ', N'012345678912   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (2027, N'Đinh H Nam3', N'0123456789     ', N'012345678912   ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (2028, N'khanh manh', N'0375801453     ', N'1234567890877  ', 1, 1)
INSERT [dbo].[Customers] ([idKH], [tenKH], [SDT], [CMND], [gioiTinh], [trangThai]) VALUES (2029, N'khanh manhh', N'0375801453     ', N'1234567890877  ', 1, 0)
SET IDENTITY_INSERT [dbo].[Customers] OFF
GO
SET IDENTITY_INSERT [dbo].[Invoice] ON 

INSERT [dbo].[Invoice] ([idInvoice], [idPhong], [tongTien], [soDien], [soNuoc], [trangThai]) VALUES (13, 3, 2024000, 3, 4, 1)
INSERT [dbo].[Invoice] ([idInvoice], [idPhong], [tongTien], [soDien], [soNuoc], [trangThai]) VALUES (15, 7, 1999600, 4, 5, 2)
INSERT [dbo].[Invoice] ([idInvoice], [idPhong], [tongTien], [soDien], [soNuoc], [trangThai]) VALUES (17, 20, 1125000, 5, 5, 1)
INSERT [dbo].[Invoice] ([idInvoice], [idPhong], [tongTien], [soDien], [soNuoc], [trangThai]) VALUES (18, 11, 1290000, 1, 1, 2)
INSERT [dbo].[Invoice] ([idInvoice], [idPhong], [tongTien], [soDien], [soNuoc], [trangThai]) VALUES (19, 8, 1120000, 5, 5, 1)
INSERT [dbo].[Invoice] ([idInvoice], [idPhong], [tongTien], [soDien], [soNuoc], [trangThai]) VALUES (20, 2, 3000000, 10, 1, 2)
SET IDENTITY_INSERT [dbo].[Invoice] OFF
GO
SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (1, N'manager')
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (2, N'customer')
SET IDENTITY_INSERT [dbo].[Role] OFF
GO
SET IDENTITY_INSERT [dbo].[Service] ON 

INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (18, 13, N'Nước', 3000, 3)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (19, 13, N'Điện', 3000, 3)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (20, 13, N'Dọn Phòng ', 100000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (21, 15, N'Đổ Rác', 30000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (22, 15, N'Mạng', 50000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (23, 17, N'Mì Xào', 20000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (24, 17, N'Nước Ngọt', 10000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (25, 19, N'Cơm Rang', 30000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (26, 13, N'Đánh Chìa', 50000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (28, 13, N'Bể Bơi', 30000, 2)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (29, 13, N'Sân Bóng', 30000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (30, 13, N'Cafe', 25000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (31, 13, N'Matxa', 100000, 1)
INSERT [dbo].[Service] ([idDV], [idInvoice], [tenDV], [giaDV], [trangThai]) VALUES (32, 13, N'Điện', 1111, 3)
SET IDENTITY_INSERT [dbo].[Service] OFF
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([role_id])
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Customers] FOREIGN KEY([idKH])
REFERENCES [dbo].[Customers] ([idKH])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Customers]
GO
ALTER TABLE [dbo].[Apartment]  WITH CHECK ADD  CONSTRAINT [FK_Apartment_Customers] FOREIGN KEY([idKH])
REFERENCES [dbo].[Customers] ([idKH])
GO
ALTER TABLE [dbo].[Apartment] CHECK CONSTRAINT [FK_Apartment_Customers]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Apartment] FOREIGN KEY([idPhong])
REFERENCES [dbo].[Apartment] ([idPhong])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Apartment]
GO
ALTER TABLE [dbo].[Service]  WITH CHECK ADD  CONSTRAINT [FK_Service_Invoice] FOREIGN KEY([idInvoice])
REFERENCES [dbo].[Invoice] ([idInvoice])
GO
ALTER TABLE [dbo].[Service] CHECK CONSTRAINT [FK_Service_Invoice]
GO
