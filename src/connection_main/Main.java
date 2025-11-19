package connection_main;
import java.util.Scanner;

import files_package.Registration;
public class Main
{

   public static  int i;
   public static   Scanner sc = new Scanner(System.in);
    public static void main(String[]args)
    {
        Conn.getConnection();
        Conn.User_Ams_Main();
        System.out.println("Click for Option");
        System.out.println("1. Enter for admin ");
        System.out.println("2. Enter for user");
        i = sc.nextInt();

        switch (i)
        {
            case 1:
                System.out.println("Welcome To admin panel");
                System.out.println("1. Click  for admin Registration ");
                System.out.println("2. Click for  admin login");

                   i   = sc.nextInt();

                switch(i)
                {
                    case 1:
                        System.out.println("you are in admin registration");
                         Registration.recordRegister();
                        break;

                    case 2:
                        System.out.println("you are in admin login");
                         break;


                }
                     break;
            case 2:
                System.out.println("welcome to user panel");
                System.out.println("1. Enter for user Registration");
                System.out.println("2. Enter for user login ");
                 i=sc.nextInt();
                 switch (i)
                 {
                     case 1:
                         System.out.println("you are in user registration panel");
                         Registration.recordRegister();
                         break;
                     case 2:
                         System.out.println("you are in user login panel'");
                          break;



                 }
                  break;



        }
     }

 }
