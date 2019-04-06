package is.hi.utlit.vinnsla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database
 * @author Styrmir Óli Þorsteinsson.
 *
 */
public class dbConnection {
    static String URL = "jdbc:mysql://localhost/banki";
    public static Connection getDBConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL,"root","");
        try {
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
    }
}