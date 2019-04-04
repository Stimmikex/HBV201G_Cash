/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is.hi.utlit.vinnsla;

//import dbConnection;
import java.sql.Connection;
import java.sql.SQLException;

import is.hi.utlit.vinnsla.dbConnection;


/**
 *
 * @author Styrmir Óli
 */
public class testdb extends dbConnection {
    public static String rundb() throws SQLException{
        Connection connection = null;
        connection = dbConnection.getDBConnection();
        return connection.toString();
    } 
}
