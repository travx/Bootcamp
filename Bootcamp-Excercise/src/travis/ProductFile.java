package travis;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import travis.Product;
import au.com.bytecode.opencsv.CSVReader;

import com.datastax.driver.core.Session;


public class ProductFile {
	
	private String strFile;
	private String[] strLine;
	
	private Product product;
	private Session session;
	private CSVReader reader;
	
	public ProductFile(String file, Session session) throws FileNotFoundException{
		this.strFile = file;
		this.session = session;
		this.reader = new CSVReader( new FileReader(strFile));
	}

	public List<Product> ProcessFile() throws IOException{
	    List<Product> productset = new ArrayList<Product>();
	    
	    while( (strLine = reader.readNext()) != null)
	    {
	    	product = new Product(session);
	            
	        product.setProductName(strLine[0]);
	        product.setUnitPrice(strLine[1]);
	        product.setVendor(strLine[2]);
	        product.setProductID(strLine[3]);
	        product.setRecommendation(strLine[4]);
	            
	        for (int x=5; x<strLine.length; x++){
	        	product.addAttribute(strLine[x]);
	        }
	        
	        productset.add(product);
	           	              
	    }
	    
	    return productset;
		
	}   

}
