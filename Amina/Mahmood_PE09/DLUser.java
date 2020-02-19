import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 9
*/
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
   
   private MySqlDatabase mysql = null;
   private String uri = "jdbc:mysql://localhost/travel2?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   
   MySqlDatabase sqlDB = new MySqlDatabase();
   BLEquipment equip = new BLEquipment();
   
   // Default Constructor
   public DLUser(){}
   
   public DLUser(String _username, String _password)
   {
      userName = _username;
      password = _password;
      mysql = new MySqlDatabase(uri);
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
   
   public boolean login() throws DLException{
      boolean result = false;
      try
      {
         sqlDB.connect();
         String query = "SELECT * FROM users WHERE userName = ?";
         ArrayList<String> sql = new ArrayList<String>();
         sql.add(this.userName);
         ps = sqlDB.prepare(query, sql);
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
         sqlDB.closeConnect();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return result;
   }
}