import java.sql.*;
import javax.sql.*;

public class MySQLDatabase  
{

   static String hostMySQL = "jdbc:mysql://simon.ist.rit.edu:3306/networx_ser";
   static String driverMySQL = "com.mysql.jdbc.Driver";
   static String user = "330User";
   static String password = "330Password";
   static String databaseType = "MySQL";

   public static void main(String[] args) 
   {
      // Boolean Connections
      boolean flagConnection_MySQL  = connect(hostMySQL, user, password, driverMySQL);
      System.out.println(flagConnection_MySQL);
   }
   
  
   
   
   public static boolean connect(String url, String user, String password, String driver)
   {
      try 
      {
         
         // Loads driver
         Class.forName(driver);     
         
         // Initiates Connection
         // System.out.print("\nAttempting to initiate connection to " + url + " as " + user + "...");
         Connection connection = DriverManager.getConnection(url, user, password);
         // System.out.print("Success!");
      
         close(connection);
         
         // If all is fine and swell - return true as operational
         return true;
      
      
      }
      catch (SQLException e)
      {
        // System.out.println("Message: " + e.getMessage());
         
         // If all is NOT fine and swell - return false as inoperational
         return false;
      }
      catch (Exception e)
      {
         // System.out.println("Connection FAILED\nError: " + e.toString());
      
         // If all is NOT fine and swell - return false as inoperational
         return false;
      }
   } // end connect method
   
   public static boolean close(Connection connection)
   {
      try 
      {
       //  System.out.print("\nAttempting to close connection...");
         connection.close();
       //  System.out.print("Success!");
      }
      catch (Exception e)
      {
       //  System.out.println("Error! Failed to close! Error Message: " + e.toString());
         return false;
      }
      return true;
   }

   public String getURL()
   {
      return hostMySQL;
   }
   public String getDriverInfo()
   {
      return driverMySQL;
   }
   public String getPassword()
   {
      return password;
   }
   public String getUser()
   {
      return user;
   }
   public String getDatabaseType()
   {
      return databaseType;
   }
   
   
   
}
