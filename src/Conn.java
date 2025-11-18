import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Conn {

          public Connection con;
          public  Statement statement;
          Conn()
        {
            try
              {
               Class.forName("com.mysql.cj.jdbc.Driver");
               con= DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS","root","sangam_123");
               System.out.println("connection success");
               createUserSignIn();




              }
              catch (Exception e)
              {
                  e.printStackTrace();

              }
        }
        public void createUserSignIn()
        {
            try {
                String sql = "Create table IF NOT EXISTS signIn(username varchar(20) NOT NULL,password varchar(20) NOT NULL)";
                statement = con.createStatement();
                statement.execute(sql);
                System.out.println("table created");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        public void createAdimSignIn()
        {
            try
            {
              String sql="";
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }



        }




}
