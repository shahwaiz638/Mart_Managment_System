package Actors;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
public class Supplier {
	private int id;
	private String Company,phone;

	//private DBSupplier dbs=new DBSupplier();
	
	public Supplier(int id, String company, String phone) {
		super();
		this.id = id;
		this.Company = company;
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public ObservableValue<Integer> getIdOB() {
		ObservableValue<Integer> obsStr = new ReadOnlyObjectWrapper<>(id);
		return obsStr;
	}

	public ObservableValue<String> getPhoneOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<>(phone);
		return obsStr;
	}
	
	public ObservableValue<String> getCompanyOB() {
		ObservableValue<String> obsStr = new ReadOnlyObjectWrapper<String>(Company);
		return obsStr;
	}
	
	/*
	public void addSupplierToDB()
	{
		dbs.saveSupplier(this);
	}
	
	public void RemoveSupplierToDB(String username)
	{
		dbs.deleteSupplier(username);
	}
	*/

}
