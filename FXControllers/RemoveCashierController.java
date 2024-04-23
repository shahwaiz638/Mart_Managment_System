package FXControllers;
import DB.*;
import application.Main;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RemoveCashierController {
	 @FXML
	    private Button back;

	    @FXML
	    private TextField username;

	    @FXML
	    private Button verify;

	    @FXML
	    private Button removecashierbutton;

	    @FXML
	    private Label promptmsg;

	    @FXML
	    private Label promptmsg1;
	    
	    private DBCashier dbc=new DBCashier();

	    public void backbutton() throws IOException{
	        Main m = new Main();
	        m.changeScene("ManagerOperations.fxml");
	    }
	    public void removeCashier() throws IOException{
	    	System.out.println("Removing Cashier....");
	    	dbc.deleteCashier(username.getText().trim());
	    	Main m=new Main();
	        m.changeScene("ManagerOperations.fxml");
	    }
	    public void verifyCashier() throws IOException{
	    	System.out.println("verifyCashier");
	    	dbc.verifyCashier(username.getText().trim());
	    	Main m=new Main();
//	    	m.changeScene("AddCashier.fxml");
	        //m.changeScene("AddCashier.fxml");
	    }
}
