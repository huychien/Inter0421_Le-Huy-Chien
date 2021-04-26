package Models;

import java.io.Serializable;

public class House extends Services implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    private String tieuChuan;
    private String tienNghiKhac;
    private int soTang;

    public House() {
    }

    public House(String id, String tenDichVu, int dienTich, String chiPhiThue, String soNguoiToiDa, String kieuThue, String tieuChuan, String tienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.tieuChuan = tieuChuan;
        this.tienNghiKhac = tienNghiKhac;
        this.soTang = soTang;
    }

    public String getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(String tieuChuan) {
        this.tieuChuan = tieuChuan;
    }

    public String getTienNghiKhac() {
        return tienNghiKhac;
    }

    public void setTienNghiKhac(String tienNghiKhac) {
        this.tienNghiKhac = tienNghiKhac;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public void showInfor() {
        System.out.println(super.getId() + " | " + super.getTenDichVu() + " | " + super.getDienTich() + " | " + super.getChiPhiThue() + " | " + super.getSoNguoiToiDa()
                + " | " + super.getKieuThue() + " | " + this.tieuChuan + " | " + this.tienNghiKhac + " | " + this.soTang);
    }
}
