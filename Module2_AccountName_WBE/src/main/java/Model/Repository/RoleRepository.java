package Model.Repository;

import Model.Bean.Customer_type;
import Model.Bean.Role;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionUtils;

import javax.servlet.http.HttpServletRequest;

public class RoleRepository {

    public static ArrayList<Role> findAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            Statement s = connection.createStatement();
            ResultSet result = s.executeQuery("SELECT * FROM Role");
            ArrayList<Role> list = new ArrayList<>();

            while (result.next()) {
                int role_id = result.getInt("role_id");
                String role_name = result.getString("role_name");

                Role role = new Role(role_id, role_name);
                list.add(role);
            }
            result.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
