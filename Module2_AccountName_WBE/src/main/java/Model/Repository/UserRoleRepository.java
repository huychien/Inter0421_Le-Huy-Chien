package Model.Repository;

import Connection.ConnectionUtils;
import Model.Bean.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRoleRepository {

    public static boolean addUserRole(String username, int role_id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO User_Role VALUE (?, ?) ");
            ps.setInt(1, role_id);
            ps.setString(2,username);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static Connection getRootConnect() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/Furama";
        String userName = "root";
        String password = "Mung5@thang10";
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        return connection;
    }

    public static Boolean checkLogin(String username, String password, HttpServletRequest request) {
        try {
            Connection connection = getRootConnect();
            HttpSession session = request.getSession();

            PreparedStatement ps = connection.prepareStatement(" SELECT * FROM Furama.User u join NhanVien nv on u.username = nv.username " +
                    " join User_Role ur on u.username = ur.username " +
                    " join Role r on r.role_id = ur.role_id " +
                    " WHERE u.username = ? and u.password = ? ");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int employee_id = result.getInt("IdNhanVien");
                String employee_name = result.getString("HoTen");
                Date employee_birthday = result.getDate("NgaySinh");
                String employee_id_card = result.getString("SoCMTND");
                String employee_phone = result.getString("SDT");
                String employee_email = result.getString("Email");
                String employee_address = result.getString("DiaChi");
                double employee_salary = result.getDouble("Luong");

                User user = new User(username);
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
                        employee_email, employee_address, null, null, null, user);

                session.setAttribute("current_user",employee.getEmployee_name());
                session.setAttribute("role", result.getString("role_name"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
