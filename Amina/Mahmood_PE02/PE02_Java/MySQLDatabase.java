/***
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
***/
import java.sql.*;

public class MySQLDatabase
{
      // Definitions for MySQL connection
      String uri = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
      String driver = "com.mysql.cj.jdbc.Driver";
      String user = "root";
      String password ="student";
      
      Connection attributes2 = null;
      
      public MySQLDatabase()
      {
         // Loading driver
         try
         {
            Class.forName(driver);
            System.out.println("Driver loaded.");
         }
         catch( ClassNotFoundException ce )
         {
            System.out.println("Could not load a driver " + driver);
            ce.printStackTrace();
            System.exit(1);
         }

         // Connects and opens Database
         if( connect() == false )
         {
            System.exit(2);
         }

        // Close Database and close connection
         if( closeConnect() == false )
         {
            System.exit(3);
         }
      }
      
      // Connect method
      public boolean connect()
      {
         try 
         {
            attributes2 = DriverManager.getConnection(uri, user, password);
            System.out.println("Database Opens");
            return true;
        } 
        catch (SQLException e) 
        {
            System.out.println("Could not connect to Database " + uri);
            e.printStackTrace();
            return false;
        }
      }
      
      // Close the database
      public boolean closeConnect()
      {
        try 
        {
            if (attributes2 != null) 
            {
                attributes2.close();
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