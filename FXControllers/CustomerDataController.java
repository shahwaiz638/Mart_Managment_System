package FXControllers;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import DB;
import Actors.Customer;
import DB.DBCustomer;
import DB.DBSale;
import Others.Sale;

public class CustomerDataController {

	@FXML
	private TextField number;

	@FXML
	private Button enter;
	
	private int custID;
	
	private DBSale dbs= new DBSale();
	
	@FXML
	public void enterButton() throws IOException {
		System.out.println("Enter Button Pressed");
		String data = number.getText().trim();
		System.out.println(data);

        //Customer DB Implementation
        
        boolean check=false;
        DBCustomer dbc = new DBCustomer();
        ArrayList<Customer> arrCust = new  ArrayList<Customer>();
        arrCust= dbc.readCustomer();
        for(int i=0; i<arrCust.size();i++){
            if(data == arrCust.get(i).getPhone()){
                check = true;
                custID = arrCust.get(i).getId();
            }
            
            custID = arrCust.get(i).getId();
        }

        if(check)
        {
        	dbc.saveCustomer(new Customer(0,data));
        }
        else {
        	
        }
        	
        

        //-------------------------------------

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date(System.currentTimeMillis());  
        String dateStr = df.format(date);
        
        Sale s = new Sale(0,custID,dateStr,(float)0,(float)0);
        
        dbs.saveSale(s);
        
       
        Main m = new Main();
       m.changeScene("StartSale.fxml");
        //String stime=DateFormat.getDateTimeInstance().format(arrContact.get(position).Currenttime);
}
}
