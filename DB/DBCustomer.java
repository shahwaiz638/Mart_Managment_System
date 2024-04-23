package DB;
import java.sql.*;
import java.util.ArrayList;
import Actors.*;

public class DBCustomer {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public DBCustomer() {
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

	public ArrayList<Customer> readCustomer() {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Customer";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
			//, rs.getString(3),rs.getString(4)	
				Customer s = new Customer(rs.getInt(1), rs.getString(2));
				customer.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	public String getCustomerPhone(int id) {
		
		String query = "SELECT phone FROM Customer where custID=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("sale verified");
				return rs.getString(1);
			}
			else
			{
				System.out.println("Incorrect  sale id");
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public void saveCustomer(Customer c) {
		try {
	//		,username,password (,?,?)
	
			String query="INSERT INTO Customer (phone) VALUES (?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, c.getPhone());
		//	stmt.setString(3, c.getUsername());
		//	stmt.setString(4, c.getPassword());
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A customer was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void updateCustomer( String username, String password) {
		String query="UPDATE customer SET password=? WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, username);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Customer was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void deleteCustomer(String username) {
		String query="DELETE FROM customer WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Customer was deleted...");
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
