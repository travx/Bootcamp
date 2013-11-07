package travis;


import java.io.IOException;
import java.util.List;


public class ProductLoader {

	public static void main(String[] args) throws IOException {
		DataHelper dh = new DataHelper("172.16.232.129", "store");
		System.out.println("Connected to the cluster!");		
		
		ProductFile productfile = new ProductFile("/Users/tprice/Downloads/bootcamp_project_data/product_list_final.csv", dh.getSession());	
		System.out.println("Successfully connected to file.");
		
		List<Product> productset = productfile.ProcessFile();
		System.out.println("Successfully loaded file.");
		

		for (Product prod: productset){
			prod.writeToDB();
		}
		
		System.out.println("Finished loading products.");
		
	}
}



