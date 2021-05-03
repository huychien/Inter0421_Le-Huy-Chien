package Model.Repository;

import Model.Bean.Division;
import Connection.ConnectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DivisionRepository {

    public static ArrayList<Division> findAllDivision(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM BoPhan");
            ArrayList<Division> list = new ArrayList<>();

            while (result.next()) {
                int division_id = result.getInt("IdBoPhan");
                String division_name = result.getString("TenBoPhan");

                Division division = new Division(division_id, division_name);
                list.add(division);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Division getDivision(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM BoPhan Where IdBoPhan = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            Division division = new Division();
            while (result.next()) {
                int division_id = result.getInt("IdBoPhan");
                String division_name = result.getString("TenBoPhan");

                division = new Division(division_id, division_name);
            }
            result.close();
            return division;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
