package files_package;
import connection_main.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Registration extends Conn
{
    static Scanner sc = new Scanner(System.in);

    //  LinkedList linkedList = new LinkedList();
    public static void userRecordRegister()
    {

        System.out.println("Enter full_name");
        String full_name = sc.nextLine();
        while(!full_name.matches("[A-Za-z ]{3,50}"))
        {
            System.out.println(" Invalid Name! Only letters allowed please Enter again:");
            full_name = sc.nextLine();
        }



        System.out.println("Enter email");
        String email = sc.nextLine();
        while(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
        {
            System.out.println("invalid email ");
            System.out.println("please enter valid email");
            email =sc.nextLine();

        }
        System.out.println("Enter username");
        String  username = sc.nextLine();
        while(!username.matches("^(?=.*[A-Za-z])[A-Za-z0-9_]{3,20}$"))
        {
            System.out.println("invalid username please Enter again");
            username = sc.nextLine();

        }




        System.out.println("Enter password");
        String password = sc.nextLine();
        while(!password.matches("^(?=.*[A-Z])(?=.*[@#$%^&+=!_]).{6,20}$"))
        {
            System.out.println("password>6 :One letter capital one special character");
            password=sc.nextLine();
        }
        System.out.println("Enter phone");
        String phoneNo =  sc.nextLine();
        while(!phoneNo.matches("[0-9]{10}"))
        {
            System.out.println("Invalid phone number");
            phoneNo =sc.nextLine();
        }

        Recrod_var rr = new Recrod_var();
        rr.setFull_name(full_name);
        rr.setEmail(email);
        rr.setUsername(username);
        rr.setPassword(password);
        rr.setPhoneNo(phoneNo);


        try {
            RoleType  SelerctRoleType  =  RoleType.ADMIN;
            Connection   con = Conn.getConn();
            String sql = "insert into ams_main(full_name,email,username,password,phoneNo,role) values(?,?,?,?,?,?);";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,rr.getfull_name());
            psmt.setString(2,rr.getEmail());
            psmt.setString(3,rr.getUsername());
            psmt.setString(4,rr.getPassword());
            psmt.setString(5,rr.getPhoneNo());
            psmt.setString(6,RoleType.USER.name());
            int row    = psmt.executeUpdate();

            if(row>0)
            {
                System.out.println("inserted  successfully");
            }
            else
            {
                System.out.println("data not inserted");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
    public static void adminRecordRegister()
    {

        System.out.println("Enter full_name");
        String full_name = sc.nextLine();
        while(!full_name.matches("[A-Za-z ]{3,50}"))
        {
            System.out.println(" Invalid Name! Only letters allowed please Enter again:");
            full_name = sc.nextLine();
        }



        System.out.println("Enter email");
        String email = sc.nextLine();
        while(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
        {
            System.out.println("invalid email ");
            System.out.println("please enter valid email");
            email =sc.nextLine();

        }

        System.out.println("Enter username");
        String  username = sc.nextLine();
        while(!username.matches("^(?=.*[A-Za-z])[A-Za-z0-9_]{3,20}$"))
        {
            System.out.println("invalid username please Enter again");
            username = sc.nextLine();

        }

        System.out.println("Enter password");
        String password = sc.nextLine();
        while(!password.matches("^(?=.*[A-Z])(?=.*[@#$%^&+=!_]).{6,20}$"))
        {
            System.out.println("password>6 :One letter capital one special character");
            password=sc.nextLine();
        }



        System.out.println("Enter phone");
        String phoneNo =  sc.nextLine();
        while(!phoneNo.matches("[0-9]{10}"))
        {
            System.out.println("Invalid phone number");
            phoneNo =sc.nextLine();
        }

        Recrod_var rr = new Recrod_var();
        rr.setFull_name(full_name);
        rr.setEmail(email);
        rr.setUsername(username);
        rr.setPassword(password);
        rr.setPhoneNo(phoneNo);


        try {
            RoleType  SelerctRoleType  =  RoleType.ADMIN;
            Connection   con = Conn.getConn();
            String sql = "insert into ams_main(full_name,email,username,password,phoneNo,role) values(?,?,?,?,?,?);";
            psmt = con.prepareStatement(sql);
            psmt.setString(1,rr.getfull_name());
            psmt.setString(2,rr.getEmail());
            psmt.setString(3,rr.getUsername());
            psmt.setString(4,rr.getPassword());
            psmt.setString(5,rr.getPhoneNo());
            psmt.setString(6,RoleType.ADMIN.name());
            int row    = psmt.executeUpdate();
            if(row>0)
            {
                System.out.println("inserted  successfully");
            }
            else
            {
                System.out.println("data not inserted");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static boolean userLogin() {

     //   Recrod_var rr = new Recrod_var();

        System.out.println("Enter your username");
        String username = sc.nextLine();

        System.out.println("Enter your password");
        String password = sc.nextLine();
        Boolean loginsuccess = false;

        try {

                Connection con =Conn.getConn();
            String sql = "select  is_active from ams_main where username=? and password= ? and role='user'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                boolean isActive = rs.getBoolean("is_active");
                if (isActive) {
                    System.out.println("login successfull");
                    loginsuccess = true;

                   }
                else
                {
                    System.out.println("something went wrong");
                }

                }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return loginsuccess;
    }

    public static  boolean adminLogin()
    {

     //   Recrod_var rr = new Recrod_var();

        System.out.println("Enter your username");

        String username    =  sc.nextLine();

        System.out.println("Enter your password");
        String password = sc.nextLine();

        Boolean loginsuccess =false;
        try
        {
            Connection con =Conn.getConn();
            String sql ="select username,is_active from ams_main where username=? and password= ? and role='admin'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs   = ps.executeQuery();
            if(rs.next())
            {
                boolean  isActive= rs.getBoolean("is_active");
                if(isActive)
                {
                    System.out.println("login page");
                    System.out.println("login successfull");
                    loginsuccess=true;

                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("user and password not eqqual");
            return false;
        }
        return loginsuccess;

    }


    public enum RoleType
    {
        ADMIN,
        USER
    }

}
