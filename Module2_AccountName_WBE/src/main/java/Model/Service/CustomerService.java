package Model.Service;

import Model.Bean.Customer;
import Model.Bean.Customer_type;
import Model.Repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionUtils;

public class CustomerService implements CustomerRepository {

    @Override
    public ArrayList<Customer> searchCustomer(String name) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.KhachHang WHERE Name = ?");
            ps.setString(1, name);
            return getCustomers(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Customer> findAll() {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.KhachHang");
            return getCustomers(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private ArrayList<Customer> getCustomers(PreparedStatement ps) throws SQLException {
        ResultSet result = ps.executeQuery();
        ArrayList<Customer> list = new ArrayList<>();

        while (result.next()) {
            int customer_id = result.getInt("IdKhachHang");
            int customer_type = result.getInt("IdLoaiKhach");
            String customer_name = result.getString("HoTen");
            Date customer_birthday = result.getDate("NgaySinh");
            int customer_gender = result.getInt("GioiTinh");
            String customer_id_card = result.getString("SoCMTND");
            String customer_phone = result.getString("SDT");
            String customer_email = result.getString("Email");
            String customer_address = result.getString("DiaChi");

            Customer_type customerType = new Customer_type();
            Customer customer = new Customer(customer_id, customerType, customer_name, customer_birthday,
                    customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            list.add(customer);
        }
        result.close();
        return list;
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement("Delete FROM Furama.KhachHang WHERE IdKhachHang = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement(" UPDATE Furama.KhachHang " +
                                                                    " Set IdLoaiKhach = ?, HoTen = ?, NgaySinh = ?, SoCMTND = ?, Email = ?, " +
                                                                    " DiaChi = ?, SDT = ?, GioiTInh = ? " +
                                                                    " WHERE IdKhachHang = ? ");
            ps.setInt(9, customer.getCustomer_id());
            setData(customer, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO KhachHang(IdLoaiKhach, HoTen, NgaySinh, SoCMTND, Email, DiaChi, SDT, GioiTInh) " +
                    " VALUE (?, ?, ?, ?, ?, ?, ?, ?); ");

            setData(customer, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setData(Customer customer, PreparedStatement ps) throws SQLException {
        ps.setInt(1, customer.getCustomer_type().getCustomer_type_id());
        ps.setString(2, customer.getCustomer_name());
        ps.setDate(3, (java.sql.Date) customer.getCustomer_birthday());
        ps.setString(4, customer.getCustomer_id_card());
        ps.setString(5, customer.getCustomer_email());
        ps.setString(6, customer.getCustomer_address());
        ps.setString(7, customer.getCustomer_phone());
        ps.setInt(8, customer.getCustomer_gender());
        ResultSet result = ps.executeQuery();
        result.close();
    }
}
