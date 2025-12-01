package AdminModule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection_main.Conn;

public class ViewFlight {

    public void viewAllFlights() {
        try {
            Connection con = Conn.getConn();
            String sql = "SELECT * FROM flights";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- All Flights ---");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("flight_id") + " | " +
                    rs.getString("airline_name") + " | " +
                    rs.getString("source") + " -> " +
                    rs.getString("destination") + " | " +
                    rs.getString("departure_time") + " | " +
                    rs.getString("arrival_time") + " | " +
                    rs.getInt("available_seats") + " seats | Rs." +
                    rs.getDouble("price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
