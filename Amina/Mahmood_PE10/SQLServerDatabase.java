/***
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
***/
import java.sql.*;

public class SQLServerDatabase
{
   private String uri = "jdbc:mysql://localhost/bankdb?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   private String driver = "com.mysql.cj.jdbc.Driver";
   private String user = "root";
   private String password = "student";
      
   Connection attributes = null;
      
   public SQLServerDatabase()
   {
      try 
      {
         Class.forName( driver );
         System.out.println("Driver loaded");
      }
      catch( ClassNotFoundException cnfe)
      {
         System.out.println("Connect find or load driver " + driver);
         cnfe.printStackTrace();
         System.exit(1);
      }
         
      if( connect() == false )
      {
         System.exit(1);
      }
   
      if( disconnect() == false )
      {
         System.exit(3);
      }
   }
   
   // Connect method - connect and then 
   public boolean connect()
   {
      try
      {
         attributes = DriverManager.getConnection(uri, user, password);
         System.out.println("Database Opens");
         return true;
      } 
      catch (SQLException e) 
      {
         System.out.println("Could not connect to Database " + uri);
         e.printStackTrace();
         System.exit(2);
         return false;
      }
   }

    // Close the database
   public boolean disconnect()
   {
      try 
      {
         if (attributes != null)
         {
            attributes.close();
            System.out.println("Database successfully closed.");
            return true;
         }
         else
         {
            return false; 
         }
      } 
      catch (SQLException sqle) 
      {
         System.out.println("Could not close database");
         sqle.printStackTrace();
         return false;
      }
   }
}