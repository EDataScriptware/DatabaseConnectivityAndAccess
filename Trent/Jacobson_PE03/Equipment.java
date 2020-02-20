// Name: Trent Douglas Jacobson

import java.sql.*;
import javax.sql.*;
import java.util.ArrayList;

public class Equipment {

   // This provides attributes that mirror the Equipment table
   private static int EquipID = 0;
   private static int EquipmentCapacity = 0;
   private static String EquipmentDescription = null;
   private static String EquipmentName = null;
   private static int record = 0;
   public static int number = 1256;
   
   static MySQLDatabase MySQL = new MySQLDatabase();
   Main main = new Main();
   
   public Equipment() {
    // This is the default constructor
   }
   
   public void Equipment(int _EquipID) {
      EquipID = _EquipID; // This provides a constructor that accepts and sets the equipmentId
   }    
   
   
   public static void main(String[] args) {
    // Runs something here
   }
  

   public void Equipment(int _EquipID, String _EquipmentDescription, String _EquipmentName, int _EquipmentCapacity) {
      EquipID = _EquipID;
      EquipmentCapacity = _EquipmentCapacity;
      EquipmentDescription = _EquipmentDescription;
      EquipmentName = _EquipmentName;
      // Provide a constructor that accepts and sets all attributes
   }
    
   public static void setEquipmentID(int _EquipID)
   {
      EquipID = _EquipID;
   }
   
   public static int getEquipmentID()
   {
      return EquipID;
   }
   
   public static void setEquipmentCapacity(int _EquipmentCapacity)
   {
      EquipmentCapacity = _EquipmentCapacity;
   }
   
   public static int getEquipmentCapacity()
   {
      return EquipmentCapacity;
   }
   
   public static void setEquipmentDescription(String _EquipmentDescription)
   {
      EquipmentDescription = _EquipmentDescription;
   }
   
   public static String getEquipmentDescription()
   {
      return EquipmentDescription;
   }
   
   public static void setEquipmentName(String _EquipmentName)
   {
      EquipmentName = _EquipmentName;
   }
   
   public static String getEquipmentName(){
      return EquipmentName;
   }
   
   public static void setRecord(int _record){
      record = _record;
   }
   
   public static int getRecord(){
      return record;
   }

   public void fetch() {
    
   
      boolean connection = MySQL.connect();

      String data = "SELECT * FROM equipment WHERE equipID = " + getEquipmentID() + ";";
      ArrayList<ArrayList<String>> array = array = MySQL.getData(data, 4);
      
      if (array.size() != 0) {
         setEquipmentID(Integer.parseInt(array.get(0).get(0)));
         setEquipmentName(array.get(0).get(1));
         setEquipmentDescription(array.get(0).get(2));
         setEquipmentCapacity(Integer.parseInt(array.get(0).get(3)));
      }
   } 
   
   public int put() {
      MySQLDatabase MySQL = new MySQLDatabase();
      boolean connection = MySQL.connect();
      int result = MySQL.setData("UPDATE Equipment SET EquipID = " + getEquipmentID() + ", EquipmentName = '" + getEquipmentName() + "', EquipmentDescription = '" + getEquipmentDescription() + "', EquipmentCapacity = " + getEquipmentCapacity() + "Where EquipID = " + getEquipmentID() + ";");
            
      if(record > 0) {
         record = record;
      }
      return -result;
   } 
   
   public int post() {
      MySQLDatabase MySQL = new MySQLDatabase();
      boolean connection = MySQL.connect();
      int result = MySQL.setData("INSERT INTO Equipment (EquipID, EquipmentName, EquipmentDescription, EquipmentCapacity)" + " VALUES (" + getEquipmentID() + ", '" + getEquipmentName()+"', '" + getEquipmentDescription() + "', " + getEquipmentCapacity() + " );");
      return result;
   }
   
  public static void delete() {
      boolean connection = MySQL.connect();
      String query = "DELETE FROM Equipment WHERE EquipID = " + getEquipmentID() + ";";
      record = MySQL.setData(query);
      setRecord(record);        
   } 
   
   // Retrieving the equipment attributes
   public static void attritubes() {
      MySQLDatabase SQL = new MySQLDatabase();
      SQL.connect();
      SQL.getData("SELECT EquipID, EquipmentName FROM equipment WHERE EquipID = 1256");
      System.out.println("\n");
      SQL.close(); 
   }
   
   
  public String recordDeleted() {
      String message =  "Records were deleted: " + getRecord();
      this.record = 0;
      return message; 
   }
   
  public static String getSummarizedMessage() {
         String summarizedMessage = "EquipmentID: " + getEquipmentID() + "\n"; 
         summarizedMessage += "EquipmentName: " + getEquipmentName() + "\n"; 
         summarizedMessage += "EquipmentCapacity: " + getEquipmentDescription() + "\n"; 
         summarizedMessage += "EquipmentDesc: " + getEquipmentCapacity() + "\n"; 
      
      return summarizedMessage;
  } 
  
  
}