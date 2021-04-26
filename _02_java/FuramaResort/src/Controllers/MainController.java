package Controllers;

import Commons.AddCustomer;
import Commons.AddServices;
import Libs.EmailException;
import Models.*;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {

    public static void displayMainMenu() {
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Exit");

        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        switch ( id ) {
            case  1:
                addNewServices();
                break;
            case  2:
                showServices();
                break;
            case  3:
                addNewCustomer();
                break;
            case  4:
                showInformationCustomers();
                break;
            case  5:
                addNewBooking();
                break;
            case  6:
                // Làm gì đó tại đây ...
                break;
            case  7:
                break;
            default:
                System.out.println("Please enter again !!!");
                displayMainMenu();
        }
    }

    public static void addNewServices() {

        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("5. Exit");

        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        switch ( id ) {
            case  1:
                writeFile("/home/huythang/Intellij/FuramaResort/src/Data/Villa.csv", id);
                yesNo();
                break;
            case  2:
                writeFile("/home/huythang/Intellij/FuramaResort/src/Data/House.csv", id);
                yesNo();
                break;
            case  3:
                writeFile("/home/huythang/Intellij/FuramaResort/src/Data/Room.csv", id);
                yesNo();
                break;
            case  4:
                displayMainMenu();
                break;
            case  5:
                break;
            default:
                System.out.println("Please enter again !!!");
                addNewServices();
        }
    }

    public static void showServices() {
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Room Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");

        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        switch ( id ) {
            case  1:
                readFile("/home/huythang/Intellij/FuramaResort/src/Data/Villa.csv", id);
                yesNo();
                break;
            case  2:
                readFile("/home/huythang/Intellij/FuramaResort/src/Data/House.csv", id);
                yesNo();
                break;
            case  3:
                readFile("/home/huythang/Intellij/FuramaResort/src/Data/Room.csv", id);
                yesNo();
                break;
            case  4:
                // Làm gì đó tại đây ...
                break;
            case  5:
                // Làm gì đó tại đây ...
                break;
            case  6:
                // Làm gì đó tại đây ...
                break;
            case  7:
                displayMainMenu();
                break;
            case  8:
                break;
            default:
                System.out.println("Please enter again !!!");
                showServices();
        }
    }

    public static void addNewCustomer() {
        writeFile("/home/huythang/Intellij/FuramaResort/src/Data/Customer.csv", 4);
        yesNo();
    }

    public static void showInformationCustomers() {
        readFile("/home/huythang/Intellij/FuramaResort/src/Data/Customer.csv", 4);
        yesNo();
    }

    public static void addNewBooking() {
        try {
            FileInputStream fis = new FileInputStream("/home/huythang/Intellij/FuramaResort/src/Data/Customer.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Customer> listCustomer = (ArrayList<Customer>) ois.readObject();
            Customer.showInformationCustomers(listCustomer);
            fis.close();
            ois.close();

            Scanner input = new Scanner(System.in);
            int idCustomer = input.nextInt();

            for (int i = 0; i < listCustomer.size(); i++) {
                if (idCustomer - 1 == i) {
                    System.out.println("1. Booking Villa");
                    System.out.println("2. Booking House");
                    System.out.println("3. Booking Room");

                    int id = input.nextInt();
                    switch ( id ) {
                        case 1:
                            Villa villa = (Villa) showServicesToBooking("/home/huythang/Intellij/FuramaResort/src/Data/Villa.csv", id);
                            listCustomer.get(i).setServices(villa);
                            writeFile("/home/huythang/Intellij/FuramaResort/src/Data/Booking", listCustomer.get(i));
                            yesNo();
                            break;
                        case 2:
                            House house = (House) showServicesToBooking("/home/huythang/Intellij/FuramaResort/src/Data/House.csv", id);
                            listCustomer.get(i).setServices(house);
                            writeFile("/home/huythang/Intellij/FuramaResort/src/Data/Booking", listCustomer.get(i));
                            yesNo();
                            break;
                        case 3:
                            Room room = (Room) showServicesToBooking("/home/huythang/Intellij/FuramaResort/src/Data/Room.csv", id);
                            listCustomer.get(i).setServices(room);
                            writeFile("/home/huythang/Intellij/FuramaResort/src/Data/Booking", listCustomer.get(i));
                            yesNo();
                            break;
                        default:
                            System.out.println("Please enter again !!!");
                            addNewBooking();
                    }
                }
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please enter again !!!");
            addNewBooking();
        }
    }

    public static Object showServicesToBooking(String path, int idService) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int id = 1;
            if (idService == 1) {
                ArrayList<Villa> list = (ArrayList<Villa>) ois.readObject();
                for (Villa villa: list) {
                    System.out.println(id + " | ");
                    villa.showInfor();
                    id++;
                    return enterIdService((ArrayList<Object>) ois.readObject());
                }
            }
            if (idService == 2) {
                ArrayList<House> list = (ArrayList<House>) ois.readObject();
                for (House house: list) {
                    System.out.println(id + " | ");
                    house.showInfor();
                    id++;
                    return enterIdService((ArrayList<Object>) ois.readObject());
                }
            }
            if (idService == 3) {
                ArrayList<Room> list = (ArrayList<Room>) ois.readObject();
                for (Room room: list) {
                    System.out.println(id + " | ");
                    room.showInfor();
                    id++;
                    return enterIdService((ArrayList<Object>) ois.readObject());
                }
            }
            fis.close();
            ois.close();
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static Object enterIdService(ArrayList<Object> list) {
        System.out.println("Enter the id you want to book:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id - 1 == i) {
                return list.get(i);
            }
        }
        return 0;
    }

    public static void writeFile(String path, int id) {
        try {
            ArrayList<Object> list = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);

                list = (ArrayList<Object>) ois.readObject();
                fis.close();
                ois.close();
            } catch (Exception e) {

            } finally {
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                if (id == 1) {
                    Villa villa = new Villa(AddServices.writeId(), AddServices.writeTenDv(), AddServices.writeDienTich(), AddServices.writeChiPhiThue(),
                                    AddServices.writeSoNguoi(), AddServices.writeKieuThue(), AddServices.writeTieuChuan(), AddServices.writeTienNghiKhac(),
                                    AddServices.writeDienTichHo(), AddServices.writeSoTang());
                    list.add(villa);
                }
                if (id == 2) {
                    House house = new House(AddServices.writeId(), AddServices.writeTenDv(), AddServices.writeDienTich(), AddServices.writeChiPhiThue(),
                            AddServices.writeSoNguoi(), AddServices.writeKieuThue(), AddServices.writeTieuChuan(), AddServices.writeTienNghiKhac(), AddServices.writeSoTang());
                    list.add(house);
                }
                if (id == 3) {
                    Room room = new Room(AddServices.writeId(), AddServices.writeTenDv(), AddServices.writeDienTich(), AddServices.writeChiPhiThue(), AddServices.writeSoNguoi(),
                            AddServices.writeKieuThue(), AddServices.writeDvFree());
                    list.add(room);
                }
                if (id == 4) {
                    Customer customer = new Customer(AddCustomer.writeCustomerName(), AddCustomer.writeBirthday(), AddCustomer.writeGender(), AddCustomer.writeSoCMND(),
                            AddCustomer.writePhone(), AddCustomer.writeEmail(), AddCustomer.writeLoaiKhach(), AddCustomer.writeAddress());
                    list.add(customer);
                }

                oos.writeObject(list);
                fos.close();
                oos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String path, Customer customer) {
        try {
            ArrayList<Object> list = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);

                list = (ArrayList<Object>) ois.readObject();
                fis.close();
                ois.close();
            } catch (Exception e) {

            } finally {
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                list.add(customer);
                oos.writeObject(list);
                fos.close();
                oos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String path, int id) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            if (id == 1) {
                ArrayList<Villa> list = (ArrayList<Villa>) ois.readObject();
                for (Villa villa: list) {
                    villa.showInfor();
                }
            }
            if (id == 2) {
                ArrayList<House> list = (ArrayList<House>) ois.readObject();
                for (House house: list) {
                    house.showInfor();
                }
            }
            if (id == 3) {
                ArrayList<Room> list = (ArrayList<Room>) ois.readObject();
                for (Room room: list) {
                    room.showInfor();
                }
            }
            if (id == 4) {
                ArrayList<Customer> list = (ArrayList<Customer>) ois.readObject();
                Customer.showInformationCustomers(list);
            }
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void yesNo() {
        System.out.print("Continue? y/n: ");
        Scanner input = new Scanner(System.in);
        String yn = input.nextLine();

        if (yn.equalsIgnoreCase("y")) {
            displayMainMenu();
        }
    }
}