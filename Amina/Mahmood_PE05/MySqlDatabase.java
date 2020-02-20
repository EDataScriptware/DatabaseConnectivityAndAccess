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
      // Try and catch statement
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
         errorMessage.add("java.MySqlDatabase.close: " + sqle.getMessage());
         throw new DLException(sqle, errorMessage);
      }
   }
      
   // Use an arraylist with getData method 
   // Question 1: 
   public ArrayList<ArrayList<String>> getData(String query) throws DLException
   {
      // Add arrayList for myTable and field
      ArrayList<ArrayList<String>> myTable = new ArrayList<ArrayList<String>>();
      ArrayList<String> field = new ArrayList<String>();  
      
      // Try and catch statement
      try 
      {
         Statement stmnt = conn.createStatement();
         ResultSet rs = stmnt.executeQuery(query);
         ResultSetMetaData rsmd = rs.getMetaData();
         int columnNum = rsmd.getColumnCount();
        
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
         errorMessage.add("java.MySqlDatabase.getData: " + sqle.getMessage());
         throw new DLException(sqle, errorMessage);
      }
      return myTable;
   }
   
   // Create a descTable method with single parameter
   public void descTable(String query)throws DLException
   {  
      try
      {
         Statement stmt = conn.createStatement();  
         DatabaseMetaData dmd = conn.getMetaData();  
         ResultSet rs = stmt.executeQuery(query);       
         ResultSetMetaData rsmd = rs.getMetaData();
         if(rs.isBeforeFirst())
         {
         
         // Create variables
         String tableName = rsmd.getTableName(1);
         int numCols = rsmd.getColumnCount();
         String first = "Column Name";
         String second = "Column Type";
         StringBuilder sb = new StringBuilder();
         
         // Question 2:
         String firstRow = "Table " + tableName + " has " + numCols + " fields.";
         String list = String.format("....%-11s....     ....%-11s....", first, second);
         System.out.printf(firstRow + "\n\n" + list + "\n");
         
         for(int i = 1; i <= numCols; i++)
         {
            String record = String.format("%-25s    %-15s", rsmd.getColumnName(i), (rsmd.getColumnTypeName(i) + "(" + rsmd.getColumnDisplaySize(i) + ")"));
            System.out.printf( record + "\n");
         }
         
         System.out.println("\n");
         
         // Question 3:
         System.out.println();
         String repeat = "";
         boolean flag = true;
         int columnSize = 0;
         int width = 0;
         String columnLabel = "|";
         
         while(rs.next())
         {
            String output = "";
            for(int i = 1; i <= numCols; i++)
            {
               columnSize = rsmd.getColumnName(i).length() + 6;
               String format = "%-" + columnSize + "s|";
               String record = String.format(format, rs.getString(i));
               output += record;
               
               // If it is true
               if(flag)
               {
                  columnLabel += String.format(format, rsmd.getColumnName(i));
                  repeat += getRepeat(columnSize);
               }
            }
            // If it is true
            if(flag)
            {
               System.out.println(repeat + "+");
               System.out.println(columnLabel);
               System.out.println(repeat + "+");
               flag = false;
            }
            System.out.println("|" +output);
         }
         System.out.println(repeat + "+");
         stmt.close();
         rs.close();  
         }
         else
         {
            System.out.println("No data");
         }
      }
      catch(SQLException sqle)
      {
         errorMessage.add("java.MySqlDatabase:descTable: " + sqle + "\n" + sqle.toString());
         throw new DLException(sqle, errorMessage);
      }         
      }
   
   // Use a line format
   public String getRepeat(int num)
   {
      String l = "+";
      for(int i = 0; i < num; i++)
      {
         l += "-";
      }
      return l;
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