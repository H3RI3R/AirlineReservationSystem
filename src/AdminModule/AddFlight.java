package AdminModule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connection_main.Conn;

public class AddFlight {


    public void addFlight() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Airline Name: ");
        String airline = sc.nextLine();

        System.out.print("Enter Source: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter Departure Time: ");
        String departure = sc.nextLine();

        System.out.print("Enter Arrival Time: ");
        String arrival = sc.nextLine();

        System.out.print("Enter Total Seats: ");
        int seats = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        try {
            Connection con = Conn.getConn();
            String sql = "INSERT INTO flights (airline_name, source, destination, departure_time, arrival_time, total_seats, available_seats, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, airline);
            ps.setString(2, source);
            ps.setString(3, destination);
            ps.setString(4, departure);
            ps.setString(5, arrival);
            ps.setInt(6, seats);
            ps.setInt(7, seats);
            ps.setDouble(8, price);

            ps.executeUpdate();

            System.out.println("Flight added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
