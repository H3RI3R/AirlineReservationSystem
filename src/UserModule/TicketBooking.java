package UserModule;
import connection_main.Conn;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Statement;

import static connection_main.Main.sc;

public class TicketBooking {

    public void bookedTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Ticket booking panel");
        String ticketid = TicketId();
        String source = getsource();
        String dest = getdest();
        String classtype = getclass1();

        double price1;
        do {
            System.out.println("Enter price price should be 10000");
            price1 = sc.nextDouble();
        }
        while (price1 != 10000);
        System.out.println("Enter your flightId");
        String fid = sc.next();

        System.out.println("Enter your flight code");
        String code = sc.next();

        System.out.println("Enter your flight name");
        String fname = sc.next();

        System.out.println("Enter your journey Date (dd/MM/yyyy):");
        String input = sc.next();
        DateTimeFormatter datematter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = LocalDate.parse(input, datematter);
        System.out.println(date);


        System.out.println("Enter your journey Time (HH:MM):");
        String input1 = sc.next();
        DateTimeFormatter time1 = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime time = LocalTime.parse(input1, time1);
        System.out.println(time);

        System.out.println("Enter your  name");
        String username = sc.next();
        System.out.println(username);

        System.out.println("Enter phone");
        String phoneNo = sc.next();
        String pNum   = checkPhone(phoneNo);
        if(pNum.equals(phoneNo))
        {
            System.out.println("this no already exist");
            phoneNo = sc.next();
        }

        while (!phoneNo.matches("[0-9]{10}")) {
            System.out.println("Invalid phone number");
            phoneNo = sc.nextLine();
        }

        System.out.println("Enter email");
        String email = sc.next();
        while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
        {
            System.out.println("invalid email please Enter agaiin ");
            email = sc.nextLine();
        }
        String   mail  = checkGmail(email);
        if(email.equals(mail))
        {
            System.out.println("dublicate value Enter again");
            email = sc.nextLine();
        }


        String Booking = "success";

