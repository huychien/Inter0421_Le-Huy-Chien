package Model.Service;

import Model.Bean.Customer;

import java.util.ArrayList;
import Model.Repository.CustomerRepository;

import javax.servlet.http.HttpServletRequest;

public class CustomerService {

    public static Customer getCustomer(int customer_id, HttpServletRequest request) {
        return CustomerRepository.getCustomer(customer_id, request);
    }

    public static ArrayList<Customer> searchCustomer(String name, HttpServletRequest request) {
        return CustomerRepository.searchCustomer(name, request);
    }

    public static ArrayList<Customer> findAll(HttpServletRequest request) {
        return CustomerRepository.findAll(request);
    }

    public static void deleteCustomer(int id, HttpServletRequest request) {
        CustomerRepository.deleteCustomer(id, request);
    }

    public static Boolean updateCustomer(Customer customer, HttpServletRequest request) {
        // em không validate Mã Khách vì phải sửa nhiều hihi
        boolean checkPhone = customer.getCustomer_phone().matches("090[0-9]{7}|091[0-9]{7}|\\(84\\)\\+90[0-9]{7}|\\(84\\)\\+91[0-9]{7}");
        boolean checkSoSMND = customer.getCustomer_id_card().matches("^\\d{9}$|^\\d{12}$");
        boolean checkEmail = customer.getCustomer_email().matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$");
        if (checkPhone && checkSoSMND && checkEmail) {
            return CustomerRepository.updateCustomer(customer, request);
        }
        return false;
    }

    public static boolean addCustomer(Customer customer, HttpServletRequest request) {
        // em không validate Mã Khách vì phải sửa nhiều hihi
        boolean checkPhone = customer.getCustomer_phone().matches("090[0-9]{7}|091[0-9]{7}|\\(84\\)\\+90[0-9]{7}|\\(84\\)\\+91[0-9]{7}");
        boolean checkSoSMND = customer.getCustomer_id_card().matches("^\\d{9}$|^\\d{12}$");
        boolean checkEmail = customer.getCustomer_email().matches("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$");
        if (checkPhone && checkSoSMND && checkEmail) {
            return CustomerRepository.addCustomer(customer, request);
        }
        return false;
    }
}
