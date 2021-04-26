package Controllers;

import Commons.AddCustomer;
import Commons.AddMovie4D;
import Commons.AddServices;
import Libs.EmailException;
import Models.*;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class MainController {

    public static void displayMainMenu() {
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Show Booking Movie");
        System.out.println("8. Find Employee");
        System.out.println("9. Exit");

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
                ShowInformationOfEmployee();
                yesNo();
                break;
            case  7:
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/BookingMovie.csv", id, false);
                yesNo();
                break;
            case  8:
                findEmployee();
                yesNo();
                break;
            case  9:
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
        System.out.println("4. Add New Movie");
        System.out.println("5. Back to menu");
        System.out.println("6. Exit");

        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        switch ( id ) {
            case  1:
                writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Villa.csv", id);
                yesNo();
                break;
            case  2:
                writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/House.csv", id);
                yesNo();
                break;
            case  3:
                writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Room.csv", id);
                yesNo();
                break;
            case  4:
                writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Movie4D.csv", id);
                yesNo();
                break;
            case  5:
                displayMainMenu();
                break;
            case  6:
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
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Villa.csv", id, false);
                yesNo();
                break;
            case  2:
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/House.csv", id, false);
                yesNo();
                break;
            case  3:
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Room.csv", id, false);
                yesNo();
                break;
            case  4:
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Villa.csv", 1, true);
                yesNo();
                break;
            case  5:
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/House.csv", 2, true);
                yesNo();
                break;
            case  6:
                readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Room.csv", 3, true);
                yesNo();
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
        writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Customer.csv", 5);
        yesNo();
    }

    public static void showInformationCustomers() {
        readFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Customer.csv", 4, false);
        yesNo();
    }

    public static void addNewBooking() {
        try {
            FileInputStream fis = new FileInputStream("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Customer.csv");
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
                    System.out.println("4. Booking Movie Ticket 4D");

                    int id = input.nextInt();
                    switch ( id ) {
                        case 1:
                            Villa villa = (Villa) showServicesToBooking("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Villa.csv", id);
                            listCustomer.get(i).setServices(villa);
                            writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Booking.csv", listCustomer.get(i));
                            yesNo();
                            break;
                        case 2:
                            House house = (House) showServicesToBooking("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/House.csv", id);
                            listCustomer.get(i).setServices(house);
                            writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Booking.csv", listCustomer.get(i));
                            yesNo();
                            break;
                        case 3:
                            Room room = (Room) showServicesToBooking("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Room.csv", id);
                            listCustomer.get(i).setServices(room);
                            writeFile("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Booking.csv", listCustomer.get(i));
                            yesNo();
                            break;
                        case 4:
                            Movie4D movie4D = (Movie4D) showServicesToBooking("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Movie4D.csv", id);;
                            listCustomer.get(i).setMovie4D(movie4D);
                            writeBookingMovie("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/BookingMovie.csv", listCustomer.get(i));
                            yesNo();
                            break;
                        default:
                            System.out.println("Please enter again !!!");
                            addNewBooking();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Failed !!!");
            yesNo();
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
                    System.out.print(id + " | ");
                    villa.showInfor();
                    id++;
                }
                for (Villa villa: list) {
                    if (enterIdService(list)) {
                        return villa;
                    }
                }
            }
            if (idService == 2) {
                ArrayList<House> list = (ArrayList<House>) ois.readObject();
                for (House house: list) {
                    System.out.print(id + " | ");
                    house.showInfor();
                    id++;
                }
                for (House house: list) {
                    if (enterIdService(list)) {
                        return house;
                    }
                }
            }
            if (idService == 3) {
                ArrayList<Room> list = (ArrayList<Room>) ois.readObject();
                for (Room room: list) {
                    System.out.print(id + " | ");
                    room.showInfor();
                    id++;
                }
                for (Room room: list) {
                    if (enterIdService(list)) {
                        return room;
                    }
                }
            }
            if (idService == 4) {
                ArrayList<Movie4D> list = (ArrayList<Movie4D>) ois.readObject();
                for (Movie4D movie4D: list) {
                    System.out.print(id + " | ");
                    System.out.println(movie4D.getNameMovie());
                    id++;
                }
                for (Movie4D movie4D: list) {
                    if (enterIdService(list)) {
                        return movie4D;
                    }
                }
            }
            fis.close();
            ois.close();
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean enterIdService(ArrayList list) {
        System.out.println("Enter the id you want to book:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (id - 1 == i) {
                return true;
            }
        }
        return false;
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
                if (id == 5) {
                    Customer customer = new Customer(AddCustomer.writeCustomerName(), AddCustomer.writeBirthday(), AddCustomer.writeGender(), AddCustomer.writeSoCMND(),
                            AddCustomer.writePhone(), AddCustomer.writeEmail(), AddCustomer.writeLoaiKhach(), AddCustomer.writeAddress());
                    list.add(customer);
                }
                if (id == 4) {
                    Movie4D movie4D = new Movie4D(AddMovie4D.writeMovieName());
                    list.add(movie4D);
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

    public static void writeBookingMovie(String path, Customer customer) {
        try {
            Queue<Customer> list = new LinkedList<>();
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);

                list = (Queue<Customer>) ois.readObject();
                fis.close();
                ois.close();
            } catch (Exception e) {

            } finally {
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                list.offer(customer);
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

    public static void readFile(String path, int id, boolean sort) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            TreeSet<String> treeSet = new TreeSet();

            if (id == 1) {
                ArrayList<Villa> list = (ArrayList<Villa>) ois.readObject();
                for (Villa villa: list) {
                    if (sort) {
                        treeSet.add(villa.getTenDichVu());
                    } else {
                        villa.showInfor();
                    }
                }
            }
            if (id == 2) {
                ArrayList<House> list = (ArrayList<House>) ois.readObject();
                for (House house: list) {
                    if (sort) {
                        treeSet.add(house.getTenDichVu());
                    } else {
                        house.showInfor();
                    }
                }
            }
            if (id == 3) {
                ArrayList<Room> list = (ArrayList<Room>) ois.readObject();
                for (Room room: list) {
                    if (sort) {
                        treeSet.add(room.getTenDichVu());
                    } else {
                        room.showInfor();
                    }
                }
            }
            if (id == 4) {
                ArrayList<Customer> list = (ArrayList<Customer>) ois.readObject();
                Customer.showInformationCustomers(list);
            }
            if (id == 7) {
                Queue<Customer> listBookingMovie = (Queue<Customer>) ois.readObject();
                System.out.println("STT | Customer name | Movie name");
                int count = 1;
                for (Customer customer: listBookingMovie) {
                    System.out.print(count + "\t| ");
                    customer.showBookingMovie();
                    count++;
                }
            }
            if (sort) {
                System.out.println("All Name Not Duplicate: " + treeSet);
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

    public static void addEmployeeIntoFile() {
        try {
            ArrayList<Object> list = new ArrayList<>();
            try {
                FileInputStream fis = new FileInputStream("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Employee.csv");
                ObjectInputStream ois = new ObjectInputStream(fis);

                list = (ArrayList<Object>) ois.readObject();
                fis.close();
                ois.close();
            } catch (Exception e) {

            } finally {
                FileOutputStream fos = new FileOutputStream("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Employee.csv");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                Employee employee;
                for (int i = 0; i < 10; i++) {
                    employee = new Employee("Nguyen Van A" + i, 20 + i, "DaNang");
                    list.add(employee);
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

    public static void ShowInformationOfEmployee() {
        ArrayList<Employee> list = readFileEmployee();
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();

        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i));
        }
        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static ArrayList<Employee> readFileEmployee() {
        try {
            FileInputStream fis = new FileInputStream("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Employee.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();
            fis.close();
            ois.close();
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static Stack<Employee> filingCabinetsEmployee() {
        try {
            FileInputStream fis = new FileInputStream("/home/huythang/Inter0421_Le-Huy-Chien/_02_java/FuramaResort/src/Data/Employee.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Employee> list = (ArrayList<Employee>) ois.readObject();
            Stack<Employee> stack = new Stack<>();

            for (Employee employee: list) {
                stack.add(employee);
            }
            fis.close();
            ois.close();
            return stack;
        } catch (Exception e) {
            e.printStackTrace();
            return new Stack<>();
        }
    }

    public static void findEmployee() {
        Stack<Employee> myStack = filingCabinetsEmployee();
        System.out.print("Enter the employee's name to search, if it cannot be found, it will not be displayed: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        while (!myStack.isEmpty()) {
            if (myStack.peek().getName().equalsIgnoreCase(name)) {
                System.out.println(myStack.peek());
            }
            myStack.pop();
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