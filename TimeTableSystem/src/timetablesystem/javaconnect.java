
package timetablesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author WAY4WARD
 */
public class javaconnect {
   Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
   
   
   public static Connection ConnecrDB(){
       try{
           Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/timetable","sa","");
            
            return conn;
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           return null;
       }
   }
}
