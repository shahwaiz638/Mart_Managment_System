package FXControllers;

import application.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Actors.*;
import DB.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class SupplierController implements Initializable{

    @FXML
    private TextField supplierCompany;

    @FXML
    private Button add;

    @FXML
    private Button view;

    @FXML
    private TextField supplierID;

    @FXML
    private TextField supplierPhone;

    @FXML
    private TableView<Supplier> supplierTable;

    @FXML
    private TableColumn<Supplier, Integer> idCol;

    @FXML
    private TableColumn<Supplier, String> phoneCol;

    @FXML
    private TableColumn<Supplier, String> companyCol;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

    public void Add(ActionEvent event) throws IOException{
    	System.out.println("Add Button Pressed");

		String id = supplierID.getText().trim();
		String phone = supplierPhone.getText().trim();
		String company = supplierCompany.getText().trim();

		int id1= Integer.parseInt(id);
		Supplier s = new Supplier(id1,company,phone);

		DBSupplier dbs = new DBSupplier();
		dbs.saveSupplier(s);

    }
    
    public void View(ActionEvent event) throws IOException{
    	System.out.println("View Button Pressed");
		
		Main m = new Main();
		DBSupplier dbc=new DBSupplier();
		ArrayList<Supplier> stu = dbc.readSupplier();

		if (stu.isEmpty()) {
			System.out.println("No Supplier Registered");
			//info.setText("No cashiers registered");
		}

		else {
			final ObservableList<Supplier> data = FXCollections.observableArrayList(stu);

			// TODO Auto-generated method stub
			
			System.out.println("hello");


			

			
			idCol.setCellValueFactory(cellData -> cellData.getValue().getIdOB());
			phoneCol.setCellValueFactory(cellData -> cellData.getValue().getPhoneOB());  //--method 3		
			companyCol.setCellValueFactory(cellData -> cellData.getValue().getCompanyOB());
			
			supplierTable.setItems(data);


    }
    }
	
}
