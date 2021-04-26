package Commons;

import Libs.*;
import Models.House;
import Models.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class AddCustomer {
    public static String writeCustomerName() {
        System.out.println("Enter customer name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        name = name.trim().replaceAll(" +", " ");
        try {
            int space = 0;
            for (int i = 0; i < name.length(); i++) {
                char ch= name.charAt(i);
                if(ch==' '){
                    space++;
                }
            }
            String[] wordList = null;
            for (int i = 0; i <= space; i++) {
                wordList = name.split(" ");
                if (wordList[i].matches("\\A[A-Z][A-Za-z ]*") == false) {
                    throw new NameException();
                }
            }
            for (int i = 0; i < wordList.length; i++) {
                for (int j = 1; j < wordList[i].length(); j++) {
                    char ch= wordList[i].charAt(j);
                    if (Character.isUpperCase(ch)) {
                        throw new NameException();
                    }
                }
            }
        } catch (NameException e) {
            System.out.println(e);
            writeCustomerName();
        }
        return name;
    }

    public static Date writeBirthday() {
        System.out.println("Enter birthday: ");
        Scanner input = new Scanner(System.in);
        String birthday_str = input.nextLine();
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date birthday = format.parse(birthday_str);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(birthday);
            int year = calendar.get(Calendar.YEAR);

            calendar.setTime(new Date());
            int yearOfNow = calendar.get(Calendar.YEAR);

            if (year <= 1900 || yearOfNow - year < 18) {
                throw new BirthdayException();
            }
            return birthday;
        } catch (BirthdayException | ParseException e) {
            System.out.println("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm và đúng định dạng dd/mm/yyyy");
            return writeBirthday();
        }
    }

    public static String writeGender() {
        System.out.println("Enter gender: ");
        Scanner input = new Scanner(System.in);
        String gender = input.nextLine();
        gender = gender.toUpperCase();
        try {
            if (!gender.matches("MALE|FEMALE|UNKNOW")) {
                throw new GenderException();
            }
        } catch (GenderException e) {
            System.out.println(e);
            writeGender();
        }
        return gender;
    }

    public static String writeSoCMND() {
        System.out.println("Enter so CMND: ");
        Scanner input = new Scanner(System.in);
        String soCMND = input.nextLine();
        try {
            if (!soCMND.matches("[0-9]{3} [0-9]{3} [0-9]{3}")) {
                throw new IdCardException();
            }
        } catch (IdCardException e) {
            System.out.println(e);
            writeSoCMND();
        }
        return soCMND;
    }

    public static String writePhone() {
        System.out.println("Enter phone: ");
        Scanner input = new Scanner(System.in);
        String phone = input.nextLine();
        return phone;
    }

    public static String writeEmail() {
        System.out.println("Enter email: ");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        try {
            if (!email.matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")) {
                throw new EmailException();
            }
        } catch (EmailException e) {
            System.out.println(e);
            writeEmail();
        }
        return email;
    }

    public static String writeLoaiKhach() {
        System.out.println("Enter loai khach: ");
        Scanner input = new Scanner(System.in);
        String loaiKhach = input.nextLine();
        return loaiKhach;
    }

    public static String writeAddress() {
        System.out.println("Enter address: ");
        Scanner input = new Scanner(System.in);
        String address = input.nextLine();
        return address;
    }

    public static Services writeServices() {
        Services services = new House();
        return services;
    }
}
