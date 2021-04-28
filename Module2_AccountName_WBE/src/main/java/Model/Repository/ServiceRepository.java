package Model.Repository;

import Model.Bean.Service;

import java.util.ArrayList;

public interface ServiceRepository {
    ArrayList<Service> searchService(String name);
    void deleteService(int id);
    void updateService(int id);
    void addService(Service service);
}
