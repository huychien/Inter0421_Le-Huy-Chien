package Models;

import Commons.NameOrBirthdayComparator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Customer implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String soCMND;
    private String sdt;
    private String email;
    private String loaiKhach;
    private String diaChi;
    private Services services;

    public Customer() {
    }

    public Customer(String hoTen, Date ngaySinh, String gioiTinh, String soCMND, String sdt, String email, String loaiKhach, String diaChi) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.sdt = sdt;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public static void showInformationCustomers(ArrayList<Customer> list) {
        Collections.sort(list, new NameOrBirthdayComparator());
        int id = 1;
        for (Customer customer: list) {
//            System.out.println("HoTen | NgaySinh | GioiTinh | SoCMND | SDT | Email | LoaiKhach | DiaChi");
            System.out.println(id + " | " + customer.getHoTen() + " | " + customer.getNgaySinh() + " | " + customer.getGioiTinh() + " | " + customer.getSoCMND()
                    + " | " + customer.getSdt() + " | " + customer.getEmail() + " | " + customer.getLoaiKhach() + " | " + customer.getDiaChi());
            id++;
        }
    }

    public void showInfor() {
        this.services.showInfor();
    }
}
