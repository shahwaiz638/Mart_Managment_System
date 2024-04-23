package DB;
import java.sql.*;
import java.util.ArrayList;
import Actors.*;
import Others.Items;

public class DBInventory {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public DBInventory() {
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

	public ArrayList<Items> readInventory() {
		ArrayList<Items> items = new ArrayList<Items>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT inv.id,name,price,tax,quantity FROM sdaproject.inventory inv inner join sdaproject.items item where item.id=inv.id";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Items s = new Items(rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getFloat(4),rs.getInt(5));
				items.add(s);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

	public void saveItems(Items c) {
		try {
			String query="INSERT INTO items (id, name,price,tax) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getId());
			stmt.setString(2,c.getName());
			stmt.setFloat(3, c.getPrice());
			stmt.setFloat(4, c.getTax());
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("A product was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
		String query="INSERT INTO inventory (id, quantity) VALUES (?,?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, c.getId());
		stmt.setInt(2,c.getQuantity());
		
		int rows=stmt.executeUpdate();
		if (rows>0) {
			System.out.println("An inventory was added...");
		}
	} catch (Exception e) {
		System.out.println(e);
	}
	}

	
			
		
	
	public boolean verifyItem( String itemID) {
		String query="select * from items where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, itemID);
			
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
	
	public void updateItem( String itemId, String quantity) {
		ArrayList<Items> arrList= new ArrayList<Items>();
		arrList= this.readInventory();
		int Quantity=0;
		int itemId1=Integer.parseInt(itemId);
		int q1=Integer.parseInt(quantity);
		for(int i=0; i<arrList.size();i++) {
			if(arrList.get(i).getId()==itemId1) {
				Quantity= arrList.get(i).getQuantity();
				Quantity= Quantity-q1;
			}
		}
		
		String query="UPDATE inventory SET quantity=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(2, Integer.parseInt(itemId));
			ps.setInt(1, Quantity);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("An Item was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public void restockItem( String itemId, String quantity) {
		
		
		String query="UPDATE inventory SET quantity=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(2, Integer.parseInt(itemId));
			ps.setInt(1, Integer.parseInt(quantity));
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("An Item was updated...");
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

	public void ReturnUpdateItem(String itemID, String quantity) {
		
		ArrayList<Items> arrList= new ArrayList<Items>();
		arrList= this.readInventory();
		int Quantity=0;
		int itemId1=Integer.parseInt(itemID);
		int q1=Integer.parseInt(quantity);
		for(int i=0; i<arrList.size();i++) {
			if(arrList.get(i).getId()==itemId1) {
				Quantity= arrList.get(i).getQuantity();
				Quantity= Quantity+q1;
			}
		}
		
		String query="UPDATE inventory SET quantity=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(2, Integer.parseInt(itemID));
			ps.setInt(1, Quantity);
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("An Item was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
