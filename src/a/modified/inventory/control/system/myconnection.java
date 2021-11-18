
package a.modified.inventory.control.system;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myconnection {
     private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "inventory_control";
    private static Integer portnumber = 3306;
    private static String password = "28111997";
     private static String useSSL = "false";
     private static String autoReconnect = "true";
    
    
    
    public static Connection getConnection(){
        Connection con = null;
        
       MysqlDataSource datasource = new MysqlDataSource();
       
       datasource.setServerName(servername);
       datasource.setUser(username);
       datasource.setDatabaseName(dbname);
       datasource.setPassword(password);
       datasource.setPortNumber(portnumber);
       datasource.setUseSSL(false);
        datasource.setAutoReconnect(true);
       
       
        try {
            con = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("get connection ->" + myconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return con;
        
        }
    }



    

