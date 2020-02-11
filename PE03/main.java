import java.sql.*;
import javax.sql.*;
import java.util.*;

public class main
{
   // Connecting Classes Together
   static MySQLDatabase msd = new MySQLDatabase();
   static Equipment equipment = new Equipment();
   
   public static void main(String[] args) 
   {
   
      Connection connection = msd.connect();
      msd.close(connection);
      
      
      
      

   }
   
   


}