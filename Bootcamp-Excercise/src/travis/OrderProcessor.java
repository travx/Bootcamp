package travis;

import java.io.IOException;
import java.text.ParseException;

public class OrderProcessor {

	public static void main(String[] args) throws NumberFormatException, ParseException, IOException {
		// TODO Auto-generated method stub
		OrderFile orderfile = new OrderFile("/Users/tprice/Downloads/bootcamp_project_data/order_list_final.csv");
		System.out.println("Connected to order data file.");
				
		DataHelper dh = new DataHelper("172.16.232.129", "store");
		System.out.println("Connected to cluster.");
		
		String strLine = "";
		int limit=2000;
		int counter=0;
		OrderStream order = new OrderStream(dh.getSession());
		
		//Track Account Balances
		Account account = new Account(dh.getSession());
		
		
		System.out.println("Ready to process orders!");
		
		//Jump ahead in the file
		orderfile.skipLines(dh.countProcessedOrders());
		
	    while( ((strLine = orderfile.readLine()) != null) && (counter<limit))
	    {
	    	//debug - output ever 1000th row
	    	if (counter%1000 == 0){
		    	System.out.println(strLine);
	    	}

	    	
	    	order.createFromFile(strLine);
	    	order.writeToDB();
	    	//Update account balance
	    	account.updateBalance(order.getUserID(), order.getAmount());
	    	counter++;
	    }
	    
	    System.out.println("Finished processing orders.");

	}

}
