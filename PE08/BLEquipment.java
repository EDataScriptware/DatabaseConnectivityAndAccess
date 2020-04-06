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
   PreparedStatement ps = null;
   ResultSet rs = null;
   Connection connection = null;
   
   String userNameDatabase;
   String passwordDatabase;
   String nameDatabase;
   String accessDatabase;
   String userName;
   String password;
   
   
   
   // Default Constructor
   public BLEquipment(){}
   
   
   
   // Save method
   public boolean save(String access) throws DLException
   {
      boolean result = false;
      // Admin or Editor
      if(access == "admin" || access == "editor")
      {
          result = true;     
      }
      return result;
   }
   
   public boolean login() throws DLException{
      boolean result = false;
      try
      {  String access = "";
         connection = msd.connect();
         String query = "SELECT * FROM users WHERE userName = ?";
         
         ArrayList<String> list = new ArrayList<String>();
         list.add(userName);
         
         ps = msd.prepare(query, list);
         rs = ps.executeQuery();
         
         
         while(rs.next())
         {
            userNameDatabase = rs.getString(1);
            passwordDatabase = rs.getString(2);
            nameDatabase = rs.getString(3);
            accessDatabase = rs.getString(4);
         }
         
         System.out.println(userNameDatabase);
         System.out.println(passwordDatabase);
      
         
         if((userNameDatabase.equals(userName)) && (passwordDatabase.equals(password)))
         {
            result = true;
            if(save(access))
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
   

}