package DB;
import java.sql.*;
import java.util.ArrayList;
import Actors.*;

public class DBCashier {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public DBCashier() {
		// connect to DB
		try {
			// university is the database name
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdaproject", usrname, pass);
			System.out.println("Connection made");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Cashier> readCashier() {
		ArrayList<Cashier> cashier = new ArrayList<Cashier>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Cashier";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Cashier s = new Cashier(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				cashier.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cashier;
	}

	public void saveCashier(Cashier c) {
		try {
			String query="INSERT INTO Cashier (id, name,phone,cnic,username,password) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getId());
			stmt.setString(2,c.getName());
			stmt.setString(3, c.getPhone());
			stmt.setString(4, c.getCNIC());
			stmt.setString(5, c.getUsername());
			stmt.setString(6, c.getPassword());
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A cashier was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean authenticateCashier( String username, String password) {
		String query="select * from cashier where username=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(2, password);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Cashier verified");
				return true;
			}
			else
			{
				System.out.println("Incorrect credentials");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return false;
	}
	
	public boolean verifyCashier( String username) {
		String query="select * from cashier where username=? ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Cashier verified");
				return true;
			}
			else
			{
				System.out.println("Incorrect credentials");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	
	public void updateCashier( String username, String password) {
		String query="UPDATE cashier SET password=? WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, username);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Cashier was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void deleteCashier(String username) {
		String query="DELETE FROM cashier WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Cashier was deleted...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void closeConnection() {
		try {

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
