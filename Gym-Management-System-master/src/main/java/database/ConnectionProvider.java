package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionProvider {

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url =
                "jdbc:mysql://localhost:3306/gmsdb?useSSL=false&serverTimezone=UTC";

            String username = "root";

            String password = "Shabnam@12";

            Connection connection =
                DriverManager.getConnection(url, username, password);

            return connection;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);

            e.printStackTrace();

            return null;
        }
    }
}