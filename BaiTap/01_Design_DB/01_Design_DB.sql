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

/*Câu 1: Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.*/

INSERT INTO BoPhan 
VALUES (1,'Sale-Marketing'),
		(2,'Hanh Chinh'),
        (3,'Phuc Vu'),
        (4,'Quan Ly');

INSERT INTO ViTri 
VALUES (1,'Le Tan'),
		(2,'Phuc Vu'),
        (3,'Chuyen Vien'),
        (4,'Giam Sat'),
        (5,'Giam Doc'),
        (6,'Quan Ly');

INSERT INTO TrinhDo 
VALUES (1,'Trung Cap'),
		(2,'Cao Dang'),
        (3,'Dai Hoc'),
        (4,'Sau Dai Hoc');

INSERT INTO NhanVien 
VALUES (1,'Nguyen Van A',1,4,1,'1999-05-05','028900004289','800','089234294','A@gmail.com','DaNang'),
		(2,'Nguyen Van B',2,2,2,'1999-05-05','035200006786','1000','0967944242','B@gmail.com','DaNang'),
        (3,'Nguyen Van C',3,3,3,'1999-05-05','089600004131','1500','023425253','C@gmail.com','DaNang'),
        (4,'Nguyen Van D',4,3,4,'1999-05-05','063400006454','2000','07866564','D@gmail.com','DaNang'),
        (5,'Nguyen Van E',5,3,2,'1999-05-05','097300003463','2500','013242324','E@gmail.com','DaNang'),
        (6,'Nguyen Van F',6,3,1,'1999-05-05','013400008967','3000','0685586897','F@gmail.com','DaNang'),
        (7,'Kuyen Van M',1,4,1,'1999-05-05','034200006454','800','089234294','M@gmail.com','DaNang'),
        (8,'Huyen Van Thoai',2,2,2,'1999-05-05','076500008776','1000','0967944242','Thoai@gmail.com','DaNang'),
        (9,'Ten Van Tien',3,3,3,'1999-05-05','034300005754','1500','023425253','Tien@gmail.com','DaNang');

INSERT INTO KieuThue 
VALUES (1,'Nam',10000),
		(2,'Thang',5000),
        (3,'Ngay',1000),
        (4,'Gio',50);

INSERT INTO LoaiDichVu 
VALUES (1,'Villa'),
		(2,'House'),
        (3,'Room');

INSERT INTO DichVu 
VALUES (1,'Room',100,1,'2','1000',3,3,'hoat dong'),
		(2,'House',200,2,'3','2000',2,2,'hoat dong'),
        (3,'Villa',1000,4,'4','5000',1,1,'hoat dong');

INSERT INTO LoaiKhach 
VALUES (1,'Diamond'),
		(2,'Platinium'),
        (3,'Gold'),
        (4,'Silver'),
        (5,'Member');

INSERT INTO KhachHang 
VALUES (1,1,'Nguyen Van J','1999-05-05','028900004289','G@gmail.com','Vinh','064563923'),
		(2,2,'Nguyen Van J','1970-05-05','035200006786','J@gmail.com','QuangTri','04234239'),
		(3,3,'Nguyen Van K','1999-05-05','089600004131','K@gmail.com','DaNang','09847352'),
		(4,4,'Nguyen Van X','1999-05-05','063400006454','X@gmail.com','Vinh','01232434'),
		(5,5,'Nguyen Van Y','1972-05-05','097300003463','Y@gmail.com','QuangNgai','012338424'),
		(6,3,'Nguyen Van Z','1999-05-05','013400008967','Z@gmail.com','DaNang','012339845'),
		(7,1,'Nguyen Van I','1990-01-12','042030003232','I@gmail.com','QuangNgai','083250740');
        
INSERT INTO HopDong 
VALUES (1,4,1,1,'2019-01-01','2021-05-20',1000,2530),
		(2,4,2,2,'2021-06-03','2021-08-01',2000,5523),
        (3,4,3,3,'2018-07-05','2018-07-20',3000,6035),
        (4,4,4,2,'2018-02-07','2022-08-07',1500,3530),
        (5,4,5,1,'2021-09-06','2023-09-06',5000,18340),
        (6,4,6,2,'2021-10-10','2021-11-10',1000,2690),
        (7,4,1,1,'2019-01-03','2021-05-20',3000,10000),
        (8,4,1,2,'2020-02-12','2020-07-12',5000,20000);
        
