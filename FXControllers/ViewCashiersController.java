package FXControllers;

import DB.*;
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

public class ViewCashiersController implements Initializable{
	
	
	@FXML
	private Button backButton;
	@FXML
	private Button viewButton;

	

	@FXML
	private Label info;
	
	@FXML
	private TableView<Cashier> cashierTable ;
	
	@FXML
    private TableColumn<Cashier,Integer> id;
	
	@FXML
    private TableColumn<Cashier,String> name;
	
	@FXML
    private TableColumn<Cashier,String> cnic;
	@FXML
    private TableColumn<Cashier,String> password;
	
	@FXML
    private TableColumn<Cashier,String> username;
	
	@FXML
    private TableColumn<Cashier,String> phone;
	
	
	
	

	
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	@FXML
	void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("ManagerOperations.fxml");
	}
	@FXML
	void View(ActionEvent event) {
		Main m = new Main();
		DBCashier dbc=new DBCashier();
		ArrayList<Cashier> stu = dbc.readCashier();

		if (stu.isEmpty()) {
			info.setText("No cashiers registered");
		}

		else {
			final ObservableList<Cashier> data = FXCollections.observableArrayList(stu);

			// TODO Auto-generated method stub
			
			System.out.println("hello");

			
			id.setCellValueFactory(cellData -> cellData.getValue().getIdOB());
			name.setCellValueFactory(cellData -> cellData.getValue().getNameOB());  //--method 3		
			phone.setCellValueFactory(cellData -> cellData.getValue().getPhoneOB());
			cnic.setCellValueFactory(cellData -> cellData.getValue().getCNICOB());
			username.setCellValueFactory(cellData -> cellData.getValue().getUsernameOB());
			password.setCellValueFactory(cellData -> cellData.getValue().getPasswordOB());
			
			
			
//			ArrayList<Cashier> cashList=dbc.readCashier();
//			final ObservableList<Cashier> OBlist= FXCollections.observableArrayList(cashList);
//			System.out.println(OBlist.get(0).getName());
//			cashierTable.setItems(OBlist);

			cashierTable.setItems(data);
			
		}
		

	}

    
    
    
    
}
