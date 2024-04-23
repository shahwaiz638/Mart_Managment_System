package FXControllers;

import Others.*;
import application.Main;
import DB.*;


import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PaymentController {
	@FXML
    private TextField cardNumber;
	
    @FXML
    private Button go;

    @FXML
    private Button verify;
    
    @FXML
    private Label info;
    
    @FXML
    void verify(ActionEvent event){
    	float balance;
    	PaymentDB pdb= new PaymentDB();
    	String card = cardNumber.getText().trim();
    		if(pdb.verifyItem(card)) {
    			info.setText("Verified");
    			ArrayList<PaymentClass> payment = new ArrayList<PaymentClass>();
    			payment = pdb.readItems();
    			
    			for(int i =0; i<payment.size();i++) {
    				if(payment.get(i).getCardNumber().equals(card)) {
    					balance = payment.get(i).getBalance();
    					Sale s = new Sale();
    					DBSale dbs = new DBSale();
    					s = dbs.readSale();
                        float masterTotal = s.getGrandTax() + s.getGrandTotal(); 
    					if(balance >= masterTotal){
    						System.out.println(masterTotal);
                            balance = balance - masterTotal;
                            System.out.println(balance);
                            pdb.updateBalance(card,balance);
                            info.setText("Operation SuccessFull");
                        } else{
                            info.setText("InSufficient Balance");
                        }
    				}
    			}
    		}else {
    			info.setText("Wrong Input");
    		}
    }

    @FXML
    public void go(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("CashierOperations.fxml");
    }
}
