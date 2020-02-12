import java.sql.*;
import javax.sql.*;
import java.util.*;

public class main
{

   public static void main(String[] args) 
   {
      // Connecting Classes Together
      MySQLDatabase msd = new MySQLDatabase();
      Equipment equipment = new Equipment();

      // FINDS THE DATA BASED ON ID NUMBER
      System.out.println( "\nRunning Class Equipment..." );
      Equipment equipmentA = new Equipment(568); 
      equipmentA.fetch();  
      System.out.println(equipmentA.toString());
      

      
      
      
      

   }
   
   


}