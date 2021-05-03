package Model.Repository;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionUtils;
import Model.Bean.Education_degree;

import javax.servlet.http.HttpServletRequest;

public class EducationRepository {

    public static ArrayList<Education_degree> findAllEducation(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM TrinhDo");
            ArrayList<Education_degree> list = new ArrayList<>();

            while (result.next()) {
                int education_id = result.getInt("IdTrinhDo");
                String education_name = result.getString("TrinhDo");

                Education_degree education_degree = new Education_degree(education_id, education_name);
                list.add(education_degree);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Education_degree getEducation(int id, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM TrinhDo Where IdTrinhDo = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            Education_degree education_degree = new Education_degree();
            while (result.next()) {
                int education_id = result.getInt("IdTrinhDo");
                String education_name = result.getString("TrinhDo");

                education_degree = new Education_degree(education_id, education_name);
            }
            result.close();
            return education_degree;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
