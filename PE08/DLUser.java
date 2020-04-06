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

// Create a class data layer
public class DLUser
{
   // Instance variables
   private String userName, password, name, access;
   private Connection conn = null;
   private Statement stmt;
   private ResultSet rs;
   private PreparedStatement ps; 
   private String userNameDB = "";
   private String passDB = "";
   private String nameDB = "";
   private String accessDB = "";
   Connection connection = null;
   
   static String hostMySQL = "jdbc:mysql://localhost/travel2?";
   
   MySQLDatabase msd = new MySQLDatabase();
   BLEquipment equip = new BLEquipment();
   
   // Default Constructor
   public DLUser(){}
   
   public DLUser(String _username, String _password)
   {
      userName = _username;
      password = _password;
      //msd = new MySQLDatabase(hostMySQL);
   }
   
 
   public boolean login() throws DLException{
      boolean result = false;
      try
      {
         connection = msd.connect();
         String query = "SELECT * FROM users WHERE userName = ?";
         ArrayList<String> sql = new ArrayList<String>();
         sql.add(userName);

         ps = msd.prepare(query, sql);
         rs = ps.executeQuery();
         
         
         while(rs.next())
         {
            userNameDB = rs.getString(1);
            passDB = rs.getString(2);
            nameDB = rs.getString(3);
            accessDB = rs.getString(4);
         }
         
         System.out.println(userNameDB);
         System.out.println(passDB);
      
         
         if((userNameDB.equals(userName)) && (passDB.equals(password)))
         {
            result = true;
            if(equip.save(access))
            {
               result = true;
            }
         }
         msd.close(connection);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return result;
   }
   
   public void setUserName(String _userName){
      userName = _userName;      
   }
   
   public void setPassword(String _password){
      password = _password;      
   }
   
   public void setName(String _name){
      name = _name;      
   }
   
   public void setAccess(String _access){
      access = _access;
   }
   
   public String getUserName(){
      return userName;
   }
   
   public String getPassword(){
      return password;
   }
   
   public String getName(String _name){
      return name;
   }
   
   public String getAccess(){
      return access;
   }
   
}