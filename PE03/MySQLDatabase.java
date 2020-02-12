import java.sql.*;
import javax.sql.*;
import java.util.*;

public class MySQLDatabase  
{

   // Connecting Classes Together
   static main m = new main();
   static Equipment equipment = new Equipment();

   // Initialized Variables
//   static Connection connection = null;
   static String hostMySQL = "jdbc:mysql://localhost/travel?";
   static String driver = "com.mysql.jdbc.Driver";
   static String user = "root";
   static String password = "student";
   static String databaseType = "MySQL";  
   static Connection connection = null; 
   
   // Changed Connection to return connection instead of boolean
   public static Connection connect()
   {
      try 
      {
         
         // Loads driver
         Class.forName(driver);     
         
         // Initiates Connection
         // System.out.print("\nAttempting to initiate connection to " + url + " as " + user + "...");
         Connection connection = DriverManager.getConnection(hostMySQL, user, password);
         // System.out.print("Success!");
      
         close(connection);
         
         // If all is fine and swell - return connection
         return connection;
      
      
      }
      catch (SQLException e)
      {
         // System.out.println("Message: " + e.getMessage());
         
         // If all is NOT fine and swell - return null as inoperational
         return null;
      }
      catch (Exception e)
      {
         // System.out.println("Connection FAILED\nError: " + e.toString());
      
         // If all is NOT fine and swell - return null as inoperational
         return null;
      }
   } // end connect method
   
   public static boolean close(Connection connection)
   {
      try 
      {
       //  System.out.print("\nAttempting to close connection...");
       
       // Receive ANY connection and attempt to close. 
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
      return driver;
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
   
   
    static MySQLDatabase msd = new MySQLDatabase();

   public ArrayList<ArrayList<String>> getData(String query, int columnNum, Connection connection)
   {
      ArrayList<ArrayList<String>> twoDimensionalArray = new ArrayList<ArrayList<String>>();
      ArrayList<String> info = new ArrayList<String>();  
      
      try
      {
      
         // "Prepare" then "execute" statements. 
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(query);
         
         int count = 0;
         
         while (rs.next())
         {
            twoDimensionalArray.add(info);  
            for ( int i = 1; i <= columnNum; i++) 
            {
              twoDimensionalArray.get(count).add(rs.getString(i));
            }
            
            
            
            
            // *The Jim Habermas Style Code*
            // int i = 1;
//                      // keeps getting them and puts them in an row
//             while (rs.next()) {
//                row.add(rs.getString(i));
//             
//             ++i;
//             } // end of inner while loop - each row
            
            
            
            
            count++;  
         }      
      
      }
      catch (SQLException e)
      {
         System.out.println(e.toString());
      }
      
      return twoDimensionalArray;
   }
   
   
   public int setData(String query)
   {
      try 
      {
         Statement statement = connection.createStatement();
         
         // how many rows updated
         int row = statement.executeUpdate(query);
         
         return row;
      }
      catch (Exception e)
      {
         System.out.println(e.toString());
         
         // return error code
         return -1;
      }
         
   
   
   }
   
   
   
}

   
   

