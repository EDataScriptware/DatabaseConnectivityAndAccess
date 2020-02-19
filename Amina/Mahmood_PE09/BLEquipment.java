import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 9
*/
// Create a class equipment in the business layer
public class BLEquipment extends Equipment
{
   // Default Constructor
   public BLEquipment(){}
   
   // Save method
   public boolean save(String access) throws DLException
   {
      boolean result = false;
      // Admin or Editor
      if(access.equals("admin") || access.equals("editor"))
      {
          result = true;     
      }
      return result;
   }
}