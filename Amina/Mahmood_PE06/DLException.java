import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
/**
   *Amina Mahmood
   *ISTE 330.01-02
   *Mr. Floeser
   *Database Connectivity and Access
   *Pratice Exercise 6
*/

// Create a class DLException extends Exception
public class DLException extends Exception
{
   // Instance variables
   private Exception exception;
   private ArrayList<ArrayList<String>> listOfErrorMessage = new ArrayList<ArrayList<String>>();
   private BufferedWriter bw = null;
   private PrintWriter pw = null;
   private File fn = new File("messageErrorLog.txt");
   private Date date = new Date();
   
   // Constructor that accepts a single parameter of type Exception
   public DLException(Exception ex)
   {
      super(ex.getMessage());
      this.exception = ex;
      writeLog();
   }
   
   // Constructor that accepts a parameter of type Exception and additional string 
   public DLException(Exception ex, ArrayList<String> _message)
   {
      super(ex.getMessage());
      this.exception = ex;
      listOfErrorMessage.add(_message);
      writeLog();
   }
   
   // getDate method
   public String getDate()
   {  
      return "" + Calendar.getInstance().getTime();
   }
   
   // writeLog method
   public void writeLog()
   {  
      // Try and catch statment   
      try
      {
         if(!fn.exists())
         {
            fn.createNewFile();
         }
         
         FileWriter fw = new FileWriter(fn, true);
         bw = new BufferedWriter(fw);
         pw = new PrintWriter(bw);
         pw.println(getDate() + listOfErrorMessage.toString());
         pw.flush();
         pw.close();
      }
      catch(IOException ioe)
      {
         System.out.println("Error: File is not found.");
         System.exit(1);
      }
   }
}