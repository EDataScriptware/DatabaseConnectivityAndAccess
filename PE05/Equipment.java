/* 
   Name: Edward Riley
   Professor: Stephen Zilora
   Course: Database Connectivity and Access
   Date: Feburary 26, 2020
*/

import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.io.*;


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
   
   // equipment full constructor
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
   
   
   // fetch method - retrieves the data
   public void fetch() throws DLException
   {
      
      Connection connection = msd.connect();
      msd.setConnection(connection);
      String query = "SELECT * FROM equipment WHERE equipID = " + getEquipmentId() + ";";
      ArrayList<ArrayList<String>> twoDimensionalArray = twoDimensionalArray = msd.getData(query, 4);
      
      if (twoDimensionalArray.size() != 0)
      {
         setEquipmentId(Integer.parseInt(twoDimensionalArray.get(0).get(0)));
         setEquipmentName(twoDimensionalArray.get(0).get(1));
         setEquipmentDescription(twoDimensionalArray.get(0).get(2));
         setEquipmentCapacity(Integer.parseInt(twoDimensionalArray.get(0).get(3)));
      }
   
   
   } // end fetch
   
   public void put() throws DLException // put method - changes the data
   {
      Connection connection = msd.connect();
      String query = "Update Equipment SET EquipID = " + getEquipmentId() + ", EquipmentName = '" + getEquipmentName() + "', EquipmentDescription = '" + getEquipmentDescription() + "', EquipmentCapacity = " + getEquipmentCapacity() + " Where EquipID = " + getEquipmentId() + ";";
               
      record = msd.setData(query);
            
      if(record > 0)
      {
         this.record = record;
      }
      
      // msd.close(connection);
   
   } // end put   

   public void post() throws DLException // post method - inserts the data
   { 
      Connection connection = msd.connect();
      String query = "INSERT INTO Equipment (EquipID, EquipmentName, EquipmentDescription, EquipmentCapacity)" + " VALUES (" + getEquipmentId() + ", '" +getEquipmentName()+"', '" + getEquipmentDescription() + "', " + getEquipmentCapacity() + " );";
          
      record = msd.setData(query);
      
     // msd.close(connection);
   } // end post
   
   public void delete() throws DLException // delete method - deletes the data
   {
      Connection connection = msd.connect();
      String query = "DELETE FROM Equipment WHERE EquipID = " + getEquipmentId() + ";";
      record = msd.setData(query);
            
     // msd.close(connection);
   } // end delete
   
   /* Presentation Layer(?) */
   public String toString()
   {
      String message =  "Equipment: " + getEquipmentId();
      message += "\nEquipment Name: " + getEquipmentName();
      message += "\nEquipment Description: " + getEquipmentDescription();
      message += "\nEquipment Capacity: " + getEquipmentCapacity();
      message += "\n\n" + getRecord() + " rows affected\n";
      
      record = 0;
   
      return message;
   }
   
   public String numToString()
   {
      
      String message =  "/n/n" + getRecord() + " rows affected\n";
      
      record = 0;
      return message;
      
   }
   
   // Retrieving the equipment attributes
   public void fetchAttritubes() throws DLException {
      MySQLDatabase SQL = new MySQLDatabase();
      Connection connection = msd.connect();
      SQL.getData("SELECT * FROM equipment WHERE EquipID = " + getEquipmentId());
      System.out.println("\n");
      msd.close(connection); 
   }
   
      // Retrieving the equipment attributes
   public void fetchAttritubesError() throws DLException {
      MySQLDatabase SQL = new MySQLDatabase();
      Connection connection = msd.connect();
      SQL.getData("SELECT * FROM equipment WHERE EquipIDs = " + getEquipmentId());
      System.out.println("\n");
      msd.close(connection); 
   }
   
     // Retrieving the equipment attributes
   public void fetchAllAttritubes() throws DLException{
      MySQLDatabase SQL = new MySQLDatabase();
      Connection connection = msd.connect();
      SQL.getData("SELECT * FROM equipment");
      System.out.println("\n");
      msd.close(connection); 
   }


}