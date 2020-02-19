import java.sql*;

public class test()
{
   public static void main(String[] args)
   {
      Test exam = new Test();
      
      
   }
   
   public void open() throws Exception
   {
      Class.forName(driver);
      
      conn = DriverManager.getConnection(uri, user, pass);
   }
   
   public void trailer(int equipmentI) throws Exception
   {
      
   }
}