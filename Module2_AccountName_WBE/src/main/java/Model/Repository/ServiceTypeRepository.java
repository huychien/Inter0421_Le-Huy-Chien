package Model.Repository;

import Connection.ConnectionUtils;
import Model.Bean.Service_type;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceTypeRepository {

    public static ArrayList<Service_type> findAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM LoaiDichVu");
            ArrayList<Service_type> list = new ArrayList<>();

            while (result.next()) {
                int service_type_id = result.getInt("IdLoaiDichVu");
                String service_type_name = result.getString("TenLoaiDichVu");

                Service_type service_type = new Service_type(service_type_id, service_type_name);
                list.add(service_type);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Service_type getServiceType(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM LoaiDichVu Where IdLoaiDichVu = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            Service_type service_type = new Service_type();
            while (result.next()) {
                int service_type_id = result.getInt("IdLoaiDichVu");
                String service_type_name = result.getString("TenLoaiDichVu");

                service_type = new Service_type(service_type_id, service_type_name);
            }
            result.close();
            return service_type;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
