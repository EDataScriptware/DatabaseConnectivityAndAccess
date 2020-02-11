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
   int record = 0;

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
   public int getEquipmentId()
   {
      return equipmentId; 
   }
   
   public void setEquipmentId(int _equipmentId)
   {
      equipmentId = _equipmentId;
   }
   
   public int getEquipmentCapacity()
   {
      return equipmentCapacity;
   }
   
   public void setEquipmentCapacity(int _equipmentCapacity)
   {
      equipmentCapacity = _equipmentCapacity;
   }
   
   public String getEquipmentName()
   {
      return equipmentName;
   }
   
   public void setEquipmentName(String _equipmentName)
   {
      equipmentName = _equipmentName;
   }
   
   public String getEquipmentDescription()
   {
      return equipmentDescription;
   }
   
   public void setEquipmentDescription(String _equipmentDescription)
   {
      equipmentDescription = _equipmentDescription;
   }
   
   public int getRecord()
   {
      return record;
   }
   
   public void fetch()
   {
      Connection connection = msd.connect();
      String query = "SELECT * FROM equipment WHERE equipID = " + getEquipmentId() + ";";
      ArrayList<ArrayList<String>> twoDimensionalArray = twoDimensionalArray = msd.getData(query, 4);;
      
      if (twoDimensionalArray.size() != 0)
      {
         setEquipmentId(Integer.parseInt(twoDimensionalArray.get(0).get(0)));
         System.out.println(Integer.parseInt(twoDimensionalArray.get(0).get(0)));
         setEquipmentName(twoDimensionalArray.get(0).get(1));
         setEquipmentDescription(twoDimensionalArray.get(0).get(2));
         setEquipmentCapacity(Integer.parseInt(twoDimensionalArray.get(0).get(3)));
         
         msd.close(connection);
      }


   } // end fetch
   
   public void put()
   {
      Connection connection = msd.connect();
      String query = "Update Equipment SET EquipID = " + getEquipmentId() + ", EquipmentName = '" + getEquipmentName() + "', EquipmentDescription = '" + getEquipmentDescription() + "', EquipmentCapacity = " + getEquipmentCapacity() + " Where EquipID = " + getEquipmentId() + ";";
               
      record = msd.setData(query);
            
      if(record > 0)
      {
         this.record = record;
      }
      
      msd.close(connection);
   
   } // end put   

   public void post()
   { 
      Connection connection = msd.connect();
      String query = "INSERT INTO Equipment (EquipID,EquipmentName, EquipmentDescription, EquipmentCapacity)" + " VALUES (" + getEquipmentId() + ", '" +getEquipmentName()+"', '" + getEquipmentDescription() + "', " + getEquipmentCapacity() + " );";
          
      record = msd.setData(query);
      msd.close(connection);
   } // end post
   
   public void delete()
   {
      Connection connection = msd.connect();
      String query = "DELETE FROM Equipment WHERE EquipID = " + getEquipmentId() + ";";
      record = msd.setData(query);
            
      msd.close(connection);
   }

}