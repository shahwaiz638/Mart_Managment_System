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


public class ReturnSaleController implements Initializable{
	  @FXML
	    private Button finish;

	    @FXML
	    private Button generateSale;

	    @FXML
	    private TextField saleID;
	    
	    @FXML
	    private TextField itemID;

	    @FXML
	    private TableColumn<SaleLineItem, Integer> itemQuantityCol;

	    @FXML
	    private TableColumn<SaleLineItem, Integer> itemidcol;

	    @FXML
	    private TableColumn<SaleLineItem, String> itemnamecol;

	    @FXML
	    private TableColumn<SaleLineItem, Float> itempricecol;

	    @FXML
	    private TableColumn<SaleLineItem, Float> itemtaxcol;

	    @FXML
	    private Button proceed;

	    @FXML
	    private TextField quantity;

	    @FXML
	    private Button remove;

	    @FXML
	    private TableView<SaleLineItem> tableSaleLine;
    
    private Sale currentSale=new Sale();
    
    private DBInventory dbi = new DBInventory();
    private DBSale dbs = new DBSale();
    
	ArrayList<SaleLineItem> newlist = new ArrayList<SaleLineItem>();
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    	//DisplaySale(null);
	}
    @FXML
    public void generateSale(ActionEvent event) {
    	
		int id=0;
		String name;
		float tax,price;

    	
		
    	ArrayList<Items> itemslist = new ArrayList<Items>();
		itemslist = dbi.readInventory();
		
    	
    	
    	if(dbs.verifySale(saleID.getText().trim())) {
    		
    		
    		int saleId=Integer.parseInt(saleID.getText());
    		int itemId=Integer.parseInt(itemID.getText());
    		int q=Integer.parseInt(quantity.getText().trim());
    		currentSale=dbs.readSale();
    		
    	}
    	else {
    		
    	}
    	
    		DisplaySale(null);
    	
    }

    void DisplaySale(ActionEvent event) {
    	System.out.println("Finish Sale");
    	
    	System.out.println(newlist.toString());
    	newlist=dbs.readSaleList(saleID.getText().trim());
    	final ObservableList<SaleLineItem> data = FXCollections.observableArrayList(newlist);   
		
		itemidcol.setCellValueFactory(cellData -> cellData.getValue().getItemIdOB());
		itemnamecol.setCellValueFactory(cellData -> cellData.getValue().getNameOB());
		itempricecol.setCellValueFactory(cellData -> cellData.getValue().getPriceOB());
		itemtaxcol.setCellValueFactory(cellData -> cellData.getValue().gettaxOB());
		itemQuantityCol.setCellValueFactory(cellData -> cellData.getValue().getquantityOB());
		
		
		tableSaleLine.setItems(data);
    }

	@FXML void finish() throws IOException {
		Main m = new Main();
		m.changeScene("CashierOperations.fxml");
	}
	
	@FXML void proceed() throws IOException {
		Main m = new Main();
		m.changeScene("CashierOperations.fxml");
	}
	
	@FXML void remove() throws IOException {
		dbs.removeItem(saleID.getText().trim(),itemID.getText().trim(),quantity.getText().trim());
		dbi.ReturnUpdateItem(itemID.getText(),quantity.getText().trim());
		System.out.println("item removed");
		DisplaySale(null);
	}
}




