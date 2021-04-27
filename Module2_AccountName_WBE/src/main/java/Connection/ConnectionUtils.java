package Connection;

import java.sql.*;

public class ConnectionUtils {

    public static Connection getMyConnect() throws SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/Furama";
        String userName = "root";
        String password = "Mung5@thang10";
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        return connection;
    }
}
