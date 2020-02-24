// Name: Trent Douglas Jacobson

import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;

public class MySQLDatabase {

   // Set up new variables below
   private static String dbURL = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false";
   public static String driver = "com.mysql.jdbc.Driver";
   private static String user = "root";
   private static String pass = "students";
        
   public static Connection conn = null;

        
   public static void main(String args[]) {
      connect(); // method
      main();
      
   
   }
   
   // static method
   public static boolean connect() {
      try {
         Class.forName(driver); // loads the driver
      }
            
      catch(ClassNotFoundException e) {
            
         System.out.println("The Error Message: " + e); // To find if there is driver error
         return false;
      }
      catch (Exception e) {
         System.out.println("Error Message: " + e); // To find any errors
      }
      
      
      try {
         conn = DriverManager.getConnection(dbURL, user, pass); // Put dbURL, user, and pass into conn as a new variable for connection.
         return true;      
      }
      
      catch (SQLException ne) {
         System.out.println("The Error Message: " + ne); // To find if there is any error
         return false;
      } 
   }
   
   
   public boolean close() {
      try {
         System.out.print("Closing this connection\n"); // Prints and says it is closing the connection.
         conn.close(); // closes the connection
         
         System.out.println("Connection has been closed."); // Prints and it says connection is already closed.
      
         return true;
      }
      
      catch(Exception tx) {
         System.out.println("The Database cannot be closed: " + tx); // probably was already closed or never had a connection
         
      }
      return false;
   }
   
   
   
   public static boolean main() {
            
      MySQLDatabase MySQL = new MySQLDatabase(); // instantiates this database
      
      // Opens both databases below but prints some information about drivers and others.
      System.out.println( "\n");
      System.out.println("MySQLDatabase Connection: " + MySQL.connect() + " \nDriver Loaded: " + MySQL.driver + "\nConnecting to the database: " + MySQL.dbURL);  
      System.out.println( "\n");
      System.out.println("MySQLDatabase Termination : " + MySQL.close()); // Closes MySQLDatabase
      
      return false;
   } 
   
  
  
// getData method 
   public ArrayList<ArrayList<String>> getData(String SQLQuery, int NumberofFields) {
      ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
      ArrayList<String> data = new ArrayList<String>();  
      
      try {
      
         Statement statement = conn.createStatement();  
         ResultSet resultset = statement.executeQuery(SQLQuery);
         
         int count = 0;
         
         while (resultset.next()) {
            array.add(data);  
            for ( int i = 1; i <= NumberofFields; i++) {
               array.get(count).add(resultset.getString(i));
            }           
            count++;  
         }      
      
      }
      catch (SQLException error) {
         System.out.println("Error: " + error);
      }
      return array;
   }
   
   // Added another method named getData that accepts SQL string and returns a 2-d ArrayList
   public ArrayList<ArrayList<String>> getData(String SQLQuery) {
      ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
      
      int numberColumns = 0;
      
      String first = "Column Name";
      String second = "Column Type";
      
                  

             
      try {
      
         Statement statement = conn.createStatement();  
         DatabaseMetaData databasemetadata = conn.getMetaData();  
         ResultSet resultset = statement.executeQuery(SQLQuery);       
         ResultSetMetaData resultsetmetadata = resultset.getMetaData();
         
         String tableName = resultsetmetadata.getTableName(1);
         numberColumns = resultsetmetadata.getColumnCount();
         

         
         String firstRow = "Table " + tableName + " has " + numberColumns + " fields.";
         String list = String.format("....%-11s....     ....%-11s....", first, second);
         System.out.printf(firstRow + "\n\n" + list + "\n");
         
                     for(int i = 1; i <= numberColumns; i++) {
               String record = String.format("%-25s    %-15s", resultsetmetadata.getColumnName(i), (resultsetmetadata.getColumnTypeName(i) + "(" + resultsetmetadata.getColumnDisplaySize(i) + ")"));
               System.out.printf( record + "\n");
            }
         
         
         if(resultset.isBeforeFirst()) {
         
         
            numberColumns = resultsetmetadata.getColumnCount();

            System.out.println();
            String repeat = "";
            boolean flag = true;
            int columnSize = 0;
            int width = 0;
            String columnLabel = "|";
         
            while(resultset.next()) {
               String output = "";
               for(int i = 1; i <= numberColumns; i++) {
                  columnSize = resultsetmetadata.getColumnName(i).length() + 6;
                  String format = "%-" + columnSize + "s|";
                  String record = String.format(format, resultset.getString(i));
                  output += record;
               
               // If it is true
                  if(flag) {
                     columnLabel += String.format(format, resultsetmetadata.getColumnName(i));
                     repeat += getRepeat(columnSize);
                  }
               }
            // If it is true
               if(flag){
                  System.out.println(repeat + "+");
                  System.out.println(columnLabel);
                  System.out.println(repeat + "+");
                  flag = false;
               }
               System.out.println("|" +output);
            }
            System.out.println(repeat + "+");
            statement.close();
            resultset.close();  
         }
         else {
            System.out.println("No data");
         }
      }
      
      catch(Exception e) {
         System.out.println(e);
      }
       s
      return array;
   }
   
   // Use a line format
   public String getRepeat(int num) {
      String l = "+";
      for(int i = 0; i < num; i++)
      {
         l += "-";
      }
      return l;
   }
   
   public int setData(String SQLQuery) {
      try {
         
         Statement statement = conn.createStatement();
      
         int tinydata = statement.executeUpdate(SQLQuery);
         
         return tinydata;
      }
      catch (Exception error)
      {
         System.out.println("Error: " + error);
         return -1;
      }
   }
}