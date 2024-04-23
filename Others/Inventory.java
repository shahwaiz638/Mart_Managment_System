package Others;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Items> itemList=new ArrayList<Items>();
	
	public Inventory(ArrayList<Items> itemList) {
		super();
		this.itemList = itemList;
	}

	public void addItem(Items item)
	{
		itemList.add(item);
	}
	
	

}
