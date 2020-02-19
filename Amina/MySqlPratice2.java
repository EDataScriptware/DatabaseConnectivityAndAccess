import java.sql.*;
import java.util.*;

public class MySqlPratice2
{
   public static void main(String[] args)
   {
      class MySqlPrat
      {
         private String uri = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         private String driver = "com.mysql.cj.jdbc.Driver";
         private String user = "root";
         private String password = "Lovers@1996";
      
         private Connection conn = null;
         private Statement stmt;
         private ResultSet result;
         private ResultSetMetaData rsmd;
         private PreparedStatement newID;
         private PreparedStatement newPh;
         private PreparedStatement newZips;
      
         public MySqlPrat(){}
      
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
               //e.printStackTrace();
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
      
         public String createNewID()
         {
            try
            {
               stmt = conn.createStatement();
               String sql = "SELECT * FROM passenger ORDER BY passengerid DESC LIMIT 1;";
               result = stmt.executeQuery(sql);
               rsmd = result.getMetaData();
               int numColumn = rsmd.getColumnCount();
               String output = "";
               
               result.next();
               int ID = result.getInt(1);
               ID += 1;
               
               String fName = "Amina";
               String lName = "Mahmood";
               String street = "6000 Reynold";
               String city = "Rochester";
               String zip = "14620";
               String state = "NY";
               String phone = "347-698-5357";
               String phoneType = "Cell";
               
               String insertID = "INSERT INTO passenger VALUE(?,?,?,?,?)";
               String insertPhone = "INSERT INTO phones VALUE(?,?,?);";
               String insertZip = "INSERT INTO zips VALUE(?,?,?);";
               
               newID = conn.prepareStatement(insertID);
               newID.setInt(1, ID);
               newID.setString(2, fName);
               newID.setString(3, lName);
               newID.setString(4, street);
               newID.setString(5, zip);
               
               newPh = conn.prepareStatement(insertPhone);
               newPh.setInt(1, ID);
               newPh.setString(2, phone);
               newPh.setString(3, phoneType);
            
               newZips = conn.prepareStatement(insertZip);
               newZips.setString(1, zip);
               newZips.setString(2, city);
               newZips.setString(3, state );
               
               newZips.executeUpdate();
               newID.executeUpdate();
               newPh.executeUpdate();
               
               String query = "SELECT * FROM passenger join phones using(passengerid) join zips using(zip) WHERE passengerid = " + ID + ";";
               stmt = conn.createStatement();
               result = stmt.executeQuery(query);
               rsmd = result.getMetaData();
               
               //int num = 0; 
               while(result.next())
               {
                  for(int i = 1; i <= numColumn; i++)
                  {
                     output += result.getString(i) + " ";
                  }
                  //num++;
               }
               return output;
            }
            catch(SQLException sqle)
            {
               sqle.printStackTrace();
               return " ";
            }
         }
      }
      
      MySqlPrat db = new MySqlPrat();
      if( db.connect())
      {
         System.out.println( db.createNewID() );
         db.disconnect();
      }
      else
      {
         System.out.println("Failed to connect the db");
      }
   }   
}