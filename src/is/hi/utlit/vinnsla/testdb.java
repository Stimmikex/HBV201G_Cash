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
    /**
     * This function is used for all select mySQL queries
     * @param query the name says it all.
     * @return rset.
     * @throws SQLException 
     */
    public static ResultSet rundb(String query) throws SQLException{
        Connection connection = null;
        connection = dbConnection.getDBConnection();
        Statement stmt = connection.createStatement();

        String sql = query;
        ResultSet rset = stmt.executeQuery(sql);
        return rset;
    }
    /**
     * This function is used for all update/insert mySQL queries
     * @param query the name says it all.
     * @throws SQLException 
     */
    public static void updateQuery(String query) throws SQLException {
        Connection connection = null;
        connection = dbConnection.getDBConnection();
        Statement stmt = connection.createStatement();

        stmt.executeUpdate(query);
    }
}
