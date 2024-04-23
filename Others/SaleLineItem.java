package Others;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;

public class SaleLineItem {
		private int itemID,saleID,saleQuantity;
		private String name;
		private float tax,price;
		
		
		public ObservableValue<Integer> getItemIdOB() {
			ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(itemID);
			return obsInt;
		}
		
		public ObservableValue<Integer> getsaleIDOB() {
			ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(saleID);
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
			ObservableValue<Integer> obsInt = new ReadOnlyObjectWrapper<>(saleQuantity);
			return obsInt;
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
		
		public SaleLineItem(int itemID, int saleID, int saleQuantity, String name, float price, float tax) {
			super();
			this.itemID = itemID;
			this.saleID = saleID;
			this.saleQuantity = saleQuantity;
			this.name = name;
			this.tax = tax;
			this.price = price;
		}

		public int getItemID() {
			return itemID;
		}

		public void setItemID(int itemID) {
			this.itemID = itemID;
		}

		public int getSaleID() {
			return saleID;
		}

		public void setSaleID(int saleID) {
			this.saleID = saleID;
		}

		public int getSaleQuantity() {
			return saleQuantity;
		}

		public void setSaleQuantity(int saleQuantity) {
			this.saleQuantity = saleQuantity;
		}

		public SaleLineItem() {
			super();
		}
		public int getQuantity() {
			return saleQuantity;
		}
		public void setQuantity(int saleQuantity) {
			this.saleQuantity = saleQuantity;
		}
		
		

	


}
