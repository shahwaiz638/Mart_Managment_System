package FXControllers;

import DB.*;
import Others.Items;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Actors.*;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ViewInventoryController implements Initializable{
	
	
	@FXML
    private TableColumn<Items, Float> Price;

    @FXML
    private TableColumn<Items, Float> Tax;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Items, Integer> id;

    @FXML
    private Label info;

    @FXML
    private TableView<Items> inventoryTable;

    @FXML
    private TableColumn<Items, String> name;

    @FXML
    private TableColumn<Items, Integer> quantity;

    @FXML
    private Button viewButton;
	
	
	
	

	
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		View(null);
	}
	
	@FXML
	void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("ManagerOperations.fxml");
	}
	@FXML
	void restock(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Restock.fxml");
	}
	@FXML
	void addItem(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("ManagerOperations.fxml");
	}
	@FXML
	void View(ActionEvent event) {
		Main m = new Main();
		DBInventory dbc=new DBInventory();
		ArrayList<Items> stu = dbc.readInventory();

		if (stu.isEmpty()) {
			info.setText("No Products registered");
		}

		else {
			final ObservableList<Items> data = FXCollections.observableArrayList(stu);

			// TODO Auto-generated method stub
			
			System.out.println("hello");

			
			id.setCellValueFactory(cellData -> cellData.getValue().getIdOB());
			name.setCellValueFactory(cellData -> cellData.getValue().getNameOB());  //--method 3		
			Tax.setCellValueFactory(cellData -> cellData.getValue().gettaxOB());
			Price.setCellValueFactory(cellData -> cellData.getValue().getPriceOB());
			quantity.setCellValueFactory(cellData -> cellData.getValue().getquantityOB());
			
			
			
//			ArrayList<Cashier> cashList=dbc.readCashier();
//			final ObservableList<Cashier> OBlist= FXCollections.observableArrayList(cashList);
//			System.out.println(OBlist.get(0).getName());
//			cashierTable.setItems(OBlist);

			inventoryTable.setItems(data);
			
		}
		

	}

    
    
    
    
}
