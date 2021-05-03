package Model.Service;

import Model.Bean.Service;
import Model.Repository.ServiceRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ServiceService {

    public static Service getService(int service_id, HttpServletRequest request) {
        return ServiceRepository.getService(service_id, request);
    }

    public static ArrayList<Service> findAll(HttpServletRequest request) {
        return ServiceRepository.findAll(request);
    }

    public static boolean addService(Service service, HttpServletRequest request) {
        if (service.getNumber_of_floors() > 0 && service.getService_area() > 0 && service.getService_cost() > 0
                && service.getPool_area() > 0 && service.getService_max_people() > 0) {
            return ServiceRepository.addService(service, request);
        } else {
            return false;
        }
    }
}
