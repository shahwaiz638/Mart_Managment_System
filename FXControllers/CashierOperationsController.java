package FXControllers;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.io.IOException;
import Actors.*;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CashierOperationsController {


	private static int totalID=1;
    @FXML
    private Button back;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField cnic;

    @FXML
    private TextField address;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button addcashierbutton;

    @FXML
    private Label promptmsg;
    
  

    public void returnSale() throws IOException{
    	Main m = new Main();
    	m.changeScene("ReturnSale.fxml");
    }
    
    public void startSale() throws IOException{
    	Main m = new Main();
        m.changeScene("CustomerData.fxml");  
    }
    public void logout() throws IOException{
    	Main m=new Main();
        m.changeScene("CashierLogin.fxml");
    }
}
