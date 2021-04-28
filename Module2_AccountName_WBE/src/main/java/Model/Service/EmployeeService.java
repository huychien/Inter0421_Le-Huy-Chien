package Model.Service;

import Model.Bean.*;
import Model.Repository.EmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionUtils;

public class EmployeeService implements EmployeeRepository {
    @Override
    public ArrayList<Employee> searchEmployee(String name) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.NhanVien WHERE Name = ?");
            ps.setString(1, name);
            return getEmployees(ps);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<Employee> findAll() {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Furama.NhanVien");
            return getEmployees(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private ArrayList<Employee> getEmployees(PreparedStatement ps) throws SQLException {
        ResultSet result = ps.executeQuery();
        ArrayList<Employee> list = new ArrayList<>();

        while (result.next()) {
            int employee_id = result.getInt("IdNhanVien");
            String employee_name = result.getString("HoTen");
            Date employee_birthday = result.getDate("NgaySinh");
            String employee_id_card = result.getString("SoCMTND");
            String employee_phone = result.getString("SDT");
            String employee_email = result.getString("Email");
            String employee_address = result.getString("DiaChi");
            double employee_salary = result.getDouble("Luong");
            int position_id = result.getInt("IdViTri");
            int education_degree_id = result.getInt("IdTrinhDo");
            int division_id = result.getInt("IdBoPhan");
            String username = result.getString("UserName");

            Position position = new Position();
            Education_degree education_degree = new Education_degree();
            Division division = new Division();
            User user = new User();

            Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
                    employee_email, employee_address, position, education_degree, division, user);
            list.add(employee);
        }
        result.close();
        return list;
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement("Delete FROM Furama.NhanVien WHERE IdNhanVien = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement(" UPDATE Furama.NhanVien " +
                    " Set HoTen = ?, NgaySinh = ?, SoCMTND = ?, Email = ?, " +
                    " DiaChi = ?, SDT = ?, IdViTri = ?, IdTrinhDo = ?, IdBoPhan = ?, Luong = ?, UserName = ? " +
                    " WHERE IdNhanVien = ? ");
            ps.setInt(12, employee.getEmployee_id());
            setData(employee, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            Connection connection = ConnectionUtils.getMyConnect();

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO KhachHang(HoTen, NgaySinh, SoCMTND, Email, " +
                                                                    " DiaChi, SDT, IdViTri, IdTrinhDo, IdBoPhan, Luong, UserName ) " +
                                                                    " VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
            setData(employee, ps);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setData(Employee employee, PreparedStatement ps) throws SQLException {
        ps.setString(1, employee.getEmployee_name());
        ps.setDate(2, employee.getEmployee_birthday());
        ps.setInt(8, employee.getEducation_degree().getEducation_id());
        ps.setInt(9, employee.getDivision().getDivision_id());
        ps.setInt(7, employee.getPosition().getPosition_id());
        ps.setString(3, employee.getEmployee_id_card());
        ps.setString(5, employee.getEmployee_address());
        ps.setString(4, employee.getEmployee_email());
        ps.setString(6, employee.getEmployee_phone());
        ps.setString(11, employee.getUser().getUsername());
        ps.setDouble(10, employee.getEmployee_salary());

        ResultSet result = ps.executeQuery();
        result.close();
    }
}
