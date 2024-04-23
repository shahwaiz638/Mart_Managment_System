package FXControllers;

//import javafx.scene.control.Label;

//import javafx.scene.control.TextField;
import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManagerOperationController {

    @FXML
    private Button activate;

    @FXML
    private Button deactivate;

    @FXML
    private Button addcashier;

    @FXML
    private Button removecashier;

    @FXML
    private Button addsupplier;

    @FXML
    private Button viewinventory;
    
    
    //All Button Functions
    public void ActivateSystem() throws IOException{
    	Main m=new Main();
    	m.changeScene("CashierLogin.fxml");
    	
    }
    
    public void deactivate() throws IOException{
    	Main m=new Main();
    	m.changeScene("Sample.fxml");  
    }
    
    public void addCashier() throws IOException{
    	System.out.println("AddCashier");
    	Main m=new Main();
//    	m.changeScene("AddCashier.fxml");
        m.changeScene("AddCashier.fxml");
    }
    
    public void veiwCashiers() throws IOException{
    	System.out.println("RemoveCashier");
    	Main m=new Main();
        m.changeScene("ViewCashiers.fxml");
    } 
    
    public void removeCashier() throws IOException{
    	System.out.println("RemoveCashier");
    	Main m=new Main();
//    	m.changeScene("RemoveCashier.fxml");
        m.changeScene("RemoveCashier.fxml");
    }    
    
    public void addSupplier() throws IOException{
    	Main m=new Main();
        m.changeScene("AddSupplier.fxml");

    }
    
    public void viewInventory() throws IOException{
    	Main m=new Main();
        m.changeScene("ViewInventory.fxml");

    }
    public void cashierLogin() throws IOException{
    	Main m=new Main();
    	m.changeScene("CashierLogin.fxml");
    }

    public void Supplier() throws IOException{
        Main m = new Main();
        m.changeScene("Supplier.fxml");
    }
}
