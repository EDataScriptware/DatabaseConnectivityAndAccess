import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 7
*/

// Create a class Equipment
class Equipment
{
   // Instance variables
   private int record = 0;
   private int equipmentID, equipmentCapacity;
   private String equipmentName, equipmentDescription;
   private ArrayList<String> errorMessage = new ArrayList<String>();
   
   private MySqlDatabase sql = null;
   
   // Default Constructor 
   public Equipment(){}
   
   // Constructor that accepts and sets the equipmentID
   public Equipment(int _equipmentID){
      equipmentID = _equipmentID;
   } 
   
   // Constructor that accepts and sets all attributes
   public Equipment(int _equipmentID, String _equipmentName, String _equipmentDescription, int _equipmentCapacity){
      equipmentID = _equipmentID;
      equipmentName = _equipmentName;
      equipmentDescription = _equipmentDescription;
      equipmentCapacity = _equipmentCapacity;
   }
   
   // Mutators and accessors 
   public void setEquipmentID(int _equipmentID){
      equipmentID = _equipmentID;
   }
   
   public int getEquipmentID(){
      return equipmentID;
   }
   
   public void setEquipmentName(String _equipmentName){
      equipmentName = _equipmentName;
   }
   
   public String getEquipmentName(){
      return equipmentName;
   }
   
   public void setEquipmentDescription(String _equipmentDescription){
      equipmentDescription = _equipmentDescription;
   }
   
   public String getEquipmentDescription(){
      return equipmentDescription;
   }
   
   public void setEquipmentCapacity(int _equipmentCapacity){
      equipmentCapacity = _equipmentCapacity;
   }
   
   public int getEquipmentCapacity(){
      return equipmentCapacity;
   }
   
   public void setNum(int _record)
   {
      record = _record;
   }
   
   private int getNum()
   {
      return record;
   }
     
   public int getRecord(){
      return this.record;
   }
   
   // Fetch()- Use the object's equipmentId attribute and the Database class
   // Retrieve the database values for that particular equipmentIF and update the objectls attributes
   public void fetch() throws DLException
   {
      // Try and catch statement
      try
      {
         sql = new MySqlDatabase();
         boolean flag = false;
         sql.connect();
         String query = "SELECT * FROM equipment WHERE equipID = ?;";
         ArrayList<String> al = new ArrayList<String>();
         al.add( getEquipmentID() + "");
         ArrayList<ArrayList<String>> myTable = sql.getData(query, al);;
         
         if(myTable.size() != 0)
         {
            if(flag)
            {
               setEquipmentID(Integer.parseInt(myTable.get(1).get(0)));
               setEquipmentName( myTable.get(1).get(1) );
               setEquipmentDescription( myTable.get(1).get(2) );
               setEquipmentCapacity( Integer.parseInt(myTable.get(1).get(3)) );
            
               sql.closeConnect();
            }
            else
            {
               setEquipmentID(Integer.parseInt(myTable.get(0).get(0)));
               setEquipmentName( myTable.get(0).get(1) );
               setEquipmentDescription( myTable.get(0).get(2) );
               setEquipmentCapacity( Integer.parseInt(myTable.get(0).get(3)) );
            
               sql.closeConnect();
            }
         }
         else
         {
            System.out.println("No data corresponding to its equipID, " + getEquipmentID() + ", is found");
            sql.closeConnect();
         }
      }
      catch(Exception e)
      {
         errorMessage.add("java.Equipment: Fetch: " + e.getMessage());
         throw new DLException(e,errorMessage); 
      }
      
   }
   
   // Put()- Update the database values, for that object's equipmentIF, using all the object's attribute values
   public void put() throws DLException
   {
      try
      {
         sql = new MySqlDatabase();
         sql.connect();
         // This is pratical exercise 6
//          String query = "Update Equipment SET EquipID = " + getEquipmentID() + ", EquipmentName = '" + getEquipmentName() + "', EquipmentDescription = '"
//                + getEquipmentDescription() + "', EquipmentCapacity = " + getEquipmentCapacity() + " Where EquipID = " + getEquipmentID() + ";";
         String query = "UPDATE equipment SET EquipID = ?, EquipmentName = ?, EquipmentDescription = ?, EquipmentCapacity = ? WHERE EquipID = ?;";
         //record = sql.setData(query);
         
         ArrayList<String> sql2 = new ArrayList<String>();
         sql2.add(getEquipmentID() + "");
         sql2.add(getEquipmentName());
         sql2.add(getEquipmentDescription());
         sql2.add(getEquipmentCapacity() + "");
         sql2.add(getEquipmentID() + "");
          
         if(record > 0)
         {
            this.record = record;
         }
         setNum(sql.setData(query, sql2));
         sql.closeConnect();
      }
      catch(Exception e)
      {
         errorMessage.add("java.Equipment: Put: "+  e.getMessage());
         throw new DLException(e,errorMessage);     
      }
   }
   
   // Post()- Insert the object's attribute values into the database as a new record
   public void post() throws DLException
   { 
      try
      {
         sql.connect();
         //This is pratical exercise 6
//          String query = "INSERT INTO Equipment (EquipID,EquipmentName, EquipmentDescription, EquipmentCapacity)" + " VALUES (" + getEquipmentID() + ", '" +getEquipmentName()+"', '" + 
//             getEquipmentDescription() + "', " + getEquipmentCapacity() + " );";
         String query = "INSERT INTO equipment (EquipID, EquipmentName, EquipmentDescription, EquipmentCapacity) " + " VALUES (?,?,?,?)";
         ArrayList<String> sql2 = new ArrayList<String>();
         sql2.add(getEquipmentID() + "");
         sql2.add(getEquipmentName());
         sql2.add(getEquipmentDescription());
         sql2.add(getEquipmentCapacity() + "");
         
         setNum(sql.setData(query, sql2));
         //record = sql.setData(query);
         sql.closeConnect();
      }
      catch(Exception e)
      {
         errorMessage.add("java.Equipment: Post: "+  e.getMessage());
         throw new DLException(e,errorMessage);     
      }
   }
   
   // Delete()- Remove from the database any data corresponding to the object's equipmentID
   public void delete() throws DLException
   {
      try
      {
         sql.connect();
         //String query = "DELETE FROM Equipment WHERE EquipID1 = " + getEquipmentID() + ";";
         String query = "DELETE FROM Equipment WHERE EquipID = ?";
         ArrayList<String> sql2 = new ArrayList<String>();
         sql2.add(getEquipmentID() + "");
         setNum(sql.setData(query, sql2));
         //record = sql.setData(query);
            
         sql.closeConnect();
      }
      catch(Exception e)
      {
         errorMessage.add("java.Equipment: Delete: "+  e.getMessage());
         throw new DLException(e,errorMessage);     
      }
   }
   
   public String toString()
   {
      String output =  "EquipID: " + getEquipmentID() + "\nEquipmentName: " + getEquipmentName()
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