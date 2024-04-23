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

public class UpdateInventoryController implements Initializable{
	
	
	@FXML
    private Button done;

    @FXML
    private TableColumn<Items, Integer> id;

    @FXML
    private TextField itemID;

    @FXML
    private TableColumn<Items, String> name;

    @FXML
    private TableColumn<Items,Float > price;

    @FXML
    private TableColumn<Items, Integer> Quantity;

    @FXML
    private TableView<Items> tableProducts;

    @FXML
    private TableColumn<Items, Float> tax;

    @FXML
    private Button update;
    
    @FXML
    private TextField quantity;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		updateInventory(null);
	}
	
	@FXML
	void done(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("ManagerOperations.fxml");
	}
	@FXML
	void updateInventory(ActionEvent event) {
		Main m = new Main();
		DBInventory dbi=new DBInventory();
		if(!itemID.getText().equals("Item ID") && !quantity.getText().equals("Quantity"))
		{
			dbi.restockItem(itemID.getText().trim(),quantity.getText().trim());
		}
		ArrayList<Items> stu = dbi.readInventory();
		

		if (stu.isEmpty()) {
			//info.setText("No Products registered");
		}

		else {
			final ObservableList<Items> data = FXCollections.observableArrayList(stu);

			// TODO Auto-generated method stub
			
			System.out.println("hello");

			
			id.setCellValueFactory(cellData -> cellData.getValue().getIdOB());
			name.setCellValueFactory(cellData -> cellData.getValue().getNameOB());  //--method 3		
			tax.setCellValueFactory(cellData -> cellData.getValue().gettaxOB());
			price.setCellValueFactory(cellData -> cellData.getValue().getPriceOB());
			Quantity.setCellValueFactory(cellData -> cellData.getValue().getquantityOB());
			
			
			
//			ArrayList<Cashier> cashList=dbc.readCashier();
//			final ObservableList<Cashier> OBlist= FXCollections.observableArrayList(cashList);
//			System.out.println(OBlist.get(0).getName());
//			cashierTable.setItems(OBlist);

			tableProducts.setItems(data);
			
		}
		

	}

    
    
    
    
}