INSERT INTO DichVuDiKem 
VALUES (1,'massage',3523,453,'hoat dong'),
		(2,'karaoke',765,234,'hoat dong'),
        (3,'thuc an',4335,13,'hoat dong'),
        (4,'nuoc uong',345,534,'hoat dong'),
        (5,'thue xe',234,756,'hoat dong');

INSERT INTO HopDongChiTiet 
VALUES (1,1,2,2),
		(2,2,1,1),
        (3,3,4,3),
        (4,4,2,2),
        (5,5,3,4),
        (6,6,4,2);

/*Câu 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
và có tối đa 15 ký tự.*/

SELECT * FROM Furama.NhanVien
WHERE length(HoTen) <= 15 and (HoTen like 'H%' or HoTen like 'K%' or HoTen like 'T%');

/*Câu 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/

SELECT * FROM Furama.KhachHang
where (DiaChi like 'DaNang' or DiaChi like 'QuangTri') and (year(now()) - year(NgaySinh) between 18 and 50);

/*Câu 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo 
số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/

select kh.HoTen, count(kh.IdKhachHang) as SoLanDatPhong
from KhachHang kh 	join HopDong hd on kh.IdKhachHang = hd.IdKhachHang
					join LoaiKhach lk on kh.IdLoaiKhach = lk.IdLoaiKhach
Where lk.TenLoaiKhach like 'Diamond'
group by kh.HoTen
order by SoLanDatPhong;

/*Câu 5: Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phòng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/

update HopDong hd 
join HopDongChiTiet hdct on hd.IdHopDong = hdct.IdHopDong
join DichVuDiKem dvdk on hdct.IdDichVuDiKem = dvdk.IdDichVuDiKem
join DichVu dv on dv.IdDichVu = hd.IdDichVu
Set hd.TongTien = dv.ChiPhiThue + hdct.SoLuong * dvdk.Gia;
                                                                                                            
select kh.IdKhachHang, kh.HoTen, lk.TenLoaiKhach, hd.IdHopDong, dv.TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien
from KhachHang kh left join HopDong hd on kh.IdKhachHang = hd.IdKhachHang  
				  left join LoaiKhach lk on kh.IdLoaiKhach = lk.IdLoaiKhach
                  left join HopDongChiTiet hdct on hd.IdHopDong = hdct.IdHopDong
                  left join DichVuDiKem dvdk on hdct.IdDichVuDiKem = dvdk.IdDichVuDiKem
                  left join DichVu dv on dv.IdDichVu = hd.IdDichVu;
                  
/*Câu 6: Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực 
hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select distinct dv.IdDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
from DichVu dv join LoaiDichVu ldv on dv.IdLoaiDichVu = ldv.IdLoaiDichVu
			   join HopDong hd on dv.IdDichVu = hd.IdDichVu
			   join KhachHang kh on kh.IdKhachHang = hd.IdKhachHang
where dv.IdDichVu not in (select distinct dv.IdDichVu
							from DichVu dv join HopDong hd on dv.IdDichVu = hd.IdDichVu
							where year(hd.NgayLamHopDong) = 2019 and month(hd.NgayLamHopDong) between 1 and 3);

/*Câu 7: Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ 
đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.*/

select distinct dv.IdDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, ldv.TenLoaiDichVu
from DichVu dv join LoaiDichVu ldv on dv.IdLoaiDichVu = ldv.IdLoaiDichVu
			join HopDong hd on dv.IdDichVu = hd.IdDichVu
			join KhachHang kh on kh.IdKhachHang = hd.IdKhachHang
where year(hd.NgayLamHopDong) = 2018 and dv.IdDichVu not in (select distinct dv1.IdDichVu
															from DichVu dv1 join HopDong hd on dv1.IdDichVu = hd.IdDichVu
															where year(hd.NgayLamHopDong) = 2019
                                                            order by dv1.IdDichVu);
                                                            
/*Câu 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.*/	

select distinct HoTen
from KhachHang;

select HoTen
from KhachHang
group by HoTen;

select HoTen
from KhachHang
union
select HoTen
from KhachHang;

/*Câu 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ 
có bao nhiêu khách hàng thực hiện đặt phòng.*/

SELECT MONTH(hd.NgayLamHopDong) AS THANG, Count(hd.IdKhachHang) AS SoKhachHangDatPhong
FROM HopDong hd join KhachHang kh on hd.IdKhachHang = kh.IdKhachHang
WHERE year(hd.NgayLamHopDong) = 2019
GROUP BY THANG
order by THANG;

/*Câu 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).*/

