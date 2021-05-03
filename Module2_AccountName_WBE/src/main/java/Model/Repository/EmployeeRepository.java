package Model.Repository;

import Connection.ConnectionUtils;
import Model.Bean.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {

    public static Employee getEmployee(int employee_id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.NhanVien nv join ViTri vt on vt.IdViTri = nv.IdViTri " +
                    " join BoPhan bp on bp.IdBoPhan = nv.IdBoPhan " +
                    " join TrinhDo td on td.IdTrinhDo = nv.IdTrinhDo " +
                    " WHERE IdNhanVien = ?");
            ps.setInt(1, employee_id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                return getData(employee_id, result);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static Employee getData(int employee_id, ResultSet result) throws SQLException {
        String employee_name = result.getString("HoTen");
        Date employee_birthday = result.getDate("NgaySinh");
        String employee_id_card = result.getString("SoCMTND");
        String employee_phone = result.getString("SDT");
        String employee_email = result.getString("Email");
        String employee_address = result.getString("DiaChi");
        double employee_salary = result.getDouble("Luong");
        int position_id = result.getInt("IdViTri");
        int education_id = result.getInt("IdTrinhDo");
        int division_id = result.getInt("IdBoPhan");
        String education_name = result.getString("TrinhDo");
        String division_name = result.getString("TenBoPhan");
        String position_name = result.getString("TenViTri");
        String username = result.getString("username");

        Position position = new Position(position_id, position_name);
        Education_degree education_degree = new Education_degree(education_id, education_name);
        Division division = new Division(division_id, division_name);
        User user = new User(username);

        Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
                employee_email, employee_address, position, education_degree, division, user);
        return employee;
    }

    public static ArrayList<Employee> searchEmployee(String name, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.NhanVien nv join ViTri vt on vt.IdViTri = nv.IdViTri " +
                    " join BoPhan bp on bp.IdBoPhan = nv.IdBoPhan " +
                    " join TrinhDo td on td.IdTrinhDo = nv.IdTrinhDo " +
                    " WHERE HoTen = ?");
            ps.setString(1, name);
            return getEmployees(ps);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ArrayList<Employee> findAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.NhanVien nv join ViTri vt on vt.IdViTri = nv.IdViTri " +
                    " join BoPhan bp on bp.IdBoPhan = nv.IdBoPhan " +
                    " join TrinhDo td on td.IdTrinhDo = nv.IdTrinhDo ");
            return getEmployees(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static ArrayList<Employee> getEmployees(PreparedStatement ps) throws SQLException {
        ResultSet result = ps.executeQuery();
        ArrayList<Employee> list = new ArrayList<>();

        while (result.next()) {
            int employee_id = result.getInt("IdNhanVien");
            list.add(getData(employee_id, result));
        }
        result.close();
        return list;
    }

    public static void deleteEmployee(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("Delete FROM Furama.NhanVien WHERE IdNhanVien = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateEmployee(Employee employee, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" UPDATE Furama.NhanVien " +
                    " Set HoTen = ?, NgaySinh = ?, SoCMTND = ?, Email = ?, " +
                    " DiaChi = ?, SDT = ?, IdViTri = ?, IdTrinhDo = ?, IdBoPhan = ?, Luong = ? " +
                    " WHERE IdNhanVien = ? ");
            ps.setInt(11, employee.getEmployee_id());
            setData(employee, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Boolean addEmployee(Employee employee, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO KhachHang(HoTen, NgaySinh, SoCMTND, Email, " +
                                                                    " DiaChi, SDT, IdViTri, IdTrinhDo, IdBoPhan, Luong ) " +
                                                                    " VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
            setData(employee, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static void setData(Employee employee, PreparedStatement ps) throws SQLException {
        ps.setString(1, employee.getEmployee_name());
        ps.setDate(2, employee.getEmployee_birthday());
        ps.setInt(8, employee.getEducation_degree().getEducation_id());
        ps.setInt(9, employee.getDivision().getDivision_id());
        ps.setInt(7, employee.getPosition().getPosition_id());
        ps.setString(3, employee.getEmployee_id_card());
        ps.setString(5, employee.getEmployee_address());
        ps.setString(4, employee.getEmployee_email());
        ps.setString(6, employee.getEmployee_phone());
        ps.setDouble(10, employee.getEmployee_salary());
        ps.executeUpdate();
    }
}
