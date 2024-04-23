package Actors;
import DB.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
public class Cashier {
	private static Integer totalID=1;
	private Integer id;
	private String name,phone,CNIC;
	private String username,password;
	private DBCashier dbc=new DBCashier();
	public Cashier(Integer id,String name, String phone, String cNIC, String username, String password) {
		super();
		this.id=id;
		this.name = name;
		this.phone = phone;
		this.CNIC = cNIC;
		this.username = username;
		this.password = password;
	}
	
	public Cashier() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public ObservableValue<Integer> getIdOB() {
		ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(id);
		return obsInt;
	}

	public String getName() {
		return name;
	}
	public String getname() {
		return name;
	}
	public ObservableValue<String> getNameOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<>(name);
		return obsStr;
	}
	
	public ObservableValue<String> getPhoneOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<>(phone);
		return obsStr;
	}
	public ObservableValue<String> getCNICOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<>(CNIC);
		return obsStr;
	}
	public ObservableValue<String> getUsernameOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<>(username);
		return obsStr;
	}
	public ObservableValue<String> getPasswordOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<>(password);
		return obsStr;
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
	
	public void addCashierToDB()
	{
		dbc.saveCashier(this);
	}
	public void RemoveCashierToDB(String username)
	{
		dbc.deleteCashier(username);
	}
	public boolean authenticate(String username,String password)
	{
		return dbc.authenticateCashier(username, password);
	}
	

}
