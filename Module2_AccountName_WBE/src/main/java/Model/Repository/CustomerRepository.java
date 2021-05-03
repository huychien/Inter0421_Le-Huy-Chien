package Model.Repository;

import Connection.ConnectionUtils;
import Model.Bean.Customer;
import Model.Bean.Customer_type;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerRepository {

    public static Customer getCustomer(int customer_id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.KhachHang kh join LoaiKhach lkh on lkh.IdLoaiKhach = kh.IdLoaiKhach" +
                                                                    " WHERE IdKhachHang = ?");
            ps.setInt(1, customer_id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                return getData(customer_id, result);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static Customer getData(int customer_id, ResultSet result) throws SQLException {
        int customer_type_id = result.getInt("IdLoaiKhach");
        String customer_name = result.getString("HoTen");
        Date customer_birthday = result.getDate("NgaySinh");
        int customer_gender = result.getInt("GioiTinh");
        String customer_id_card = result.getString("SoCMTND");
        String customer_phone = result.getString("SDT");
        String customer_email = result.getString("Email");
        String customer_address = result.getString("DiaChi");
        String customer_type_name = result.getString("TenLoaiKhach");

        Customer_type customerType = new Customer_type(customer_type_id, customer_type_name);
        Customer customer = new Customer(customer_id, customerType, customer_name, customer_birthday,
                customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
        return customer;
    }

    public static ArrayList<Customer> searchCustomer(String name, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.KhachHang kh join LoaiKhach lkh on lkh.IdLoaiKhach = kh.IdLoaiKhach" +
                                                                    " WHERE HoTen = ?");
            ps.setString(1, name);
            return getCustomers(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ArrayList<Customer> findAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.KhachHang kh join LoaiKhach lkh on lkh.IdLoaiKhach = kh.IdLoaiKhach");
            return getCustomers(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static ArrayList<Customer> getCustomers(PreparedStatement ps) throws SQLException {
        ResultSet result = ps.executeQuery();
        ArrayList<Customer> list = new ArrayList<>();

        while (result.next()) {
            int customer_id = result.getInt("IdKhachHang");
            list.add(getData(customer_id, result));
        }
        result.close();
        return list;
    }

    public static void deleteCustomer(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("Delete FROM Furama.KhachHang WHERE IdKhachHang = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Boolean updateCustomer(Customer customer, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" UPDATE Furama.KhachHang " +
                                                                    " Set IdLoaiKhach = ?, HoTen = ?, NgaySinh = ?, SoCMTND = ?, Email = ?, " +
                                                                    " DiaChi = ?, SDT = ?, GioiTInh = ? " +
                                                                    " WHERE IdKhachHang = ? ");
            ps.setInt(9, customer.getCustomer_id());
            setData(customer, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean addCustomer(Customer customer, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO KhachHang(IdLoaiKhach, HoTen, NgaySinh, SoCMTND, Email, DiaChi, SDT, GioiTInh) " +
                    " VALUE (?, ?, ?, ?, ?, ?, ?, ?); ");

            setData(customer, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static void setData(Customer customer, PreparedStatement ps) throws SQLException {
        ps.setInt(1, customer.getCustomer_type().getCustomer_type_id());
        ps.setString(2, customer.getCustomer_name());
        ps.setDate(3, customer.getCustomer_birthday());
        ps.setString(4, customer.getCustomer_id_card());
        ps.setString(5, customer.getCustomer_email());
        ps.setString(6, customer.getCustomer_address());
        ps.setString(7, customer.getCustomer_phone());
        ps.setInt(8, customer.getCustomer_gender());
        ps.executeUpdate();
    }
}
