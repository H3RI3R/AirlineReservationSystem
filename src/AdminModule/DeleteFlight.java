package AdminModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connection_main.Conn;

public class DeleteFlight {

    public void deleteFlight() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Flight ID to delete: ");
        int id = sc.nextInt();

        try {
            Connection con = Conn.getConn();
            String sql = "DELETE FROM flights WHERE flight_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Flight deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

