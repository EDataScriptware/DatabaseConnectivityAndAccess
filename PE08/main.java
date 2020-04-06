/* 
   Name: Edward Riley
   Professor: Stephen Zilora
   Course: Database Connectivity and Access
   Date: April 05, 2020
*/

import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.io.*;

public class main
{

   public static void main(String[] args) throws DLException
   {
      // Connecting Classes Together
      MySQLDatabase msd = new MySQLDatabase();
      Equipment equipment = new Equipment();
      
      DLUser dlUser = new DLUser("EdwardRiley", "emr9018");
      BLUser blUser = new BLUser("AdminUserName", "AdminPassword");
      BLEquipment blEquip = new BLEquipment();
      
      try
      {
         if(dlUser.login())
         {
            // Success to login in
            System.out.println("Login is successful");
            blEquip.setEquipmentId(568);
            blEquip.fetch();
            
            // Swap
           
            
            if(blUser.login())
            {
               System.out.println("READ/EDIT PERMISSION GRANTED");
               blEquip.swap(894);
               blEquip.fetch();
            }
            else
            {
               System.out.println("The login is either invalid or insufficient privilege");
            }
            
         }
         else
         {
            System.out.println("The login is either invalid or insufficient privilege");
         }
      }
      catch(Exception e)
      { 
         System.out.println("Error:" + e.toString());
      }
   
      
   
   }
   
   


}