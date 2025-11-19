import java.sql.Connection;
 import java.util.Scanner;

 public class Registration extends Conn
 {
    static Scanner sc = new Scanner(System.in);

  //  LinkedList linkedList = new LinkedList();
    public static void recordRegister()
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
            Connection   con = Conn.Conn();
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
     public enum RoleType{
         ADMIN,
         USER
     }



 }
