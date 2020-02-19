import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floser
   *Database Connectivity and Access
*/

class Equipment
{
   // Instance variables
   private int equipmentID, equipmentCapacity;
   private String equipmentName, equipmentDescription;
   int record = 0;
   
   MySqlDatabase sql = new MySqlDatabase();
   
   // Default Constructor 
   public Equipment()
   {
   
   }
   
   // Constructor that accepts and sets the equipmentID
   public Equipment(int _equipmentID)
   {
      equipmentID = _equipmentID;
   } 
   
   // Constructor that accepts and sets all attributes
   public Equipment(int _equipmentID, String _equipmentName, String _equipmentDescription, int _equipmentCapacity)
   {
      equipmentID = _equipmentID;
      equipmentName = _equipmentName;
      equipmentDescription = _equipmentDescription;
      equipmentCapacity = _equipmentCapacity;
   }
   
   // Mutators and accessors 
   public void setEquipmentID(int _equipmentID)
   {
      equipmentID = _equipmentID;
   }
   
   public int getEquipmentID()
   {
      return equipmentID;
   }
   
   public void setEquipmentName(String _equipmentName)
   {
      equipmentName = _equipmentName;
   }
   
   public String getEquipmentName()
   {
      return equipmentName;
   }
   
   public void setEquipmentDescription(String _equipmentDescription)
   {
      equipmentDescription = _equipmentDescription;
   }
   
   public String getEquipmentDescription()
   {
      return equipmentDescription;
   }
   
   public void setEquipmentCapacity(int _equipmentCapacity)
   {
      equipmentCapacity = _equipmentCapacity;
   }
   
   public int getEquipmentCapacity()
   {
      return equipmentCapacity;
   }
   
   public int getRecord()
   {
      return this.record;
   }
   
   // Fetch()- Use the object's equipmentId attribute and the Database class
   // Retrieve the database values for that particular equipmentIF and update the objectls attributes
   public void fetch()
   {
      
      sql.connect();
      String query = "SELECT * FROM equipment WHERE equipID = " + getEquipmentID() + ";";
      ArrayList<ArrayList<String>> myTable = myTable = sql.getData(query,4);;
         
      if(myTable.size() != 0)
      {
         setEquipmentID(Integer.parseInt(myTable.get(0).get(0)));
         System.out.println(Integer.parseInt(myTable.get(0).get(0)));
         setEquipmentName( myTable.get(0).get(1) );
         setEquipmentDescription( myTable.get(0).get(2) );
         setEquipmentCapacity( Integer.parseInt(myTable.get(0).get(3)) );
         
         sql.closeConnect();
      }
      else
      {
         System.out.println("No data corresponding to its equipID, " + getEquipmentID() + ", is found");
         sql.closeConnect();
      }
      
   }
   
   // Put()- Update the database values, for that object's equipmentIF, using all the object's attribute values
   public void put()
   {
      sql.connect();
      String query = "Update Equipment SET EquipID = " + getEquipmentID() + ", EquipmentName = '" + getEquipmentName() + "', EquipmentDescription = '"
               + getEquipmentDescription() + "', EquipmentCapacity = " + getEquipmentCapacity() + " Where EquipID = " + getEquipmentID() + ";";
               
      record = sql.setData(query);
            
      if(record > 0)
      {
         this.record = record;
      }
      sql.closeConnect();
   }
   
   // Post()- Insert the object's attribute values into the database as a new record
   public void post()
   { 
      sql.connect();
      String query = "INSERT INTO Equipment (EquipID,EquipmentName, EquipmentDescription, EquipmentCapacity)" + " VALUES (" + getEquipmentID() + ", '" +getEquipmentName()+"', '" + 
         getEquipmentDescription() + "', " + getEquipmentCapacity() + " );";
          
      record = sql.setData(query);
      sql.closeConnect();
   }
   
   // Delete()- Remove from the database any data corresponding to the object's equipmentID
   public void delete()
   {
      sql.connect();
      String query = "DELETE FROM Equipment WHERE EquipID = " + getEquipmentID() + ";";
      record = sql.setData(query);
            
      sql.closeConnect();
   }
   
   public String toString()
   {
      String output =  "equipID: " + getEquipmentID() + "\nEquipmentName: " + getEquipmentName()
         + "\nEquipmentDescription: " + getEquipmentDescription() + "\nEquipmentCapacity: " + getEquipmentCapacity()
         + "\n---------------------\n" + getRecord() + " row(s) affected\n";
      this.record = 0;
   
      return output;
   }
   
   public String toStringOnlyNum()
   {
      
      String output =  "---------------------\n" + getRecord() + " row(s) affected\n";
      this.record = 0;
      return output;
      
   }
}