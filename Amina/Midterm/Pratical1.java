import java.sql.*;
/**
*Amina Mahmood
*Database Access and Connectivity
*Mr. Floser
*Pratical Test1
*/
public class Pratical1
{
   private String driver = "com.mysql.cj.jdbc.Driver";
   private String uri = "jdbc:mysql://localhost/travel?autoReconnect=true&useSSL=false&useUnicode=true&"
            + "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
   private String user = "root";
   private String password = "Lovers@1996";
   private Connection conn = null;
   
   public static void main(String[] args) throws Exception
   {
      Pratical1 exam = new Pratical1();
      
      exam.readyDb();
      exam.trailer(7624);
      exam.newEq();
      exam.produce();
      exam.byeBye(2001);
      
      exam.shutDb();
   }
   
   public void readyDb() throws Exception
   {
      Class.forName(this.driver);
      
      conn = DriverManager.getConnection(this.uri, this.user, this.password);
   }
   
   public void trailer(int equipmentID) throws Exception
   {
      Statement stmt = conn.createStatement();
      
      String sql = "SELECT equipmentCapacity FROM equipment WHERE equipid=" + equipmentID + ";";
      ResultSet fetch = stmt.executeQuery(sql);
      
      while(fetch.next())
      {
         int doubleCap = fetch.getInt(1) * 2;
         
         stmt = this.conn.createStatement();
         String updateQuery = "UPDATE equipment SET equipmentCapacity = " + doubleCap + " WHERE equipId=" + equipmentID;
         stmt.executeUpdate(updateQuery);
      }
     }
      
      public void newEq() throws Exception
      {
         Statement stmt = this.conn.createStatement();
         String insert = "INSERT INTO equipment(equipId,equipmentName,equipmentDescription,equipmentCapacity)"
         + "VALUES(2001,'Train','a really long train',2000)";
         
         stmt.executeUpdate(insert);
      }
      
      public void produce() throws Exception
      {
         Statement stmt = this.conn.createStatement();
         String fetch = "SELECT * from equipment WHERE equipId > 2000";
         ResultSet result = stmt.executeQuery(fetch);
         
         while(result.next())
         {
            String output = "";
            for(int i = 1; i <= 4; i++)
            {
               output += result.getString(i) + " ";
            }
            
            System.out.println(output);
         }
      }
      
      public void byeBye(int eqId) throws Exception
      {
         Statement stmt = this.conn.createStatement();
         String delete = "DELETE from equipment WHERE equipId = " + eqId;
         stmt.executeUpdate(delete);
      }
      
      public void shutDb() throws Exception
      {
         if(this.conn != null)
         {
            this.conn.close();
            this.conn = null;
         }
      }
}