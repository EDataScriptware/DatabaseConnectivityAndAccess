import java.sql.*;
import java.util.*;
/**
*Amina Mahmood
*ISTE 330.01-02
*Mr. Floser
*Database Connectivity and Access
*/

public class MySqlDatabase
{
   // Definitions for MySQL connection
   String uri = "jdbc:mysql://localhost/travel?";
   String driver = "com.mysql.jdbc.Driver";
   String user = "root";
   String password ="student";
   
   Connection conn = null;
   
   public MySqlDatabase()
   {   
     
   }
   
   // Connect method
   public boolean connect()
   {
      // Use try and catch statement
      try
      {
         Class.forName(driver);
         conn = DriverManager.getConnection(uri, user, password);
         return true;
      }
      catch( ClassNotFoundException ce )
      {
         ce.printStackTrace();
         System.exit(1);
         return false;
      }
      catch (SQLException e) 
      {
         e.printStackTrace();
         return false;
      }
   }
   
   // Close the database
   public boolean closeConnect()
   {
      try 
      {
         if (conn != null) 
         {
            conn.close();
            return true;
         }
         else
         {
            return false;
         }
      } 
      catch (SQLException sqle) 
      {
         sqle.printStackTrace();
         return false;
      }
   }
      
   // Use an arraylist with getData method 
   public ArrayList<ArrayList<String>> getData(String queny, int columnNum)
   {
   
      ArrayList<ArrayList<String>> myTable = new ArrayList<ArrayList<String>>();
      ArrayList<String> field = new ArrayList<String>();  
      
      try 
      {
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(queny);
        
         int num = 0;
        
         while (rs.next())
         {
            myTable.add(field);  
            for ( int i = 1; i <= columnNum; i++) 
            {
               myTable.get(num).add(rs.getString(i));
            }
            
            num++;  
         }
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      return myTable;
   }
   
   // SetData method
   public int setData(String sql)
   {
      try
      {
         Statement stmt = conn.createStatement();
         
         int test = stmt.executeUpdate(sql);
         
         return test;
      }
      catch(SQLException e)
      {
         System.out.println("Error: " + e + "\n" + e.toString());
         return -1;
      }
   }
}