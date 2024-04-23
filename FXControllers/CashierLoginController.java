package FXControllers;
import java.io.IOException;

import Actors.Cashier;
import DB.*;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CashierLoginController {

    
	 @FXML
    private Button LOGIN;

	@FXML
	private TextField username;
	 
    @FXML
    private TextField password;

 
    @FXML
    void EventHandlerfunction(ActionEvent event) throws IOException {

    	System.out.println("Event occur");    	
        String Username = username.getText().trim();
        String Password = password.getText().trim();   
        
        System.out.println(Username);
        System.out.println(Password);
        
        Main main=new Main();
        Cashier cashier=new Cashier();
        if(!cashier.authenticate(Username, Password))
        {
        	System.out.println("Cashier login successfull");
        	main.changeScene("CashierOperations.fxml");
        }
        else
        {
        	main.changeScene("CashierLogin.fxml");
        }
         
        
    }
    
}