select hd.IdHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, count(hdct.IdHopDongChiTiet) as SoLuongDichVuDiKem
from HopDong hd join HopDongChiTiet hdct on hd.IdHopDong = hdct.IdHopDong
group by hd.IdHopDong;

/*Câu 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là 
“Vinh” hoặc “Quảng Ngãi”.*/

select dvdk.IdDichVuDiKem, TenDichVuDiKem, Gia, DonVi, TrangThaiKhaDung, kh.IdKhachHang, DiaChi, TenLoaiKhach 
from DichVuDiKem dvdk join HopDongChiTiet hdct on dvdk.IdDichVuDiKem = hdct.IdDichVuDiKem
					  join HopDong hd on hdct.IdHopDong = hd.IdHopDong  
					  join KhachHang kh on kh.IdKhachHang = hd.IdKhachHang
					  join LoaiKhach lk on lk.IdLoaiKhach = kh.IdLoaiKhach
where (kh.DiaChi = "Vinh" or kh.DiaChi = "QuangNgai") and lk.TenLoaiKhach = "Diamond";

/*Câu 12. Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 
tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/

select hd.IdHopDong, nv.HoTen as TenNhanVien, kh.HoTen as TenKhachHang, kh.SDT as SoDienThoaiKhachHang, TenDichVu, count(IdDichVuDiKem) as SoLuongDichVuDikem, TienDatCoc
from HopDong hd join KhachHang kh on kh.IdKhachHang = hd.IdKhachHang
				join DichVu dv on dv.IdDichVu = hd.IdDichVu
				join HopDongChiTiet hdct on hdct.IdHopDong = hd.IdHopDong
                join NhanVien nv on nv.IdNhanVien = hd.IdNhanVien
Where (month(NgayLamHopDong) between 10 and 12) and year(NgayLamHopDong) = 2019 
and dv.IdDichVu not in (select distinct dv1.IdDichVu
						from DichVu dv1 join HopDong hd on dv1.IdDichVu = hd.IdDichVu
						where year(hd.NgayLamHopDong) = 2019 and (month(NgayLamHopDong) between 1 and 6)
                        order by dv1.IdDichVu)
group by hd.IdHopDong;

/*Câu 13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

select dvdk.* 
from DichVuDiKem dvdk join HopDongChiTiet hdct on hdct.IdDichVuDiKem = dvdk.IdDichVuDiKem
Where dvdk.IdDichVuDiKem is not null
group by hdct.IdDichVuDiKem
having count(hdct.IdHopDongChiTiet) >= all (select count(IdHopDongChiTiet)
										From HopDongChiTiet
                                        group by IdDichVuDiKem);

/*Câu 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị 
bao gồm TenDichVuDiKem, SoLanSuDung.*/

select DichVuDiKem.IdDichVuDiKem, DichVuDiKem.TenDichVuDiKem, count(HopDongChiTiet.IdDichVuDiKem) as so_lan   
from KhachHang kh   join HopDong on kh.IdKhachHang = HopDong.IdKhachHang    
					join HopDongChiTiet on HopDong.IdHopDong = HopDongChiTiet.IdHopDong    
					join DichVuDiKem on HopDongChiTiet.IdDichVuDiKem = DichVuDiKem.IdDichVuDiKem     
group by IdDichVuDiKem 
having so_lan = 1;

/*Câu 15. Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai,
 DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
 
select hd.IdNhanVien, HoTen, TrinhDo, TenBoPhan, SDT, DiaChi
from NhanVien nv join HopDong hd on hd.IdNhanVien = nv.IdNhanVien
				 join TrinhDo td on td.IdTrinhDo = nv.IdTrinhDo
				 join BoPhan bp on bp.IdBoPhan = nv.IdBoPhan
group by hd.IdNhanVien
having count(hd.IdHopDong) <= 3;

/*Câu 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/

delete 
from NhanVien
where NhanVien.IdNhanVien not in (SELECT IdNhanVien FROM Furama.HopDong);

/*Câu 17. Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng
đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/

update KhachHang kh
join LoaiKhach lk on kh.IdLoaiKhach = lk.IdLoaiKhach
join HopDong hd on hd.IdKhachHang = kh.IdKhachHang
Set kh.IdLoaiKhach = 1
where kh.IdKhachHang in (select IdKhachHang
						from HopDong hd
                        where year(hd.NgayLamHopDong) = 2019 
						group by hd.IdKhachHang
						having sum(TongTien) > 10000000);
