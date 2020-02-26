/* 
   Name: Edward Riley
   Professor: Stephen Zilora
   Course: Database Connectivity and Access
   Date: Feburary 21, 2020
*/

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
   
      // Equipment A
      System.out.println( "\nRunning Class Equipment A..." );
      Equipment equipmentA = new Equipment(568); 
      equipmentA.fetch();  
      System.out.println(equipmentA.toString());
   
      // Equipment B
      System.out.println( "\nRunning Class Equipment B..." );
      Equipment equipmentB = new Equipment(894); 
      equipmentB.fetch();  
      System.out.println(equipmentB.toString());
      
      // Fetches the attributes from metadata
      equipmentA.fetchAttritubes(); 
      equipmentB.fetchAttritubes(); 
      equipment.fetchAllAttritubes();
      
   }
   
   


}