package AdminModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connection_main.Conn;

public class UpdateFlight {

    public void updateFlight() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Flight ID to update: ");
        int id = sc.nextInt();

        System.out.println("1. Update Price");
        System.out.println("2. Update Seats");
        System.out.println("3. Update Time");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();

        try {
            Connection con = Conn.getConn();
            PreparedStatement ps;

            if (choice == 1) {
                System.out.print("Enter new price: ");
                double price = sc.nextDouble();

                ps = con.prepareStatement("UPDATE flights SET price=? WHERE flight_id=?");
                ps.setDouble(1, price);
                ps.setInt(2, id);
            }

            else if (choice == 2) {
                System.out.print("Enter new total seats: ");
                int seats = sc.nextInt();

                ps = con.prepareStatement("UPDATE flights SET total_seats=?, available_seats=? WHERE flight_id=?");
                ps.setInt(1, seats);
                ps.setInt(2, seats);
                ps.setInt(3, id);
            }

            else if (choice == 3) {
                sc.nextLine(); // flush
                System.out.print("Enter new departure time: ");
                String dep = sc.nextLine();

                ps = con.prepareStatement("UPDATE flights SET departure_time=? WHERE flight_id=?");
                ps.setString(1, dep);
                ps.setInt(2, id);
            }

            else {
                System.out.println("Invalid Choice!");
                return;
            }

            ps.executeUpdate();
            System.out.println("Flight updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
