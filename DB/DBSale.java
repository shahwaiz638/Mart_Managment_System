package DB;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Actors.*;
import Others.Items;
import Others.Sale;
import Others.SaleLineItem;

public class DBSale {
	 
	private String usrname = "root";
	private String pass = "";
	Connection con; // connection object

	public DBSale() {
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

	public ArrayList<SaleLineItem> readSaleList(String saleID) {
		ArrayList<SaleLineItem> items = new ArrayList<SaleLineItem>();
		Statement stm;
		try {
			stm = con.createStatement();

			String query = "SELECT sale.saleID,sale.custID,sitem.itemID,items.name,items.price,items.tax,sitem.quantity,date FROM sdaproject.sale sale, sdaproject.salelineitem sitem, items where sitem.saleID=sale.saleID and items.id=sitem.itemID and sale.saleID=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(saleID));
			
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				SaleLineItem s = new SaleLineItem(rs.getInt(3),rs.getInt(1), rs.getInt(7),rs.getString(4), rs.getFloat(5),rs.getFloat(6));
				items.add(s);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	public Sale readSale() {
		Statement stm;
		try {
			stm = con.createStatement();

			Sale latestSale=new Sale();
			String query = "SELECT * from sale";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Sale s = new Sale(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getFloat(4),rs.getFloat(5));
				latestSale=s;
				System.out.println(rs.getFloat(4));
				
			}
			
			return latestSale;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void saveSaleLineItem(int itemID,int saleID,int quantity) {
		try {
			String query="INSERT INTO saleLineItem (saleID,itemID,quantity) VALUES (?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1,itemID);
			stmt.setInt(2,saleID);
			stmt.setInt(3,quantity);
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("Saleitem was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void saveSale(Sale c) {
		try {
			String query="INSERT INTO sale (custID,date,grandTotal,grandTax) VALUES (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, c.getCustID());
			stmt.setString(2,c.getDate());
			stmt.setFloat(3,0);
			stmt.setFloat(4,0);
			
			int rows=stmt.executeUpdate();
			if (rows>0) {
				System.out.println("Sale was added...");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	
			
		
	
	public boolean verifySale( String saleID) {
		String query="select * from sale where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, saleID);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("sale verified");
				return true;
			}
			else
			{
				System.out.println("Incorrect  sale id");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	public void updatetotal( int saleId,Float total,Float tax) {
		
		String query="UPDATE sale SET grandtotal=?, grandtax=? WHERE saleID=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setFloat(1, total);
			ps.setFloat(2, tax);
			ps.setInt(3, saleId);
			
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("An Item was updated...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public void removeItem( String saleId,String itemId, String quantity) {
		ArrayList<SaleLineItem> arrList= new ArrayList<SaleLineItem>();
		arrList= this.readSaleList(saleId);
		int Quantity=0;
		int itemId1=Integer.parseInt(itemId);
		int q1=Integer.parseInt(quantity);
		for(int i=0; i<arrList.size();i++) {
			if(arrList.get(i).getItemID()==itemId1) {
				Quantity= arrList.get(i).getQuantity();
				Quantity= Quantity-q1;
			}
		}
		
		String query="UPDATE saleLineItem SET quantity=? WHERE saleID=? and itemID=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, Quantity);
			ps.setInt(2, Integer.parseInt(saleId));
			ps.setInt(3, Integer.parseInt(itemId));
			
			
			
			int rows=ps.executeUpdate();
			if (rows>0) {
				System.out.println("An Item was updated...");
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
