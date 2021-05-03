package Model.Repository;

import Connection.ConnectionUtils;
import Model.Bean.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceRepository {

    public static Service getService(int service_id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" SELECT * FROM Furama.DichVu dv join KieuThue kt on kt.IdKieuThue = dv.IdKieuThue " +
                    " join LoaiDichVu ldv on ldv.IdLoaiDichVu = dv.IdLoaiDichVu " +
                    " Where dv.IdDichVu = ? ");
            ps.setInt(1, service_id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                return getData(service_id, result);
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static Service getData(int service_id, ResultSet result) throws SQLException {
        String service_name = result.getString("TenDichVu");
        int service_area = result.getInt("DienTich");
        double service_cost = result.getDouble("ChiPhiThue");
        int service_max_people = result.getInt("SoNguoiToiDa");
        int rent_type_id = result.getInt("IdKieuThue");
        String rent_type_name = result.getString("TenKieuThue");
        double rent_type_cost = result.getDouble("Gia");
        int service_type_id = result.getInt("IdLoaiDichVu");
        String service_type_name = result.getString("TenLoaiDichVu");
        String standard_room = result.getString("standard_room");
        String description_other_convenience = result.getString("description_other_convenience");
        double pool_area = result.getDouble("pool_area");
        int number_of_floors = result.getInt("SoTang");

        Rent_type rent_type = new Rent_type(rent_type_id, rent_type_name, rent_type_cost);
        Service_type service_type = new Service_type(service_type_id, service_type_name);
        Service service = new Service(service_id, service_name, service_area, service_cost, service_max_people, rent_type,
                service_type, standard_room, description_other_convenience, pool_area, number_of_floors);

        return service;
    }

    public static ArrayList<Service> findAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" SELECT * FROM Furama.DichVu dv join KieuThue kt on kt.IdKieuThue = dv.IdKieuThue " +
                    " join LoaiDichVu ldv on ldv.IdLoaiDichVu = dv.IdLoaiDichVu ");
            ResultSet result = ps.executeQuery();
            ArrayList<Service> list = new ArrayList<>();

            while (result.next()) {
                int service_id = result.getInt("IdDichVu");
                list.add(getData(service_id, result));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean addService(Service service, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO DichVu(TenDichVu, DienTich, SoTang, SoNguoiToiDa, " +
                    " ChiPhiThue, IdKieuThue, IdLoaiDichVu, standard_room, description_other_convenience, pool_area ) " +
                    " VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
            setData(service, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static void setData(Service service, PreparedStatement ps) throws SQLException {
        ps.setString(1, service.getService_name());
        ps.setInt(2, service.getService_area());
        ps.setInt(3, service.getNumber_of_floors());
        ps.setInt(4, service.getService_max_people());
        ps.setDouble(5, service.getService_cost());
        ps.setInt(6, service.getRent_type().getRent_type_id());
        ps.setInt(7, service.getService_type().getService_type_id());
        ps.setString(8, service.getStandard_room());
        ps.setString(9, service.getDescription_other_convenience());
        ps.setDouble(10, service.getPool_area());
        ps.executeUpdate();
    }
}
