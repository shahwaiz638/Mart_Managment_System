package FXControllers;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.io.IOException;
import Actors.*;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddCashierController {

	
	@FXML
    private Button addcashierbutton;

    @FXML
    private TextField address;

    @FXML
    private Button back;
    
    @FXML
    private TextField cnic;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;

    @FXML
    private Label promptmsg;

    @FXML
    private TextField username;
    
    private Manager manager=new Manager();
    
    public void addCashier() throws IOException
    {
    	int size=manager.getCashierList().size();
    	int id=manager.getCashierList().get(size-1).getId();
    	manager.addCashierToDB(++id, name.getText().trim(), phone.getText().trim(), cnic.getText().trim(), username.getText().trim(), password.getText().trim());
    }
    
    public void backbutton() throws IOException
    {
    	Main main=new Main();
    	main.changeScene("ManagerOperations.fxml");
    }
    
    
    
}
