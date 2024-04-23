package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Others.PaymentClass;

public class PaymentDB {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public PaymentDB() {
		// connect to DB
		try {
			// university is the database name
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdaproject", usrname, pass);
			System.out.println("Connection made");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PaymentClass> readItems() {
		ArrayList<PaymentClass> items = new ArrayList<PaymentClass>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Payment";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				PaymentClass i = new PaymentClass(rs.getString(1),rs.getInt(2));
				items.add(i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	public boolean verifyItem(String cardNumber) {
		String query="select * from Payment where cardNumber=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, cardNumber);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Card verified");
				return true;
			}
			else
			{
				System.out.println("Given Card is incorrect");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	
    public void updateBalance( String cardNo, float balance) {
        
        int balance1 = (int) balance;

		String query="UPDATE Payment SET balance=? WHERE cardNumber=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(2, cardNo);
			ps.setInt(1, balance1);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("Payment was updated...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
}