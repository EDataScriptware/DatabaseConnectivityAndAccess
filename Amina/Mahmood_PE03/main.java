import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
*/

public class main
{
   public static void main(String[] args)
   {
      MySqlDatabase mySQL = new MySqlDatabase();
      
      // A. Instantlates the equipmemt class, set its equipment'ID,
      // calls the fetch method, and then displays the values
      
      // FINDS THE DATA BASED ON ID NUMBER
      System.out.println( "\nRunning Class Equipment..." );
      Equipment equip = new Equipment( 568 ); 
      equip.fetch();  
      System.out.println("Instantlates the equipment class, set equipmentID, call the fetch method, and display the values " + equip.toString());
      
      // B. Create a new class with new own attributes, use post(), and print out how many records were inserted. 
      
      // CREATES A NEW DATA ASSIGNED BY NAME ID
      int _equipmentID = 5;
      String _equipmentName = "NewEquipmentName";
      String _equipmentDescription = "Generation4";
      int _equipmentCapacity = 500;
      Equipment equip2 = new Equipment(_equipmentID, _equipmentName, _equipmentDescription, _equipmentCapacity);
      equip2.post();
      System.out.println("\nMake a new class with new own attibutes, use post(), and print out how many records " + equip2.toString());
      
      // C. Use mutators to change the equipment capacity attibute, use put(), then print out how many records were inserted.
      
     // CHANGES THE DATA
      equip2.setEquipmentCapacity(50000);
      equip2.put();
      System.out.println("\nUse mutators to change the equipment capacity attibute, use put(), then print out how many records " + equip2.getRecord());
      
      // D. Use the fetch method and display the inserted information to the user
      
      // FInDS DATA AND SHOWS INSERTED DATA FROM LAST DATA CHANGED
      equip2.fetch();
      System.out.println("\nUse the fetch method and display the inserted information\n" + equip2.toStringOnlyNum());
      
      // E. Use the delete method to remove the record the database and print out how many records were deleted.
      
      // DELETES THE DATA FROM THE LAST DATA CHANGED
      equip2.delete();
      System.out.println("\nUse the delete method to remove the record the database and print out how many records\n" + equip2.toStringOnlyNum());
      
      // F. Use the fetch method for this equipmentID to show a user-friendly message when no data is retrieved
      System.out.println("\nUse the fetch method for this equipmentID to show a user-friendly message when no data is retrieved. \n");
      equip2.fetch();
      System.out.println( equip2.toStringOnlyNum() );
      
      System.out.println("\n\nDone");
   }
}