package Model.Service;

import Model.Bean.*;
import Model.Repository.EmployeeRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class EmployeeService {

    public static Employee getEmployee(int employee_id, HttpServletRequest request) {
        return EmployeeRepository.getEmployee(employee_id, request);
    }

    public static ArrayList<Employee> searchEmployee(String name, HttpServletRequest request) {
        return EmployeeRepository.searchEmployee(name, request);
    }

    public static ArrayList<Employee> findAll(HttpServletRequest request) {
        return EmployeeRepository.findAll(request);
    }

    public static void deleteEmployee(int id, HttpServletRequest request) {
        EmployeeRepository.deleteEmployee(id, request);
    }

    public static void updateEmployee(Employee employee, HttpServletRequest request) {
        EmployeeRepository.updateEmployee(employee, request);
    }

    public static Boolean addEmployee(Employee employee, HttpServletRequest request) {
        return EmployeeRepository.addEmployee(employee, request);
    }
}
