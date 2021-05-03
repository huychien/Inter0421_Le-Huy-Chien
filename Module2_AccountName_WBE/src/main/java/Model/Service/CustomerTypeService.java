package Model.Service;

import Model.Bean.Customer_type;
import Model.Repository.CustomerTypeRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class CustomerTypeService {

    public static ArrayList<Customer_type> findAllCustomerType(HttpServletRequest request) {
        return CustomerTypeRepository.findAllCustomerType(request);
    }

    public static Customer_type getCustomerType(int id, HttpServletRequest request) {
        return CustomerTypeRepository.getCustomerType(id, request);
    }
}
