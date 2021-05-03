package Model.Repository;

import Connection.ConnectionUtils;
import Model.Bean.Rent_type;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentTypeRepository {

    public static ArrayList<Rent_type> findAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM KieuThue");
            ArrayList<Rent_type> list = new ArrayList<>();

            while (result.next()) {
                int rent_type_id = result.getInt("IdKieuThue");
                String rent_type_name = result.getString("TenKieuThue");
                double rent_type_cost = result.getDouble("Gia");

                Rent_type rent_type = new Rent_type(rent_type_id, rent_type_name, rent_type_cost);
                list.add(rent_type);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Rent_type getRentType(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM KieuThue Where IdKieuThue = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            Rent_type rent_type = new Rent_type();
            while (result.next()) {
                int rent_type_id = result.getInt("IdKieuThue");
                String rent_type_name = result.getString("TenKieuThue");
                double rent_type_cost = result.getDouble("Gia");

                rent_type = new Rent_type(rent_type_id, rent_type_name, rent_type_cost);
            }
            result.close();
            return rent_type;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
