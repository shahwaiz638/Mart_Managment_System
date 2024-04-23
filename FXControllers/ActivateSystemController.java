package FXControllers;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.io.IOException;
import Actors.*;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ActivateSystemController {

	
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button login;    

    private Cashier cashier=new Cashier();

    public void EventHandlerfunction() throws IOException
    {
    	System.out.println("Event occur");    	
        String text = username.getText();
        String text1 = password.getText();        
        System.out.println(text);
        System.out.println(text1);
        Main main=new Main();
        if(cashier.authenticate(text, text1))
        {
        	main.changeScene("StartSale.fxml");
        }
        else
        {
        	main.changeScene("ActivateSystem.fxml");
        }
         
        
    }
}
