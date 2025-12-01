package UserModule;

import connection_main.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class TicketCancel
{



    TicketBooking TC = new TicketBooking();

 public  void ticketCancell()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Phone number");
        String phoneNo = sc.next();

        while (!phoneNo.matches("[0-9]{10}"))
        {
            System.out.println("Invalid phone number");
            phoneNo = sc.nextLine();
        }
        String no = TC.checkPhone(phoneNo);
        if(phoneNo.equals(no))
        {
            try
            {
                String status="cancel";
                Connection conn     = Conn.getConn();
                String sql = "update bookflight set  status = ? where phoneNo = ?";
                PreparedStatement psmt  =conn.prepareStatement(sql);
                psmt.setString(1,status);
                psmt.setString(2,phoneNo);
                int rows   = psmt.executeUpdate();
                if(rows>0)
                {
                    System.out.println("record updated");
                }
                else
                {
                    System.out.println("record not updated");
                }
            }
            catch (Exception e)
            {

                e.printStackTrace();

            }
        }

    }




}
