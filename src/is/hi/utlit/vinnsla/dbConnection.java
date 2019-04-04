package is.hi.utlit.vinnsla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database
 * @author Julian Jupiter
 *
 */
public class dbConnection {
    private static final Logger logger = Logger.getLogger(dbConnection.class.getName());
          private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
          private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/banki";
          private static final String DB_USER = "2509972569";
          private static final String DB_PASSWORD = "mypassword";

          public dbConnection() {
            
          }

          public static Connection getDBConnection() throws SQLException {
                  Connection connection = null;

                  try {
                          Class.forName(DB_DRIVER);
                  } catch (ClassNotFoundException exception) {
                          logger.log(Level.SEVERE, exception.getMessage());
                  }

                  try {
                          connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                          return connection;
                  } catch (SQLException exception) {
                          logger.log(Level.SEVERE, exception.getMessage());
                  }

                  return connection;
          }
}