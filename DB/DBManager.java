package DB;
import java.sql.*;
import java.util.ArrayList;
import Actors.*;

public class DBManager {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public DBManager() {
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

	public ArrayList<Manager> readManager() {
		ArrayList<Manager> manager = new ArrayList<Manager>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT * FROM Manager";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Manager s = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				manager.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manager;
	}

	public void saveManager(Manager c) {
		try {
			String query="INSERT INTO Manager (id, name,phone,cnic,username,password) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getId());
			stmt.setString(2,c.getName());
			stmt.setString(3, c.getPhone());
			stmt.setString(4, c.getCNIC());
			stmt.setString(5, c.getUsername());
			stmt.setString(6, c.getPassword());
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A manager was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean verifyManager( String username, String password) {
		String query="select * from manager where username=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(2, password);
			ps.setString(1, username);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Manager verified");
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
	public void updateManager( String username, String password) {
		String query="UPDATE manager SET password=? WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, password);
			ps.setString(2, username);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Manager was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void deleteManager(String username) {
		String query="DELETE FROM manager WHERE username=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, username);

			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("A Manager was deleted...");
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
