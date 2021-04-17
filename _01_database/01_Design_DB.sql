CREATE DATABASE  IF NOT EXISTS Furama;

CREATE TABLE BoPhan (
  IdBoPhan int NOT NULL AUTO_INCREMENT,
  TenBoPhan varchar(45),
  PRIMARY KEY (IdBoPhan)
);

CREATE TABLE TrinhDo (
  IdTrinhDo int NOT NULL AUTO_INCREMENT,
  TrinhDo varchar(45),
  PRIMARY KEY (IdTrinhDo)
);

CREATE TABLE ViTri (
  IdViTri int NOT NULL AUTO_INCREMENT,
  TenViTri varchar(45),
  PRIMARY KEY (IdViTri)
);

CREATE TABLE NhanVien (
  IdNhanVien int NOT NULL AUTO_INCREMENT,
  HoTen varchar(45),
  IdViTri int,
  IdTrinhDo int,
  IdBoPhan int,
  NgaySinh date,
  SoCMTND varchar(45),
  Luong varchar(45),
  SDT varchar(45),
  Email varchar(45),
  DiaChi varchar(45),
  PRIMARY KEY (IdNhanVien),
  CONSTRAINT FK_BoPhanNhanVien FOREIGN KEY (IdBoPhan) REFERENCES BoPhan (IdBoPhan),
  CONSTRAINT FK_TrinhDoNhanVien FOREIGN KEY (IdTrinhDo) REFERENCES TrinhDo (IdTrinhDo),
  CONSTRAINT FK_ViTriNhanVien FOREIGN KEY (IdViTri) REFERENCES ViTri (IdViTri)
);

CREATE TABLE KieuThue (
  IdKieuThue int NOT NULL AUTO_INCREMENT,
  TenKieuThue varchar(45),
  Gia int,
  PRIMARY KEY (IdKieuThue)
);

CREATE TABLE LoaiDichVu (
  IdLoaiDichVu int NOT NULL AUTO_INCREMENT,
  TenLoaiDichVu varchar(45),
  PRIMARY KEY (IdLoaiDichVu)
);

CREATE TABLE DichVu (
  IdDichVu int NOT NULL AUTO_INCREMENT,
  TenDichVu varchar(45),
  DienTich int,
  SoTang int,
  SoNguoiToiDa varchar(45),
  ChiPhiThue varchar(45),
  IdKieuThue int,
  IdLoaiDichVu int,
  TrangThai varchar(45),
  PRIMARY KEY (IdDichVu),
  CONSTRAINT DichVu_fk_1 FOREIGN KEY (IdKieuThue) REFERENCES KieuThue (IdKieuThue),
  CONSTRAINT DichVu_fk_2 FOREIGN KEY (IdLoaiDichVu) REFERENCES LoaiDichVu (IdLoaiDichVu)
);

CREATE TABLE LoaiKhach (
  IdLoaiKhach int NOT NULL AUTO_INCREMENT,
  TenLoaiKhach varchar(45),
  PRIMARY KEY (IdLoaiKhach)
);

CREATE TABLE KhachHang (
  IdKhachHang int NOT NULL AUTO_INCREMENT,
  IdLoaiKhach int,
  HoTen varchar(45),
  NgaySinh date,
  SoCMTND varchar(45),
  Email varchar(45),
  DiaChi varchar(45),
  SDT varchar(45),
  PRIMARY KEY (IdKhachHang),
  KEY IdLoaiKhach (IdLoaiKhach),
  CONSTRAINT KhachHang_ibfk_1 FOREIGN KEY (IdLoaiKhach) REFERENCES LoaiKhach (IdLoaiKhach)
);

CREATE TABLE HopDong (
  IdHopDong int NOT NULL AUTO_INCREMENT,
  IdNhanVien int,
  IdKhachHang int,
  IdDichVu int,
  NgayLamHopDong date,
  NgayKetThuc date,
  TienDatCoc int,
  TongTien int,
  PRIMARY KEY (IdHopDong),
  CONSTRAINT HopDong_fk_1 FOREIGN KEY (IdNhanVien) REFERENCES NhanVien (IdNhanVien),
  CONSTRAINT HopDong_fk_2 FOREIGN KEY (IdKhachHang) REFERENCES KhachHang (IdKhachHang),
  CONSTRAINT HopDong_fk_3 FOREIGN KEY (IdDichVu) REFERENCES DichVu (IdDichVu)
);

CREATE TABLE DichVuDiKem (
  IdDichVuDiKem int NOT NULL AUTO_INCREMENT,
  TenDichVuDiKem varchar(45),
  Gia int,
  DonVi int,
  TrangThaiKhaDung varchar(45),
  PRIMARY KEY (IdDichVuDiKem)
);

CREATE TABLE HopDongChiTiet (
  IdHopDongChiTiet int NOT NULL AUTO_INCREMENT,
  IdHopDong int,
  IdDichVuDiKem int,
  SoLuong int,
  PRIMARY KEY (IdHopDongChiTiet),
  CONSTRAINT HopDongChiTiet_fk_1 FOREIGN KEY (IdDichVuDiKem) REFERENCES DichVuDiKem (IdDichVuDiKem),
  CONSTRAINT HopDongChiTiet_fk_2 FOREIGN KEY (IdHopDong) REFERENCES HopDong (IdHopDong)
);