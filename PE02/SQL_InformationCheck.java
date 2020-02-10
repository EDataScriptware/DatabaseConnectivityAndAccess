import java.sql.*;
import javax.sql.*;

public class SQL_InformationCheck  
{


   public static void main(String[] args) 
   {
   // Instances Databases Classes
      SQLServerDatabase ssd = new SQLServerDatabase();
      MySQLDatabase msd = new MySQLDatabase();
   
   // Databases URL
      String hostMySQL = msd.getURL();
      String hostMS_SQL = ssd.getURL();
   
   // Drivers
      String driverMySQL = msd.getDriverInfo();
      String driverSQLServer = ssd.getDriverInfo();
   
   // Authentication   
      String userMySQL = msd.getUser();
      String userSQLServer = ssd.getUser();
      
      String passwordSQLServer = ssd.getPassword();
      String passwordMySQL = msd.getPassword();
   
   // SQL Types
      String MS_SQL = ssd.getDatabaseType();
      String mySQL = msd.getDatabaseType();
   
   
   // Boolean Connections
      boolean flagConnection_MySQL  = connect(hostMySQL, userMySQL, passwordMySQL, driverMySQL, mySQL);
      boolean flagConnection_MS_SQL = connect(hostMS_SQL, userSQLServer, passwordSQLServer, driverSQLServer, MS_SQL);
   
   // MySQL Server Flag Check
      if (flagConnection_MySQL == true)
      {
         System.out.println("\nMySQL Server Connection was active and is now closed!");
      }
      else 
      {
         System.out.println("\nMySQL Server Connection is NOT active!");
      }
   
   // MS_SQL Server Flag Check
      if (flagConnection_MS_SQL == true)
      {
         System.out.println("Microsoft SQL Server Connection was active and is now closed!");
      }
      else 
      {
         System.out.println("Microsoft SQL Server Connection is NOT active!");
      }
      
      if (flagConnection_MS_SQL == true && flagConnection_MySQL == true)
      {
         System.out.println("\n\nAll connections work!");
      }
      
   }
   
   public static boolean connect(String url, String user, String password, String driver, String type)
   {
   
      Statement statement = null;
      ResultSet resultSet = null;
    
      try 
      {
         
         // Loads driver
         Class.forName(driver);     
         
         // Initiates Connection
         System.out.print("\nAttempting to initiate connection to " + url + " as " + user + "...");
         Connection connection = DriverManager.getConnection(url, user, password);
         System.out.print("Success!");
      
      // Statements allow to issue SQL queries to the database
         statement = connection.createStatement();
            
         if (type == "MySQL")
         {
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("SHOW TABLES;");
         }
         else if (type == "MS_SQL")
         {
         // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("SELECT name FROM master.dbo.sysdatabases");
         }
                 
         System.out.println("\n\nTHIS IS THE RESULT FOR " + type + ": " + resultSet);
      
         close(connection);
         
         // If all is fine and swell - return true as operational
         return true;
      
      
      }
      catch (SQLException e)
      {
         System.out.println("Message: " + e.getMessage());
         
         // If all is NOT fine and swell - return false as inoperational
         return false;
      }
      catch (Exception e)
      {
         System.out.println("Connection FAILED\nError: " + e.toString());
      
         // If all is NOT fine and swell - return false as inoperational
         return false;
      }
   } // end connect method
   
   public static boolean close(Connection connection)
   {
      try 
      {
         System.out.print("\nAttempting to close connection...");
         connection.close();
         System.out.print("Success!");
      }
      catch (Exception e)
      {
         System.out.println("Error! Failed to close! Error Message: " + e.toString());
         return false;
      }
      return true;
   }
   
   
   
}