import java.sql.*;
import java.util.*;
/**
*Amina Mahmood
*ISTE 330.01-02
*Mr. Floeser
*Database Connectivity and Access
*/

public class MySqlDatabase
{
   // Definitions for MySQL connection
   private String uri = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   private String driver = "com.mysql.jdbc.Driver";
   private String user = "root";
   private String password ="students";
   
   private Connection conn = null;
   private ArrayList<String> errorMessage = new ArrayList<String>();
   
   public MySqlDatabase()
   {   
     
   }
   
   // Connect method
   public boolean connect() throws DLException
   {
      // Use try and catch statement
      try
      {
         Class.forName(driver);
         conn = DriverManager.getConnection(uri, user, password);
         System.out.println("works");
         return true;
      }
      catch (Exception sqle) 
      {
         errorMessage.add("java.MySqlDatabase.connect: " + sqle.getMessage());
         throw new DLException(sqle, errorMessage);
      }
   }
   
   // Close the database
   public boolean closeConnect() throws DLException
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
         //sqle.printStackTrace();
         errorMessage.add("java.MySqlDatabase.close: " + sqle.getMessage());
         throw new DLException(sqle, errorMessage);
         //return false;
      }
   }
      
   // Use an arraylist with getData method 
   public ArrayList<ArrayList<String>> getData(String query, int columnNum) throws DLException
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
      catch(SQLException sqle)
      {
         //e.printStackTrace();
         errorMessage.add("java.MySqlDatabase.getData: " + sqle.getMessage());
         throw new DLException(sqle, errorMessage);
      }
      return myTable;
   }
   
   int numReturn = 0;
   // SetData method
   public int setData(String sql) throws DLException
   {
      try
      {
         Statement stmt = conn.createStatement();
         
         int test = stmt.executeUpdate(sql);
         
         return test;
      }
      catch(SQLException sqle)
      {
         numReturn = -1;
         //System.out.println("Error: " + e + "\n" + e.toString());
         errorMessage.add("java.MySqlDatabase.setData: " + sqle.getMessage());
         throw new DLException(sqle, errorMessage);
         //return -1;
      }
   }
}