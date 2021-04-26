package Commons;

import java.util.Scanner;

public class AddServices {
    public static String writeId() {
        System.out.println("Enter id: ");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        boolean check = id.matches("SVVL-\\d{4}|SVHO-\\d{4}|SVRO-\\d{4}");
        if (check) {
            return id;
        } else {
            System.out.println("Required to enter the correct format SVXX-YYYY !!!");
            return writeId();
        }
    }

    public static String writeTenDv() {
        System.out.println("Enter Ten Dich Vu: ");
        Scanner input = new Scanner(System.in);
        String tenDv = input.nextLine();
        boolean check = tenDv.matches("\\A[A-Z][a-z ]*");
        if (check) {
            return tenDv;
        } else {
            System.out.println("The first character must be capitalized and no digits are allowed !!!");
            return writeTenDv();
        }
    }

    public static int writeDienTich() {
        System.out.println("Enter Dien Tich: ");
        Scanner input = new Scanner(System.in);
        int dienTich = input.nextInt();
        String dienTich_str = "" + dienTich;
        boolean check = dienTich_str.matches("[3-9][0-9]|[0-9]{3,}");
        if (check) {
            return dienTich;
        } else {
            System.out.println("The usable area must be real numbers greater than 30m2 !!!");
            return writeDienTich();
        }
    }

    public static String writeChiPhiThue() {
        System.out.println("Enter Chi Phi Thue: ");
        Scanner input = new Scanner(System.in);
        String chiPhiThue = input.nextLine();
        boolean check = chiPhiThue.matches("^[+]?\\d+([.]\\d+)?$");
        if (check) {
            return chiPhiThue;
        } else {
            System.out.println("Rent must be a positive number !!!");
            return writeChiPhiThue();
        }
    }

    public static String writeSoNguoi() {
        System.out.println("Enter So Nguoi Toi Da: ");
        Scanner input = new Scanner(System.in);
        String soNguoi = input.nextLine();
        boolean check = soNguoi.matches("^(([01]?[1-9])|(10|20))$");
        if (check) {
            return soNguoi;
        } else {
            System.out.println("The maximum amount must be >0 and less than <20 !!!");
            return writeSoNguoi();
        }
    }

    public static String writeKieuThue() {
        System.out.println("Enter Kieu Thue: ");
        Scanner input = new Scanner(System.in);
        String kieuThue = input.nextLine();
        boolean check = kieuThue.matches("\\A[A-Z][a-z ]*");
        if (check) {
            return kieuThue;
        } else {
            System.out.println("The first character must be capitalized and no digits are allowed !!!");
            return writeKieuThue();
        }
    }

    public static String writeTieuChuan() {
        System.out.println("Enter Tieu Chuan: ");
        Scanner input = new Scanner(System.in);
        String tieuChuan = input.nextLine();
        boolean check = tieuChuan.matches("\\A[A-Z][a-z ]*");
        if (check) {
            return tieuChuan;
        } else {
            System.out.println("The first character must be capitalized and no digits are allowed !!!");
            return writeTieuChuan();
        }
    }

    public static String writeTienNghiKhac() {
        System.out.println("Enter Tien Nghi Khac: ");
        Scanner input = new Scanner(System.in);
        String tienNghiKhac = input.nextLine();
        boolean check = tienNghiKhac.matches("\\A[A-Z][a-z ]*");
        if (check) {
            return tienNghiKhac;
        } else {
            System.out.println("The first character must be capitalized and no digits are allowed !!!");
            return writeTienNghiKhac();
        }
    }

    public static int writeDienTichHo() {
        System.out.println("Enter Dien Tich Ho Boi: ");
        Scanner input = new Scanner(System.in);
        int dienTichHo = input.nextInt();
        String dienTichHo_str = "" + dienTichHo;
        boolean check = dienTichHo_str.matches("[3-9][0-9]|[0-9]{3,}");
        if (check) {
            return dienTichHo;
        } else {
            System.out.println("The usable pool area must be a real number greater than 30m2 !!!");
            return writeDienTichHo();
        }
    }

    public static int writeSoTang() {
        System.out.println("Enter So Tang: ");
        Scanner input = new Scanner(System.in);
        int soTang = input.nextInt();
        String soTang_str = "" + soTang;
        boolean check = soTang_str.matches("^[+]?\\d+([.]\\d+)?$");
        if (check) {
            return soTang;
        } else {
            System.out.println("The number of floors must be a positive integer !!!");
            return writeSoTang();
        }
    }

    public static String writeDvFree() {
        System.out.println("Enter Dich Vu Mien Phi: ");
        Scanner input = new Scanner(System.in);
        String dvFree = input.nextLine();
        boolean check = dvFree.matches("massage|karaoke|food|drink|car");
        if (check) {
            return dvFree;
        } else {
            System.out.println("Accompanying services must be of value: massage, karaoke, food, drink, car !!!");
            return writeDvFree();
        }
    }
}
