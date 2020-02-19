/***
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
***/
import java.sql.*;

public class Main
{
   public static void main(String[] args)
   {
      System.out.println("MY SQL Database is running...");
      MySQLDatabase mySQLDB = new MySQLDatabase();
      
      System.out.println("SQL Server Database is running...");
      SQLServerDatabase SQLDB = new SQLServerDatabase();
   }
}