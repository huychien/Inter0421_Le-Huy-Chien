package Model.Repository;

import Model.Bean.Customer_type;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionUtils;

import javax.servlet.http.HttpServletRequest;

public class CustomerTypeRepository {

    public static ArrayList<Customer_type> findAllCustomerType(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM LoaiKhach");
            ArrayList<Customer_type> list = new ArrayList<>();

            while (result.next()) {
                int customer_type_id = result.getInt("IdLoaiKhach");
                String customer_type_name = result.getString("TenLoaiKhach");

                Customer_type customerType = new Customer_type(customer_type_id, customer_type_name);
                list.add(customerType);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Customer_type getCustomerType(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM LoaiKhach Where IdLoaiKhach = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            Customer_type customerType = new Customer_type();
            while (result.next()) {
                int customer_type_id = result.getInt("IdLoaiKhach");
                String customer_type_name = result.getString("TenLoaiKhach");
                customerType = new Customer_type(customer_type_id, customer_type_name);
            }
            result.close();
            return customerType;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
