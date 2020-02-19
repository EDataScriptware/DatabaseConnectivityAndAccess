import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 7
*/

// Create a main class
public class main
{
   public static void main(String[] args) throws DLException
   {
      // Try and catch statment
      try
      {
        Equipment equipment = new Equipment();
        equipment.setEquipmentID(568);
        equipment.fetch();
        System.out.println(equipment.toString());
        equipment.put();
        equipment.fetch();
        System.out.println(equipment.toString());
      }
      catch(DLException sqle)
      {
         System.out.println(sqle.getMessage());
         System.out.println("Error: an exception occurs during runtime operation!");
      }
   }
}