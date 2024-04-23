package FXControllers;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.io.IOException;
import Actors.*;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddSupplierController {

	
	@FXML
    private Button addSupplierbutton;

    @FXML
    private Button back;
    

    @FXML
    private TextField name;


    @FXML
    private TextField phone;


    
    private Manager manager=new Manager();
    
    public void addSupplier() throws IOException
    {
    	int size=manager.getCashierList().size();
    	int id=manager.getCashierList().get(size-1).getId();
    	manager.addSupplierToDB(++id, name.getText().trim(), phone.getText().trim());
    	}
    
    public void backbutton() throws IOException
    {
    	Main main=new Main();
    	main.changeScene("ManagerOperations.fxml");
    }
    
    
    
}
