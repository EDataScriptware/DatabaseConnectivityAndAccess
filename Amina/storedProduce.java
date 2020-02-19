import java.util.*;
import java.sql.*;

public class storedProduce
{
   public static void main(String[] args)
   {
      class mySqlPrat
      {
         private String uri = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         private String driver = "com.mysql.cj.jdbc.Driver";
         private String user = "root";
         private String password = "Lovers@1996";
      
         private Connection conn = null;
         private Statement stmt;
         private ResultSet result;
         private CallableStatement call = null;
         private ResultSetMetaData rsmd;
         
         public mySqlPrat(){}
         
         public boolean connect()
         {
            try
            {
               Class.forName(driver);
               conn = DriverManager.getConnection(uri, user, password);
               System.out.println("DB Connected!");
               return true;
            }
            catch(Exception e)
            {
               System.out.println("Cannot DB connected");
               return false;
            }
         }
      
         public boolean disconnect()
       {
            try
            {
               if(conn != null)
               {
                  conn.close();
                  return true;
               }
               else
               {
                  return false;
               }
            }
            catch(Exception e)
            {
               e.printStackTrace();
               return false;
            }
         }
         
         public void addPassenger()
         {
            try
            {
               stmt = conn.createStatement();
               String sql = "SELECT * FROM passenger ORDER BY passengerid DESC LIMIT 1;";
               result = stmt.executeQuery(sql);
               result.next();
               int ID = result.getInt(1) + 1;
               String output = "";
               
               String sql2 = "call addPass(?,?,?,?,?,?,?,?,?);";
               call = conn.prepareCall(sql2);
               call.setInt(1, ID);
               call.setString(2, "Amina");
               call.setString(3, "Lily");
               call.setString(4, "123 Onion Key");
               call.setString(5, "Rochester");
               call.setString(6, "NY");
               call.setString(7, "10101");
               call.setString(8, "112-123-1234");
               call.setString(9, "Cell");

               call.execute();
               
               stmt = conn.createStatement();
               String sql3 = "SELECT * FROM passenger join phones using(passengerid) join zips using(zip) where passengerid =" + ID + ";";
               result = stmt.executeQuery(sql3);
               
               while(result.next())
               {
                  output += result.getInt(1) + " ";
                  output += result.getString(2) + " ";
                  output += result.getString(3) + " ";
                  output += result.getString(4) + " ";
                  output += result.getString(5) + " ";
                  output += result.getString(6) + " ";
                  output += result.getString(7) + " ";
                  output += result.getString(8) + " ";
                  output += result.getString(9) + " ";
                  System.out.println(output);
               }
               
               result.close();
            }
            catch(SQLException e)
            {
               e.printStackTrace();
            }
         }
      }
      mySqlPrat db = new mySqlPrat();
      db.connect();
      db.addPassenger();
      db.disconnect();
   }
}