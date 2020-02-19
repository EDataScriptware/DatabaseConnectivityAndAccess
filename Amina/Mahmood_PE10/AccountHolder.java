import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 10
*/
public class AccountHolder
{
   private int ownerId;
   private String accountOwner;
   
   private DatabaseMetaData db;
   private SQLServerDatabase server = null;
   
   public AccountHolder()
   {
      server = new SQLServerDatabase();
   }
   
   public ResultSet Database()
   {
      try
      {
         return db.getCatalogs();
      }
      catch(Exception e)
      {
         return null;
      }
   }
   
   public int ownerId()
   {
      return ownerId;
   }
   
   public String accountOwner()
   {
      return accountOwner;
   }
   
   public String toString()
   {
      String output = "Owner id: " + ownerId() + "Account Owner: " + accountOwner();
      return output;
   }
}