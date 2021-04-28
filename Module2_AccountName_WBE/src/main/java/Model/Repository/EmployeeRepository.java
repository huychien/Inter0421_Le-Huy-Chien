package Model.Repository;

import Model.Bean.Customer;
import Model.Bean.Employee;

import java.util.ArrayList;

public interface EmployeeRepository {
    ArrayList<Employee> searchEmployee(String name);
    ArrayList<Employee> findAll();
    void deleteEmployee(int id);
    void updateEmployee(Employee employee);
    void addEmployee(Employee employee);
}
