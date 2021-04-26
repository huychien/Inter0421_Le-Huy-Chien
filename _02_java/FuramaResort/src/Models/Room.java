package Models;

import java.io.Serializable;

public class Room extends Services implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;

    private String dvMienPhi;

    public Room() {
    }

    public Room(String id, String tenDichVu, int dienTich, String chiPhiThue, String soNguoiToiDa, String kieuThue, String dvMienPhi) {
        super(id, tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, kieuThue);
        this.dvMienPhi = dvMienPhi;
    }

    public String getDvMienPhi() {
        return dvMienPhi;
    }

    public void setDvMienPhi(String dvMienPhi) {
        this.dvMienPhi = dvMienPhi;
    }

    @Override
    public void showInfor() {
        System.out.print(super.getId() + " | " + super.getTenDichVu() + " | " + super.getDienTich() + " | " + super.getChiPhiThue() + " | " + super.getSoNguoiToiDa()
                + " | " + super.getKieuThue() + " | " + this.dvMienPhi);
    }
}
