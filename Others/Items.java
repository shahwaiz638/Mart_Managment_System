package Others;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;

public class Items {
	private int id,quantity;
	private String name;
	private float tax,price;
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
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Items(int id, String name, float tax, float price,int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.tax = tax;
		this.price = price;
		this.quantity=quantity;
	}
	public Items() {
		super();
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public ObservableValue<Integer> getIdOB() {
		ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(id);
		return obsInt;
	}
	
	public ObservableValue<String> getNameOB() {
		ObservableValue<String> obsInt = new ReadOnlyObjectWrapper<>(name);
		return obsInt;
	}
	
	public ObservableValue<Float> getPriceOB() {
		ObservableValue<Float> obsInt = new ReadOnlyObjectWrapper<>(price);
		return obsInt;
	}
	public ObservableValue<Float> gettaxOB() {
		ObservableValue<Float> obsInt = new ReadOnlyObjectWrapper<>(tax);
		return obsInt;
	}
	public ObservableValue<Integer> getquantityOB() {
		ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(quantity);
		return obsInt;
	}
	

}
