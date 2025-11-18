import java.util.Scanner;
public class Main
{
   public static  int i;
    static   Scanner sc = new Scanner(System.in);
    public static void main(String[]args)
    {

          new Conn();
        System.out.println("Click for Option");
        System.out.println("1. Enter for admin ");
        System.out.println("2. Enter for login");
        i = sc.nextInt();

        switch (i)
        {
            case 1:
                System.out.println("1. Click  for admin Registration ");
                System.out.println("2. Click for  admin login");
                System.out.println("you are in admin panel");
                   i   =sc.nextInt();

                switch(i)
                {
                    case 1:
                        break;

                    case 2:
                         break;


                }

                 break;
            case 2:
                System.out.println("you are in login panel");
                 break;



        }
     }
 }
