import java.sql.*;
import javax.sql.*;
import java.util.*;

public class main
{
   static Connection connection = null;
   
   static String driver = "com.mysql.jdbc.Driver";
   static String driverURL = "jdbc:mysql://localhost/travel?";
   static String username = "root";
   static String password = "students";
   
   static String passengerID = null;
   static String firstName = null;
   static String lastName = null;
   static String street = null;
   static String zipcode = null;

   public static void main(String[] args)
   {      
      // Step #1: Load Driver
      LoadDriver(driver);
      
      // Step #2: Connect to Database
      connection = Connect(driverURL, username, password);
      
      // Step #3: Get Data
      fetch(1);
      
      // Step #4: Interpret Data
      System.out.println("PassengerID:\t" + getPassengerID());
      System.out.println("FirstName:\t\t" + getFirstName());
      System.out.println("LastName:\t\t" + getLastName());
      System.out.println("Street:\t\t\t" + getStreet());
      System.out.println("Zipcode:\t\t\t" + getZipcode() + "\n");
      
      // Step #5: Insert Data
      insert(11, "Edward", "Riley", "University Commons 13", "14623"); 
      
      // Step #6: Fetch Data AGAIN  
      fetch(11);
      
      // Step #7: Interpret Data AGAIN
      System.out.println("PassengerID:\t" + getPassengerID());
      System.out.println("FirstName:\t\t" + getFirstName());
      System.out.println("LastName:\t\t" + getLastName());
      System.out.println("Street:\t\t\t" + getStreet());
      System.out.println("Zipcode:\t\t\t" + getZipcode());

      delete(11);
      
      // Last Step: Close Data
      closeConnection(connection);
      
   
   }
   
   
   public static void LoadDriver(String driver)
   {
      try 
      {
         Class.forName(driver);
         System.out.println("Driver Loaded!"); 
      }
      catch (Exception e)
      {
         System.out.println("Driver failed to load: " + e.toString());
      }
   } // end LoadDriver
   
   public static Connection Connect(String url, String user, String password)
   {
      try 
      {
         Connection connection = DriverManager.getConnection(url, user, password);
         System.out.println("Connection success");
         return connection;
      }
      catch (Exception e)
      {
         System.out.println("Failed to connect.");
         return null;
      }
   } // end Connect
   
   
   public static void fetch(int newPassengerID)
   {
      String query = "SELECT * FROM passenger WHERE PassengerID = " + newPassengerID + ";";
      ArrayList<ArrayList<String>> twoDimensionalArray = twoDimensionalArray = getData(query, 5);
      
      if (twoDimensionalArray.size() != 0)
      {
         setPassengerID(twoDimensionalArray.get(0).get(0));
         setFirstName(twoDimensionalArray.get(0).get(1));
         setLastName(twoDimensionalArray.get(0).get(2));
         setStreet(twoDimensionalArray.get(0).get(3));
         setZipcode(twoDimensionalArray.get(0).get(4));
      }
   
   
   } // end fetch
   
   public static void insert(int newPassengerID, String newFirstName, String newLastName, String newStreet, String newZipcode)
   {
     String query = "INSERT INTO Passenger (PassengerID, FName, LName, Street, Zip)" + " VALUES (" + newPassengerID + ", '" + newFirstName+"', '" + newLastName + "', '" + newStreet + "', " +  newZipcode + " );";
     
     int rowUpdated = setData(query);
     
     System.out.println("Insert successful!");

   }   
   
   public static void delete(int newPassengerID)
   {
      String query = "DELETE FROM Passenger WHERE PassengerID = " + newPassengerID + ";";
            
      int rowUpdated = setData(query);

      System.out.println("Delete Successful!");
   }

   
   public static ArrayList<ArrayList<String>> getData(String query, int columnNum)
   {
      ArrayList<ArrayList<String>> twoDimensionalArray = new ArrayList<ArrayList<String>>();
      ArrayList<String> info = new ArrayList<String>();  
      
      try
      {
      
         // Prepare then execute statements. 
         Statement stmt = connection.createStatement(); // The problem is... Connection is "null" 
         ResultSet rs = stmt.executeQuery(query);
         
         int count = 0;
         
         while (rs.next())
         {
            twoDimensionalArray.add(info);  
            for ( int i = 1; i <= columnNum; i++) 
            {
               twoDimensionalArray.get(count).add(rs.getString(i));
            }
                        
            count++;  
         }      
      
      }
      catch (SQLException e)
      {
         System.out.println(e.toString());
      }
      
      return twoDimensionalArray;
   }
   
   public static int setData(String query)
   {
      try 
      {
         Statement stmt = connection.createStatement();
         
         // how many rows updated
         int row = stmt.executeUpdate(query);
         
         return row;
      }
      catch (Exception e)
      {
         System.out.println(e.toString());
         
         // return error code
         return -1;
      }
         
   
   
   }


   public static void closeConnection(Connection connection)
   {
      try 
      {
         connection.close();
         System.out.println("Connection successfully closed.");
      }
      catch (Exception e)
      {
         System.out.println("Unable to Close Connection: " + e.toString());
      }
   }
   
   
   // Mutators and Accessors
   public static void setPassengerID(String _passengerID)
   {
      passengerID = _passengerID;
   } 
   
   public static String getPassengerID()
   {
      return passengerID;
   }
   
   public static void setFirstName(String _firstName)
   {
      firstName = _firstName;
   }
   
   public static String getFirstName()
   {
      return firstName;
   }
   
   public static void setLastName(String _lastName)
   {
      lastName = _lastName;
   }
   
   public static String getLastName()
   {
      return lastName;
   }
   
   public static void setStreet(String _street)
   {
      street = _street;  
   }
   
   public static String getStreet()
   {
      return street;
   }
   
   public static void setZipcode(String _zipcode)
   {
      zipcode = _zipcode;
   }
   
   public static String getZipcode()
   {
      return zipcode;
   }
   
}