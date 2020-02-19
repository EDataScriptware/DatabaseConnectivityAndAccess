import java.sql.*;
import java.util.*;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 10
*/
public class Account 
{
   private int accountId;
   private int ownerId;
   private char accountType;
   private double amount;
   private SQLServerDatabase server = null;
   
   private DatabaseMetaData db;
   
   public Account()
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
   
   public int accountId()
   {
      return accountId;
   }
   
   public int ownerId()
   {
      return ownerId;
   }
   
   public char accountType()
   {
      return accountType;
   }
   
   public double amount()
   {
      return amount;
   }
   
   public String toString()
   {
      String output = "Account id: " + accountId() + "\nowner id: " + ownerId() + "\nAccount Type: " + accountType() + "\nAmount: " + amount();
      return output;
   }
}