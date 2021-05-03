package Model.Repository;

import Model.Bean.Position;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionUtils;

import javax.servlet.http.HttpServletRequest;

public class PositionRepository {

    public static ArrayList<Position> findAllPosition(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM ViTri");
            ArrayList<Position> list = new ArrayList<>();

            while (result.next()) {
                int position_id = result.getInt("IdViTri");
                String position_name = result.getString("TenViTri");

                Position position = new Position(position_id, position_name);
                list.add(position);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Position getPosition(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ViTri Where IdViTri = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            Position position = new Position();
            while (result.next()) {
                int position_id = result.getInt("IdViTri");
                String position_name = result.getString("TenViTri");
                position = new Position(position_id, position_name);
            }
            result.close();
            return position;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
