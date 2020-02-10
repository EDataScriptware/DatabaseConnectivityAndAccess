import java.sql.*;
import javax.sql.*;
import java.util.*;

public class main
{
   static MySQLDatabase msd = new MySQLDatabase();
   
   public static void main(String[] args) 
   {
   
      Connection connection = msd.connect();
      msd.close(connection);
      
      
      
      

   }
   
   


}