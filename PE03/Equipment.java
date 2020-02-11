import java.sql.*;
import javax.sql.*;
import java.util.*;


public class Equipment
{
   // Connecting Classes Together
   static MySQLDatabase msd = new MySQLDatabase();
   static main m = new main();
   
   // Initialized variables
   int equipmentId = 0;
   int equipmentCapacity = 0;
   int row = 0;

   String equipmentName = "";
   String equipmentDescription = "";
   
   // Default constructor
   public Equipment()
   {
      
   }
   
   // equipmentId constructor
   public Equipment(int _equipmentId)
   {
      equipmentId = _equipmentId;
   }
   
   public Equipment(int _equipmentId, int _equipmentCapacity, String _equipmentName, String _equipmentDescription)
   {
      equipmentId = _equipmentId;
      equipmentCapacity = _equipmentCapacity;
      equipmentName = _equipmentName;
      equipmentDescription = _equipmentDescription;
   }
   
   // Accessors and Mutators

}