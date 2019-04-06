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
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Styrmir Óli
 */
public class testdb extends dbConnection {
    public static ResultSet rundb(String query) throws SQLException{
        Connection connection = null;
        connection = dbConnection.getDBConnection();
        Statement stmt = connection.createStatement();

        String sql = query;
        ResultSet rset = stmt.executeQuery(sql);
        return rset;
    }
    public static void updateQuery(String query) throws SQLException {
        Connection connection = null;
        connection = dbConnection.getDBConnection();
        Statement stmt = connection.createStatement();

        stmt.executeUpdate(query);
    }
}
