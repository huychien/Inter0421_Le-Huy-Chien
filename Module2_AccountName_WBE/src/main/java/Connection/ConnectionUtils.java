package Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class ConnectionUtils{
    public static Connection getMyConnect(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if ("admin".equals(role)) {
            String dbUrl = "jdbc:mysql://localhost:3306/Furama";
            String userName = "root";
            String password = "Mung5@thang10";
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            return connection;
        } else if ("user".equals(role)){
            String dbUrl = "jdbc:mysql://localhost:3306/Furama";
            String userName = "user";
            String password = "Mung5@thang10";
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            return connection;
        } else {
            return null;
        }
    }
}
