package DB;
import java.sql.*;
import java.util.ArrayList;
import Actors.*;

public class DBSupplier {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public DBSupplier() {
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

	public ArrayList<Supplier> readSupplier() {
		ArrayList<Supplier> supplier = new ArrayList<Supplier>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Supplier";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Supplier s = new Supplier(rs.getInt(1), rs.getString(2), rs.getString(3));
				supplier.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplier;
	}

	public void saveSupplier(Supplier c) {
		try {
			String query="INSERT INTO Supplier (id,phone,company) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, c.getId());
			stmt.setString(3, c.getCompany());
			stmt.setString(2, c.getPhone());

			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A supplier was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

/*
	public void updateSupplier( String username, String password) {
		String query="UPDATE supplier SET password=? WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, username);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Supplier was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
*/

	/*
	public void deleteSupplier(String username) {
		String query="DELETE FROM supplier WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Supplier was deleted...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	*/

	public void closeConnection() {
		try {

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
