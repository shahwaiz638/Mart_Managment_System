package Others;
import java.util.ArrayList;


public class Sale {
	private int id;
	private int custID;
	private String date;
	private Float grandTotal,grandTax;
	
	public Sale(int id, int custID, String date, Float grandTotal, Float grandTax) {
		super();
		this.id = id;
		this.custID = custID;
		this.date = date;
		this.grandTotal = grandTotal;
		this.grandTax = grandTax;
	}
	public Float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Float grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Float getGrandTax() {
		return grandTax;
	}
	public void setGrandTax(Float grandTax) {
		this.grandTax = grandTax;
	}
	private ArrayList<SaleLineItem> saleList=new ArrayList<SaleLineItem>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<SaleLineItem> getItemList() {
		return saleList;
	}
	public void setItemList(ArrayList<SaleLineItem> saleList) {
		this.saleList = saleList;
	}
	
//	public Sale(int id, int custID, String date) {
//		super();
//		this.id = id;
//		this.custID = custID;
//		this.date = date;
//	}
	public Sale(int id,int custID,String date2, ArrayList<SaleLineItem> saleList) {
		super();
		this.id = id;
		this.custID=custID;
		this.saleList = saleList;
		this.date=date2;
	}
	public Sale() {
		super();
	}
	
	
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getDate() {
		return date;
	}
	public ArrayList<SaleLineItem> getSaleList() {
		return saleList;
	}
	public void setSaleList(ArrayList<SaleLineItem> saleList) {
		this.saleList = saleList;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void addSaleLineItem(SaleLineItem item)
	{
		saleList.add(item);
	}
	
	

}
