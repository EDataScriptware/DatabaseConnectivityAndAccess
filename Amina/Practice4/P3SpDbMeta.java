import java.sql.*;

/** 
 * Stored procedure and Database MetaData starter code for Practical 3
 *
 * Course: ISTE-330/722
 *
 * @author >>>>>>>> Put Your Name Here <<<<<<<<<
 */

public class P3SpDbMeta {
 
   // Define the connection object     
   private Connection conn;
   private PreparedStatement stmt;

   /**
      Main simulates the presentation layer. 
      Used to test the Stored Procedure in a DBMS
      @param args Command line arguments. None for this test program.
   */
   public static void main(String[] args) throws Exception
   {
      new P3SpDbMeta();   // Create an object of ourself and all is easy calling methods
   }

   public P3SpDbMeta() throws Exception
   { 
      // Connect to the database
      System.out.println("Database connection = " + connect());
      
      String customer1 = "William Mackay";
      String customer2 = "Sam Smith";
      int amount = 1000;
      if(this.transfer(customer1, customer2, amount)) 
      {
    	  System.out.println(customer1 + " Transferred " + amount + " to "+ customer2);
    	  System.out.println("Successful transferred");
      } 
      else 
      {
    	  System.out.println("Failed to transfer");
      }
      
      
   
   
      // Close the database
      System.out.println("Database disconnect = "+ close());
   }
   
   public boolean transfer(String customer1, String customer2, int amount) throws Exception
   {
	   this.conn.setAutoCommit(false);
	   

	   
	   //can we locate the customer? 
	   if(!this.hasCustomer(customer1) || !this.hasCustomer(customer2)) {
		   this.conn.rollback();
		   System.err.println("the customer "+ customer1 + " or "+customer2+ " doesnt exist");
		   return false;
	   }
//	   
	   if(!this.hasEnough(customer1, amount)) {
		   System.err.println("The customer "+customer1 +" doesnt have enough amount to transfer");
		   this.conn.rollback();
		   return false;
	   }
//	   
	   if(!this.hasChecking(customer2)) {
		   System.err.println("The customer "+customer2 +" doesnt have enough amount to transfer");
		   this.conn.rollback();
		   return false;
	   }
//	   
//	   //withdrew
	   if(!this.modified(customer1,amount,true)) {
		   System.err.println("Failed to withdrew from "+customer1);
		   this.conn.rollback();
		   return false;
	   }
//	   
//	   //add
	   if(!this.modified(customer2, amount, false)) {
		   System.err.println("Failed to added to "+customer2);
		   this.conn.rollback();
		   return false;
	   }
	   
	   this.conn.commit();
	   
	   return true;
	   
	   
   }
   
   private boolean modified(String customer, int amount, boolean sub) throws Exception
   {
	   
	   String sql = "UPDATE account INNER JOIN accountholder ON account.ownerId = accountholder.ownerId SET amount = ";
	   
	   if(sub)
		   sql+="(account.amount - ?)";
	   else
		   sql+="(account.amount + ?)";
	   
	   sql+= " WHERE accountOwner = ? AND accountType = 'C'";
	   
	   //System.out.println(sql);
	   
	  stmt = this.conn.prepareStatement(sql);
	  stmt.setDouble(1, amount);
	  stmt.setString(2, customer);
	  
	  return this.stmt.executeUpdate() > 0;
   }
   
   private boolean hasCustomer(String customer) throws Exception
   {
	   String sql = "SELECT accountOwner FROM accountholder WHERE accountOwner = ?";
	   stmt = this.conn.prepareStatement(sql);
	   stmt.setString(1, customer);
	   
	   ResultSet rs = stmt.executeQuery();
	   
	   if(rs.next()) {
		   return true;
	   }
	   
	   return false;
   }
   
   public boolean hasEnough(String customer, int amount) throws Exception
   {
	   String sql = "SELECT amount FROM accountholder INNER JOIN account ON account.ownerId = accountholder.ownerId WHERE accountholder.accountOwner = ?"
	   		+ "and account.amount>= ?";
	   this.stmt = this.conn.prepareStatement(sql);
	   stmt.setString(1, customer);
	   stmt.setInt(2, amount);
	   
	   ResultSet rs = stmt.executeQuery();
	   if(rs.next()) {
		   return true;
	   }
	   
	   return false;
   }
   
   public boolean hasChecking(String customer) throws Exception
   {
	  
	   String sql = "SELECT amount from account INNER JOIN accountholder ON account.ownerId = accountholder.ownerId WHERE accountholder.accountOwner = ? "
	   		+ " AND account.accountType = 'C'";
		   this.stmt = this.conn.prepareStatement(sql);
		   stmt.setString(1, customer);

		   
		   ResultSet rs = stmt.executeQuery();
		   
		   if(rs.next()) {
			   return true;
		   }
		   
		   return false;
   }

      
   /** 
    * Connect to the database 
    * @return status Returns true if connected to the database, otherwise false.
    */
   
   public boolean connect(){
      try{
         conn = null;
         String userName = "root";
         String password = "Lovers@1996";
         String url = "jdbc:mysql://localhost/bankdb?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
         
         Class.forName("com.mysql.cj.jdbc.Driver");	// Needs driver in dir
         conn = DriverManager.getConnection(url, userName, password);
      }
      catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      }
      catch(SQLException sqle){
         System.out.println("Error on open");
         sqle.printStackTrace();
      }
      return (conn!=null); // If we have a connection, returns true
   } // end connect
   
   /** Close the database 
    * @return status Returns true if database is closed, otherwise false.
    */
   
   public boolean close(){
      boolean status = false;
      try{
         if(conn != null){
            conn.close();
            conn = null;
            status = true;
         }
      }
      catch(SQLException sqle){
         System.out.println("Error on open");
         sqle.printStackTrace();
      }
      return status; // If we closed the connection, returns true
   } // end close
   
} // end P3SpDbMeta class