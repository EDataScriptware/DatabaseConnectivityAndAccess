import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.Date;
import java.util.Calendar; 
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 10
*/
public class Database 
{     
   public static void main(String[] args)
   {
      try
      {
         Account acc = new Account();
         AccountHolder accH = new AccountHolder();
//          Statement stmnt = conn.createStatement();
//          String query = "SELECT * FROM account";
//          ResultSet rs = stmnt.executeQuery(query);
//          ResultSetMetaData rsmd = rs.getMetaData();
//          int columnNum = rsmd.getColumnCount();
         
         Date cal = Calendar.getInstance().getTime();
         
         System.out.println("Filename: Account \nBy: Amina Mahmood " + cal);
         System.out.println(acc.toString());
         System.out.println(accH.toString());
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}