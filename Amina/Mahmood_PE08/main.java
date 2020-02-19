import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 8
*/

// Create a main class
public class main
{
   public static void main(String[] args) throws DLException
   {
      // Try and catch statment
      try
      {
         // Instantiate the equipment data, set the objects equipmentid,
         // call the fetch method, and display the value
         Equipment equipment = new Equipment();
         
         // Orginal 
         equipment.setEquipmentID(568);
         equipment.fetch();
         System.out.println("Orginal:\n" + equipment.toString());
         
         // First
         equipment.swap(8596);
         equipment.setEquipmentID(568);
         equipment.fetch();
         System.out.println("First ID:\n" + equipment.toString());
         
         // Second
         equipment.setEquipmentID(8596);
         equipment.fetch();
         System.out.println("Second ID:\n" + equipment.toString());
        
         // Instantiate another equipment data, set the objects equipmentid,
         // call the fetch method, and display the original value 
         Equipment equipment2 = new Equipment();
         equipment2.setEquipmentID(8596);
         equipment2.fetch();
         equipment2.swap(568);
         equipment2.fetch();
         System.out.println("Reverse Swap:\n" + equipment2.toString());
      }
      catch(DLException sqle)
      {
         System.out.println(sqle.getMessage());
         System.out.println("Error: an exception occurs during runtime operation!");
      }
   }
}