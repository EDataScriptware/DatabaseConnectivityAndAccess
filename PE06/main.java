/* 
   Name: Edward Riley
   Professor: Stephen Zilora
   Course: Database Connectivity and Access
   Date: March 27, 2020
*/

import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.io.*;

public class main
{

   public static void main(String[] args) throws DLException
   {
      // Edward's Note for TA: The wall of text together is difficult to read together henceforth Step #3a-#3e

      // Connecting Classes Together
      MySQLDatabase msd = new MySQLDatabase();
      Equipment equipment = new Equipment();
      int aEquipmentID = 568;
      int bEquipmentID = 894;
   
      // Equipment A
      System.out.println( "\nRunning Class Equipment A..." );
            
      
      // Step #3a
      Equipment equipmentA = new Equipment(aEquipmentID); 
      
      // Step #3b
      equipmentA.fetch();  
      System.out.println(equipmentA.toString());
      
      // Step #3c
      equipmentA.swap(bEquipmentID);  
      equipmentA.setEquipmentId(aEquipmentID);
      
      // Step #3d
      equipmentA.fetch();
      System.out.println(equipmentA.toString());
      
      // Step #3e       
      Equipment equipmentB = new Equipment(bEquipmentID); 
      equipmentB.fetch();  
      System.out.println(equipmentB.toString());
      equipmentB.swap(aEquipmentID); // using equipmentA equipmentID
      equipmentB.setEquipmentId(bEquipmentID);
      equipmentB.fetch();
      System.out.println(equipmentB.toString());
   
   }
   
   


}