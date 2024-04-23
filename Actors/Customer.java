package Actors;

public class Customer {
	private int id;	
	private String phone;
	//private String username,password;
	
	
	public String getPhone() {
		return phone;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/*
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
	*/
	public Customer(int id,String phone){ //, String username, String password) {
		super();
		this.id=id;
		this.phone = phone;
	//	this.username = username;
	//	this.password = password;
	}

}
