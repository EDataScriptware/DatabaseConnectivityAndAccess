/* 
   Name: Edward Riley
   Professor: Stephen Zilora
   Course: Database Connectivity and Access
   Date: Feburary 21, 2020
*/

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
   static String password = "students";
   static String databaseType = "MySQL";  
   static private Connection connection = null; 
   
   
   
   
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
      
         //close(connection);
         
         // If all is fine and swell - return connection
         return connection;
      
      
      }
      catch (SQLException e)
      {
         // System.out.println("Message: " + e.getMessage());
         
         // If all is NOT fine and swell - return null as inoperational
         System.out.println(e);
         return null;
      }
      catch (Exception e)
      {
         // System.out.println("Connection FAILED\nError: " + e.toString());
      
         // If all is NOT fine and swell - return null as inoperational
         System.out.println(e);
      
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

   public Connection getConnection()
   {
      return connection;
   }   
   public void setConnection(Connection _connection)
   {
      connection = _connection;
   }
   
   
   static MySQLDatabase msd = new MySQLDatabase();

   public ArrayList<ArrayList<String>> getData(String query, int columnNum)
   {
      ArrayList<ArrayList<String>> twoDimensionalArray = new ArrayList<ArrayList<String>>();
      ArrayList<String> info = new ArrayList<String>();  
      
      try
      {
      
         // Prepare then execute statements. 
         Statement stmt = connection.createStatement(); // The problem is... Connection is "null" 
         ResultSet rs = stmt.executeQuery(query);
         
         int count = 0;
         
         while (rs.next())
         {
            twoDimensionalArray.add(info);  
            for ( int i = 1; i <= columnNum; i++) 
            {
               twoDimensionalArray.get(count).add(rs.getString(i));
            }
                        
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
         Statement stmt = connection.createStatement();
         
         // how many rows updated
         int row = stmt.executeUpdate(query);
         
         return row;
      }
      catch (Exception e)
      {
         System.out.println(e.toString());
         
         // return error code
         return -1;
      }
   }
   
   public String getRepeat(int num) {
      String l = "+";
      for(int i = 0; i < num; i++)
      {
         l += "-";
      }
      return l;
   }
   
   // Added another method named getData that accepts SQL string and returns a 2-d ArrayList
   public ArrayList<ArrayList<String>> getData(String SQLQuery) {
      ArrayList<ArrayList<String>> twoDimensionalArray = new ArrayList<ArrayList<String>>();
      
      int numberOfColumns = 0;
                               
      try {
      
         Statement statement = connection.createStatement();  

         ResultSet resultSet = statement.executeQuery(SQLQuery);       
         ResultSetMetaData resultsetmetadata = resultSet.getMetaData();
         
         String tableName = resultsetmetadata.getTableName(1);
         numberOfColumns = resultsetmetadata.getColumnCount();
         
      
         
         System.out.printf("Table " + tableName + " has " + numberOfColumns + " fields.\n");
         
         System.out.printf("Attributes Name\t\t\t\t\tAttributesType");
         System.out.println("\n----------------------------------------------");

         for(int i = 1; i <= numberOfColumns; i++)
         {
            System.out.printf("\n%-25s     %-15s", resultsetmetadata.getColumnName(i), (resultsetmetadata.getColumnTypeName(i) + "(" + resultsetmetadata.getColumnDisplaySize(i) + ")"));
         }
         
         System.out.println("\n");
         
         if(resultSet.isBeforeFirst()) 
         {         
            System.out.println();
            String repeat = "";
            boolean flag = true;
            
            int columnSize = 0;
            int width = 0;
            String columnLabel = "|";
         
            while(resultSet.next()) 
            {
               String message = "";
               for(int i = 1; i <= numberOfColumns; i++) {
                  columnSize = resultsetmetadata.getColumnName(i).length() + 6;
                  String format = "%-" + columnSize + "s|";
                  String record = String.format(format, resultSet.getString(i));
                  message += record;
               
                     if(flag) {
                     columnLabel += String.format(format, resultsetmetadata.getColumnName(i));
                     repeat += getRepeat(columnSize);
                  }
               }

               if(flag){
                  System.out.println(repeat + "+");
                  System.out.println(columnLabel);
                  System.out.println(repeat + "+");
                  flag = false;
               }
               System.out.println("|" + message);
            }
            System.out.println(repeat + "+");
            statement.close();
            resultSet.close();  
         }
         else {
            System.out.println("-1");
         }
      }
      
      catch(Exception e) {
         System.out.println(e);
      }
       
      return twoDimensionalArray;
   }

   
}

   
   

