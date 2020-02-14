import java.sql.*;
import javax.sql.*;
import java.util.*;

public class main
{

   public static void main(String[] args) 
   {
      // Connecting Classes Together
      MySQLDatabase msd = new MySQLDatabase();
      Equipment equipment = new Equipment();

      // FINDS THE DATA BASED ON ID NUMBER
      System.out.println( "\nRunning Class Equipment..." );
      Equipment equipmentA = new Equipment(568); 
      equipmentA.fetch();  
      System.out.println(equipmentA.toString());
      
      // CREATES A NEW DATA ASSIGNED BY NAME ID
      int _equipmentID = 7;
      String _equipmentName = "RileyEquipment";
      String _equipmentDescription = "RileyDesc";
      int _equipmentCapacity = 500;
      
      Equipment equipmentB = new Equipment(_equipmentID, _equipmentCapacity, _equipmentName, _equipmentDescription);
      equipmentB.post();
      System.out.println(equipmentB.toString());
      
      // ALTERS THE DATA
      equipmentB.setEquipmentCapacity(501);
      equipmentB.put();
      System.out.println("Altering the equipment capacity of EquipID:" + equipmentB.getEquipmentId() +  " to " + equipmentB.getEquipmentCapacity());
      System.out.println(equipmentB.getRecord() + " row(s) affected");
    
      
      //Checking to see if file is there.
      equipmentB.fetch();
      System.out.println(equipmentB.toString());
      
      
      // DELETES THE DATA
      equipmentB.delete();
      
      // Checking to see if file is there with friendly message
      equipmentB.fetch();
      System.out.println(equipmentB.numToString());
      
      
      
      

   }
   
   


}