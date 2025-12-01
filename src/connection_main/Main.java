package connection_main;
import AdminModule.AddFlight;
import AdminModule.DeleteFlight;
import AdminModule.ViewFlight;
import AdminModule.UpdateFlight;

import UserModule.TicketBooking;
import UserModule.TicketCancel;
import files_package.Registration;

import java.sql.Connection;
import java.util.Scanner;
public class Main {

    public static int choice;
    public static Scanner sc = new Scanner(System.in);
    public static Boolean condition = false;

    public static void main(String[] args) {

        AddFlight af = new AddFlight();
        DeleteFlight df = new DeleteFlight();
        UpdateFlight uf = new UpdateFlight();
        ViewFlight vf = new ViewFlight();

        TicketBooking ttBooking = new TicketBooking();
        TicketCancel tc = new TicketCancel();
        System.out.println("hello this is main class");
        Conn.getConn();
        Conn.User_Ams_Main();
        Conn.bookDetail();

        while (condition != true) {

            System.out.println("Click for Option");
            System.out.println("1. Enter for admin ");
            System.out.println("2. Enter for user");

            System.out.println("3. Enter for exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Welcome To admin panel");
                    System.out.println("1. Click  for admin Registration ");
                    System.out.println("2. Click for  admin login");

                    System.out.println("3. Click for Exit");


                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("you are in admin registration");
                            Registration.adminRecordRegister();
                            break;

                        case 2:
                            System.out.println("you are in admin login");
                            Registration.adminLogin();

                            if (Registration.adminLogin() == true) {
                                System.out.println("1 Enter  add flight");
                                System.out.println("2 Enter delete flight");
                                System.out.println("3 Update flight");
                                System.out.println("4 View flight");
                                int i1 = sc.nextInt();
                                switch (i1) {
                                    case 1:
                                        af.addFlight();
                                        break;

                                    case 2:
                                        df.deleteFlight();
                                        break;
                                    case 3:
                                        uf.updateFlight();
                                        break;
                                    case 4:
                                        vf.viewAllFlights();
                                        break;

                                }
                                break;
                            }
                            else
                            {
                                System.out.println("something went wrong");
                            }
                    }
                           break;
                case 2:
                    System.out.println("welcome to user panel");
                    System.out.println("1. Enter for user Registration");
                    System.out.println("2. Enter for user login ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("you are in user registration panel");
                            Registration.userRecordRegister();
                            break;
                        case 2:
                            System.out.println("you are in user login panel'");
                            Registration.userLogin();
                            if(Registration.userLogin()) {
                                System.out.println("1.Enter for TicketBooking");
                                System.out.println("2.Enter for TicketCancel");
                                System.out.println("3. Enter for Exit");

                                int i1 = sc.nextInt();
                                switch (i1) {
                                    case 1:
                                        ttBooking.bookedTicket();

                                        break;
                                    case 2:
                                        tc.ticketCancell();

                                        break;

                                    case 3:
                                        System.exit(0);
                                        break;
                                }
                                break;
                            }
                            else {
                                System.out.println("something went wrong");
                            }
                    }
                    break;

//            case 3:
//                System.out.println("you are in flight Booking panel");
//                System.out.println("1.Enter for booking flight");
//                System.out.println("2.Enter for showing ticket");
//                int i=sc.nextInt();
//                switch (i)
//                {
//                    case 1:
//                        ttBooking.bookedTicket();
//                        break;
//                    case 2:
//
//
//
//                }
//
//
//
//
//
//
//                break;


                case 3:
                    System.exit(0);
                    break;


            }
        }
    }
}