        try {

            Connection conn = Conn.getConn();
            String sql = "insert into bookflight(TicketId,Source,Destination,class,price,flightId,flightcode,flightname,JourneyDate,JourneyTime,username,Phoneno,Email,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, ticketid);
            psmt.setString(2, source);
            psmt.setString(3, dest);
            psmt.setString(4, classtype);
            psmt.setString(5, String.valueOf(price1));
            psmt.setString(6, fid);
            psmt.setString(7, code);
            psmt.setString(8, fname);
            psmt.setString(9, String.valueOf(date));
            psmt.setString(10, String.valueOf(time));
            psmt.setString(11, username);
            psmt.setString(12, phoneNo);
            psmt.setString(13, email);
            psmt.setString(14, Booking);

            int rows = psmt.executeUpdate();
            if (rows > 0) {
                System.out.println("datainserted");
                System.out.println("your ticket is " + ticketid);
            } else {
                System.out.println("data not inserted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    String checkGmail(String email)
    {

           String email1="";
        try
        {
            Connection con =Conn.getConn();
            String sql = "Select Email from bookflight where Email = ? ";

            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,email);
            ResultSet rs = psmt.executeQuery();
            while (rs.next())
            {
                email1 = rs.getString("Email");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return email1;
    }



    String checkPhone(String phone) {
        String phoneNo = "";
        try {


            Connection con = Conn.getConn();
            String sql = "Select phoneNo from bookflight where phoneNo = ? ";

            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1,phone);
            ResultSet rs = psmt.executeQuery();
            while (rs.next())
            {
                phoneNo   = rs.getString("phoneNo");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return phoneNo;
    }



    private static final ArrayList<String> source = new ArrayList<>();
    public static String getsource() {
        source.add("Lucknow");
        source.add("Patna");
        source.add("Ayodhya");
        source.add("mumbai");
        source.add("kolkata");
        Scanner scanner = new Scanner(System.in);

        String selectedsource = selectSource(scanner);

        System.out.println("\nSuccessfully selected source: " + selectedsource);
        return selectedsource;

    }


    public static String selectSource(Scanner scanner) {
        int choice = -1;


        while (true) {

            System.out.println("\n--- Select a source");
            for (int i = 0; i < source.size(); i++)
            {
                System.out.println((i + 1) + ". " + source.get(i));
            }

            System.out.print("Enter the number of your desired source ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= source.size())
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid number. Please enter a valid number");
                }
            }

        }


        return source.get(choice - 1);
    }

    private static final ArrayList<String> destinations = new ArrayList<>();
    public static String getdest() {
        destinations.add("New York (JFK)");
        destinations.add("London (LHR)");
        destinations.add("Tokyo (NRT)");
        destinations.add("Dubai (DXB)");
        destinations.add("Singapore (SIN)");
        Scanner scanner = new Scanner(System.in);

        String selectedDestination = selectDestination(scanner);

        System.out.println("\nSuccessfully selected destination: " + selectedDestination);
        return  selectedDestination;

    }


    public static String selectDestination(Scanner scanner) {
        int choice = -1;

        while (true) {

            System.out.println("\n--- Select a Destination (Dropdown Simulation) ---");
            for (int i = 0; i < destinations.size(); i++)
            {
                System.out.println((i + 1) + " " + destinations.get(i));
            }

            System.out.print("Enter the number of your desired destination: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= destinations.size())
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid number. Please enter a number between 1 and " + destinations.size() + ".");
                }
            }

        }


        return destinations.get(choice - 1);
    }
    static int counter=greaterid();
    public static String TicketId()
    {
        counter++;
        String prefix = "PNR-";
        String suffix = "-ID";
        String id = String.format("%04d", counter++);
        return prefix + id + suffix;
    }
    static int greaterid()
    {


        Connection con =Conn.getConn();
        Integer counter1=0;
        try {
            String ssql="SELECT TicketId FROM BookFlight ORDER BY BookingId DESC LIMIT 1;";
            Statement stmt = con.createStatement();
            ResultSet rs  =  stmt.executeQuery(ssql);
            while (rs.next())
            {
                String  pnr = rs.getString("TicketId");
                String temp =pnr.replace("PNR-","");
                String    numString  = temp.replace("-ID","");
                counter1 = Integer.parseInt(numString);
                //int at =counter1;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return counter1;
    }

    private static final ArrayList<String> al = new ArrayList<>();
    public static String getclass1() {
        al.add("Bussiness");
        al.add("Domestic");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Airline System");

        String selectedclass = selectgetClass(scanner);

        System.out.println("\nSuccessfully selected destination: " + selectedclass);
        return  selectedclass;

    }


    public static String selectgetClass(Scanner scanner) {
        int choice = -1;


        while (true) {

            System.out.println("\n--- Select a Destination (Dropdown Simulation) ---");
            for (int i = 0; i < al.size(); i++)
            {
                System.out.println((i + 1) + ". " + al.get(i));
            }

            System.out.print("Enter the number of your desired destination: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= al.size())
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid number. Please enter a number between 1 and " + al.size() + ".");
                }
            }

        }
        return al.get(choice - 1);
    }

    public void showTicket()
    {     Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your flightcode");
        String fcode     = scanner.next();
        try
        {
            Connection con = Conn.getConn();
            String sql ="select TicketId, from BookFlight where flightcode =?";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                String  ticketId = rs.getString("TicketId");
                String  source  =rs.getString("Source");
                String  Dest     =rs.getString("Destination");
                String  price    =rs.getString("price");

                System.out.println(ticketId);
                System.out.println(source);
                System.out.println(Dest);
                System.out.println(price);

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }








//    public void getTicket()
//    {
//               getsource();
//        getdest();




//	         if(Double.compare(price,10000)==0)
//	          {
//
//
//
//	          }
//	          else
//	          {
//	              System.out.println("Invalid");
//	           price =   sc.nextDouble();
//
//	          }

}

