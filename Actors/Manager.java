package Actors;
import java.util.ArrayList;

import DB.*;
public class Manager {
	private int id;	
	private String name,phone,CNIC;
	private String username,password;
	private DBCashier dbc=new DBCashier();
	private DBSupplier dbs=new DBSupplier();
	private DBManager dbManager=new DBManager();
	
	public Manager(int id,String name, String phone, String CNIC, String username, String password) {
		super();
		this.id=id;
		this.name = name;
		this.phone = phone;
		this.CNIC = CNIC;
		this.username = username;
		this.password = password;
	}
	
	public Manager() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCNIC() {
		return CNIC;
	}
	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authenticate(String username,String password)
	{
		return dbManager.verifyManager(username, password);
	}
	
	public void addCashierToDB(int id,String name,String phone,String cnic,String username,String pass)
	{
		Cashier cashier=new Cashier(id,name,phone,cnic,username,pass);
		cashier.addCashierToDB();
	}
	public void RemoveCashierToDB(String username)
	{
		Cashier cashier=new Cashier();
		cashier.RemoveCashierToDB(username);
	}
	
	public ArrayList<Cashier> getCashierList()
	{
		return dbc.readCashier();
	}
	
	//Supplier
	
	public void addSupplierToDB(int id,String name,String phone)
	{
		Supplier supplier=new Supplier(id,name,phone);
		supplier.addSupplierToDB();
	}
	public void removeSupplierToDB(String username)
	{
		Cashier cashier=new Cashier();
		cashier.RemoveCashierToDB(username);
	}
	
	public ArrayList<Supplier> getSupplierList()
	{
		return dbs.readSupplier();
	}
	
	
	
	
}
