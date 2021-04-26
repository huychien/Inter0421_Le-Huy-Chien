package Models;

import java.io.Serializable;

public class Villa extends Services implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    private String tieuChuan;
    private String tienNghiKhac;
    private int dienTichHoBoi;
    private int soTang;

    public Villa() {
    }

    public Villa(String id, String tenDichVu, int dienTich, String chiPhiThue, String soNguoiToiDa, String kieuThue, String tieuChuan, String tienNghiKhac, int dienTichHoBoi, int soTang) {
        super(id, tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.tieuChuan = tieuChuan;
        this.tienNghiKhac = tienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
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

    public int getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(int dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
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
                + " | " + super.getKieuThue() + " | " + this.tieuChuan + " | " + this.tienNghiKhac + " | " + this.dienTichHoBoi + " | " + this.soTang);
    }
}
