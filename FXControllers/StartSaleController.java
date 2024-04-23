package FXControllers;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DB.DBCustomer;
import DB.DBInventory;
import DB.DBSale;
import Others.Items;
import Others.Sale;
import Others.SaleLineItem;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class StartSaleController implements Initializable{
	

	 @FXML
    private Label phone;



    @FXML
    private Label tax;

    @FXML
    private Label total;

	@FXML
    private TextField saleID;
	@FXML
    private TextField itemID;

    @FXML
    private TextField quantity;

    @FXML
    private Button addItembutton;

    @FXML
    private Button DisplaySale;

    @FXML
    private TableView<SaleLineItem> tableSaleLine;

    @FXML
    private TableColumn<SaleLineItem,Integer> itemidcol;

    @FXML
    private TableColumn<SaleLineItem,String> itemnamecol;

    @FXML
    private TableColumn<SaleLineItem,Float> itempricecol;

    @FXML
    private TableColumn<SaleLineItem,Float> itemtaxcol;

    @FXML
    private TableColumn<SaleLineItem, Integer> itemQuantityCol;
    
    @FXML
    private Label label1;
    
    @FXML
    private Label invoice;
    private Sale currentSale=new Sale();
    
    private DBInventory dbi = new DBInventory();
    private DBSale dbs = new DBSale();
    private DBCustomer dbc = new DBCustomer();
    
	ArrayList<SaleLineItem> newlist = new ArrayList<SaleLineItem>();
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	DisplaySale(null);
	}
    @FXML
    void addItem(ActionEvent event) {
    	
		
		
    	String itemid = itemID.getText().trim();
    	String Quantity = quantity.getText().trim();
    	
    	System.out.println(itemid);
    	System.out.println(Quantity);
    	
    	if(dbi.verifyItem(itemid)) {
    		
    		currentSale=dbs.readSale();
    		dbs.saveSaleLineItem(currentSale.getId(), Integer.parseInt(itemid),Integer.parseInt(Quantity));
    		dbi.updateItem(itemid, Quantity);
    		
    		label1.setText("Added!!");
    	
    		
    	}
    	else {
    		label1.setText("Invalid ID");
    	}
    	
    	DisplaySale(null);
    	
    }

    @FXML
    void finishSale(ActionEvent event) throws IOException
    {
    	Main m=new Main();
    	m.changeScene("Payment.fxml");
    }
    public void DisplaySale(ActionEvent event) {
    	System.out.println("Finish Sale");
    	
    	label1.setText("");
    	
    	currentSale=dbs.readSale();
    	
    	invoice.setText(String.valueOf(currentSale.getId()));
    	
    	phone.setText(dbc.getCustomerPhone(currentSale.getCustID()));
    	System.out.println(newlist.toString());
    	newlist=dbs.readSaleList(String.valueOf(currentSale.getId()));
    	
    	//getting grandTotal and GrandTax
    	getGrandTotal();
    	getGrandTax();
    	dbs.updatetotal(currentSale.getId(), currentSale.getGrandTotal(), currentSale.getGrandTax());
    	
    	final ObservableList<SaleLineItem> data = FXCollections.observableArrayList(newlist);   
		
		itemidcol.setCellValueFactory(cellData -> cellData.getValue().getItemIdOB());
		itemnamecol.setCellValueFactory(cellData -> cellData.getValue().getNameOB());
		itempricecol.setCellValueFactory(cellData -> cellData.getValue().getPriceOB());
		itemtaxcol.setCellValueFactory(cellData -> cellData.getValue().gettaxOB());
		itemQuantityCol.setCellValueFactory(cellData -> cellData.getValue().getquantityOB());
		
		
		tableSaleLine.setItems(data);
    }

	@FXML void back() throws IOException {
		Main m = new Main();
		m.changeScene("CashierOperations.fxml");
	}
	
	public void getGrandTotal()
	{
		Float gt=(float) 0;
		for(int i=0;i<newlist.size();i++)
		{
			gt+=newlist.get(i).getPrice()*newlist.get(i).getSaleQuantity();
		}
		
		currentSale.setGrandTotal(gt);
		total.setText(String.valueOf(gt));
		
		
	}
	
	public void getGrandTax()
	{
		Float gt=(float) 0;
		for(int i=0;i<newlist.size();i++)
		{
			gt+=newlist.get(i).getTax()*newlist.get(i).getSaleQuantity();
		}
		
		currentSale.setGrandTax(gt);
		tax.setText(String.valueOf(gt));
		
	}
}



