/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

/**
 *
 * @author 84915
 */
public class DBContext {

    public static Connection getConnection() throws SQLServerException {
        String server = "localhost";
        String username = "sa";
        String password = "0123";
        String db = "Quan_Ly_Nha_Tro";
        int port = 1433;
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(username);
        ds.setPassword(password);
        ds.setServerName(server);
        ds.setDatabaseName(db);
        ds.setPortNumber(port);
        return ds.getConnection();
    }

}
