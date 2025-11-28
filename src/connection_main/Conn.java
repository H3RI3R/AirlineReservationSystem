package connection_main;
import java.sql.*;
import java.util.Scanner;

public class Conn {

    public static Connection con;
    public static  Statement statement;
    public static PreparedStatement psmt;

   public static  Connection getConnection()
   {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ARS", "root", "Ishwar@777");


        }
        catch (Exception e) {
            e.printStackTrace();
        }
       return con;
   }

    public static void User_Ams_Main() {
        try {
            String sql = "create table  if not exists AMS_main(user_id int auto_increment primary key," +
                    "full_name varchar(100) not null," +
                    "email varchar(100) not null unique," +
                    "username varchar(100) not null unique," +
                    "password varchar(100) not null," +
                    "phoneNo varchar(100) not null," +
                    "role enum('admin','user') default 'user'," +
                    "is_active boolean default TRUE);";
            statement = con.createStatement();
            statement.executeUpdate(sql);

            // statement.close();

       }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }


}
