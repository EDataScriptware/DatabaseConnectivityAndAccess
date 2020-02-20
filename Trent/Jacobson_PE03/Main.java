// Name: Trent Douglas Jacobson

import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;

public class Main {

   public static void main(String[] args) {      
   
      // Show the data information by selecting 894 from database
      Equipment equipmentA = new Equipment();
      equipmentA.setEquipmentID(894);
      equipmentA.fetch();
      System.out.println(equipmentA.getSummarizedMessage());
       
      // New equipment and then inserted
      Equipment equipment2 = new Equipment();
      equipment2.setEquipmentID(55);
      equipment2.setEquipmentName("TrentTrain");
      equipment2.setEquipmentDescription("Relax");
      equipment2.setEquipmentCapacity(40);
      
      
      int data = equipment2.post();
      System.out.println("Records were inserted: " + data);
      System.out.println("\n");
      
      
      // To show the number of records that are updated
      equipment2.setEquipmentCapacity(8);
      data = equipment2.put();
      System.out.println("Records were updated: " + data);
      System.out.println("\n");
      
      // To display the inserted information to the user
      equipment2.fetch();
      System.out.println(equipment2.getSummarizedMessage());
      
      // Display the number of Records that are deleted
      equipment2.post();
      equipment2.delete();
      System.out.println(equipment2.recordDeleted());
      System.out.println("\n");
      
      // Display the metadata
      
      Equipment Databse = new Equipment();
      Databse.attritubes();
      

      
      // Fetch 
      try{
         equipment2.fetch();
      }
      catch(Exception error) {
         System.out.println("NO DATA FOUND! " + error);
      }
   }
}