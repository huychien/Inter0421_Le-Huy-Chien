/*Câu 21. Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”*/

CREATE VIEW V_NHANVIEN AS
SELECT nv.*
FROM NhanVien nv join HopDong hd on hd.IdNhanVien = nv.IdNhanVien
WHERE nv.DiaChi = "HaiChau" and hd.NgayLamHopDong = "2019-12-12";

SELECT * from V_NHANVIEN;

/*Câu 22. Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.*/

update V_NHANVIEN 
set DiaCHi = "LienChieu";

/*Câu 23. Tạo Clustered Index có tên là IX_KHACHHANG trên bảng Khách hàng. Giải thích lý do và thực hiện kiểm tra 
tính hiệu quả của việc sử dụng INDEX*/

/* Clustered Index chính là khóa chính. Sau khi đánh INDEX thì số rows cần phải duyệt chính là số rows kết quả sẽ trả ra. Nếu không đánh Index thì sẽ 
duyệt tất cả row có trong bảng. */
CREATE UNIQUE INDEX IX_KHACHHANG ON KhachHang(IdKhachHang);

EXPLAIN SELECT * FROM KhachHang WHERE IdKhachHang = 2;
/* Kết luận sử dụng Index để tăng tốc độ của quá trình truy vấn dữ liệu. */

/*Câu 24. Tạo Non-Clustered Index có tên là IX_SoDT_DiaChi trên các cột SODIENTHOAI và DIACHI trên bảng KHACH HANG 
và kiểm tra tính hiệu quả tìm kiếm sau khi tạo Index.*/

CREATE INDEX IX_SoDT_DiaChi ON KhachHang(DiaChi, SDT);

EXPLAIN SELECT * FROM KhachHang WHERE DiaChi = "Ving" and SDT = "064563923";

/*Câu 25. Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được 
truyền vào như là 1 tham số của Sp_1*/

DELIMITER //

CREATE PROCEDURE Sp_1(IN id_kh INT, OUT message VARCHAR(50))
	IF id_kh in (Select IdKhachHang from KhachHang) THEN
		BEGIN
			DELETE FROM KhachHang WHERE KhachHang.IdKhachHang = id_kh;
			SET message = "Đã xóa Khách Hàng" ;
		END;
	ELSE
		BEGIN
			SET message = "Khách Hàng không tồn tại" ;
		END;
	END IF;
//  DELIMITER ;

CALL Sp_1(1, @message);

SELECT @message;

/*Câu 26. Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải 
thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và 
đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.*/

DELIMITER //

CREATE PROCEDURE Sp_2(in IdHopDong1 int, IdNhanVien1 int, IdKhachHang1 int, IdDichVu1 int, NgayKetThuc date, TienDatCoc int, out message varchar(50))
	IF IdNhanVien1 in (Select IdNhanVien from NhanVien) and IdKhachHang1 in (Select IdKhachHang from KhachHang)
														and IdDichVu1 in (Select IdDichVu from DichVu)
														and IdHopDong1 not in (Select IdHopDong from HopDong) THEN
		BEGIN
			INSERT INTO HopDong
			VALUE (IdHopDong1, IdNhanVien1, IdKhachHang1, IdDichVu1, now(), NgayKetThuc, TienDatCoc, 0);
            SET message = "Đã thêm hợp đồng" ;
		END;
	ELSE
		BEGIN
			SET message = "Lỗi" ;
		END;
	END IF;
//  DELIMITER ;

CALL Sp_2(12, 1, 3, 3, '2021-01-01', 2000, @message);
SELECT @message;

/*Câu 27. Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại
 có trong bảng HopDong ra giao diện console của database.*/

DELIMITER //

CREATE TRIGGER Tr_1
	After DELETE ON HopDong
	FOR EACH ROW
    Begin

    END;
//  DELIMITER ;

delete from HopDong where IdHopDong = 12;
select count(IdHopDong) from HopDong

/*Câu 28. Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không 
hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.*/

DELIMITER //

CREATE TRIGGER Tr_2
	BEFORE UPDATE ON HopDong
	FOR EACH ROW
    Begin
		If new.NgayKetThuc - Old.NgayLamHopDong < 2 Then
			begin
				SIGNAL SQLSTATE VALUE 'HY000'
				SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
			end;
		END IF;
    END;
//  DELIMITER ;

/*Câu 29. Tạo user function thực hiện yêu cầu sau:
        a. Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
        b. Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng 
        đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). 
        Mã của Khách hàng được truyền vào như là 1 tham số của function này.*/

a) DELIMITER //

CREATE FUNCTION func_1(so_tien int)
	RETURNS VARCHAR(20)
	DETERMINISTIC
BEGIN
	RETURN (select count(IdDichVu) from HopDong 
			where TongTien >= so_tien 
			group by IdDichVu);
END;
// DELIMITER ;

SELECT func_1(2000000) as số_dv_đã_được_sử_dụng_với_Tổng_tiền_là_lớn_hơn_2000000_VNĐ;

b) DELIMITER //

CREATE FUNCTION Func_2(id int)
	RETURNS VARCHAR(20)
	DETERMINISTIC
BEGIN
	RETURN (select distinct DATEDIFF(NgayKetThuc, NgayLamHopDong) as so_ngay_max 
			from HopDong
			where IdKhachHang = id and DATEDIFF(NgayKetThuc, NgayLamHopDong) >= all (select DATEDIFF(NgayKetThuc, NgayLamHopDong) as so_ngay_max 
																					 from HopDong 
                                                                                     where IdKhachHang = id));
END;
// DELIMITER ;

SELECT Func_2(2) as số_ngày_dài_nhất; 

/*Câu 30. Tạo Stored procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa 
thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) 
và những bản liên quan khác.*/

ALTER TABLE HopDong
DROP FOREIGN KEY HopDong_fk_3;
            
ALTER TABLE HopDong 
ADD CONSTRAINT HopDong_fk_3
FOREIGN KEY (IdDichVu)
REFERENCES DichVu (IdDichVu)
ON DELETE CASCADE;

ALTER TABLE HopDongChiTiet 
DROP FOREIGN KEY HopDongChiTiet_fk_2;
            
ALTER TABLE HopDongChiTiet 
ADD CONSTRAINT HopDongChiTiet_fk_2
FOREIGN KEY (IdHopDong)
REFERENCES HopDong (IdHopDong)
ON DELETE CASCADE;
              
DELIMITER //

CREATE PROCEDURE Sp_3(in Loai_dv varchar(45), nam_bat_dau int, nam_ket_thuc int)
		BEGIN
			Declare id int;
            Set id = (Select distinct hd.IdDichVu
					  from HopDong hd join DichVu dv on dv.IdDichVu = hd.IdDichVu
									  join LoaiDichVu ldv on ldv.IdLoaiDichVu = dv.IdLoaiDichVu
					  where ldv.TenLoaiDichVu = Loai_dv and (Year(hd.NgayKetThuc) between nam_bat_dau and nam_ket_thuc));
			Delete from DichVu
            where DichVu.IdDichVu = id;
		END;
//  DELIMITER ;

CALL Sp_3("House", 2015, 2019);