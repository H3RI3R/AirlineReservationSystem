package connection_main;
import com.sun.source.tree.TryTree;
import java.sql.*;
import java.util.Scanner;

public class Conn
   {

    public static Connection con;
    public static  Statement statement;
    public static PreparedStatement psmt;

    public static  Connection getConn()
    {
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AMS", "root", "sangam_123");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
    public static void bookDetail()
    {
        try{

            String sql=
                    " create table if not exists BookFlight(\n" +
                    "BookingId int auto_increment primary key ," +
                    "TicketId varchar(50) not null," +
                    "Source varchar(50) not null," +
                    "Destination varchar(50) not null," +
                    "class varchar(50) not null," +
                    "price decimal(10,2) not null," +
                    "flightId int not null," +
                    "flightcode varchar(50) not null," +
                    "flightname varchar(50) not null," +
                    "JourneyDate date," +
                    "JourneyTime time not null," +
                    "username varchar(50) not null," +
                    "phoneNo  varchar(50) unique not null,"+
                    "Email varchar(50) unique not null,"+
                    "status varchar(50) null," +
                    " foreign key (flightId) references flights(flightId)" +
                    ");" ;
            Statement  stmt =con.createStatement();
            int row = stmt. executeUpdate(sql);
            if(row<1)
            {

                System.out.println("Tble have been created");
            }
            else
            {
                System.out.println("table not created ");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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

