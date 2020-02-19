import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
*/

// Main class
public class main
{
   public static void main(String[] args) throws DLException
   {
      // Try and catch statment
      try
      {
         MySqlDatabase db = new MySqlDatabase();
         db.connect();
         db.descTable("SELECT * FROM equipment");
         db.descTable("SELECT equipmentName, equipmentDescription FROM equipment");
         db.closeConnect();
      }
      catch(DLException sqle)
      {
         System.out.println(sqle.getMessage());
         System.out.println("Error: an exception occurs during runtime operation!");
      }
   }
}