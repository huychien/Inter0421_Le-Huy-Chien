package Model.Repository;

import Model.Bean.Customer;

import java.util.ArrayList;

public interface CustomerRepository {
    ArrayList<Customer> searchCustomer(String name);
    ArrayList<Customer> findAll();
    void deleteCustomer(int id);
    void updateCustomer(Customer customer);
    void addCustomer(Customer customer);
}
