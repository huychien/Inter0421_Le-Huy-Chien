package Model.Repository;

import Connection.ConnectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {

    public static Boolean addUser(String username, String password, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO User VALUE (?, ?) ");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
