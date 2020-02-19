import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 9
*/
// Create a class main
public class main
{
   // Main method
   public static void main(String[] args)
   {
      DLUser dlUser = new DLUser("SakuraAmy", "CrazyMeme10");
      BLUser blUser = new BLUser("CoolProfessor", "TeethFlosser");
      BLEquipment blEquip = new BLEquipment();
      
      try
      {
         if(dlUser.login())
         {
            // Success to login in
            System.out.println("Login in is successful");
            blEquip.setEquipmentID(568);
            blEquip.fetch();
            
            // Swap
            if(blUser.login())
            {
               System.out.println("Admin will allow and give a permission to general user to swap");
               blEquip.swap(894);
               blEquip.fetch();
            }
            else
            {
               System.out.println("Admin doesn't allow and give a permission to swap");
            }
         }
         else
         {
            System.out.println("The login is incorrect or not allow to access without Admin");
         }
      }
      catch(Exception e)
      { 
         e.printStackTrace();
      }
   }
}