package FXControllers;
import DB.*;

import application.Main;
import Actors.*;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SampleController {

	@FXML
    private Button signup;
    
	@FXML
    private Button LOGIN;
    
	 @FXML
	 private TextField user;

	 @FXML
	 private TextField pass;
	 
	 private Manager manager=new Manager();
	 
    public void EventHandlerfunction() throws IOException
    {
    	System.out.println("Event occur");    	
        String text = user.getText();
        String text1 = pass.getText();        
        System.out.println(text);
        System.out.println(text1);
        Main main=new Main();
        if(!manager.authenticate(text, text1))
        {
        	main.changeScene("ManagerOperations.fxml");
        }
        else
        {
        	main.changeScene("Sample.fxml");
        }
         
        
    }
    
}
