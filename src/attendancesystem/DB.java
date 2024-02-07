/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancesystem;

/**
 *
 * @author Hamza
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Microsoft
 */
public class DB {
      public Connection setConnection(){
//        String dataSourceName="database/PasswordDB.accdb";
//        String dir = System.getProperty("user.dir");
       // String url = "C:\\Users\\Microsoft\\Desktop\\New folder (3)\\JavaAttendanceSystem-master\\AttendanceSystem\\databasef\\Database.accdb";
        String dataSourceName="databasef/Database.accdb";
        String dir = System.getProperty("user.dir");
        String url = "jdbc:ucanaccess://"+dir+"/" + dataSourceName;
        Connection con=null;
        try {
              con = DriverManager.getConnection(url);
        }
        catch(SQLException sqlEx){
                    System.out.println(sqlEx);
        }
        return con;
    }
}

