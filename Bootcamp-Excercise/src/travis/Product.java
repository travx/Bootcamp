package travis;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;


public class Product {

	private String product_name;
	private BigDecimal unit_price;
	private String vendor;
	private String product_id;
	private String recommendation;
	private SortedSet<String> attributes;
	private Session session;
	
	public Product(Session session){
		this.session = session;
		attributes = new TreeSet<String>();
	}
	
	
	public String getProductName(){
		return product_name;
	}
	
	public BigDecimal getUnitPrice(){
		return unit_price;
	}
	
	public String getVendor(){
		return vendor;
	}
	
	
	public String getProductID(){
		return product_id;
	}
	
	public String getRecommendation(){
		return recommendation;
	}
	
	public SortedSet<String> getAttributes(){
		return attributes;
	}
	
	public String getAttributesDBCollection(){
		String attributeslist = "";
		
		for (String attribute : attributes){
			attributeslist = attributeslist + " " + attribute;
			
			if (attribute != attributes.last()){
				attributeslist = attributeslist + ",";
			}
		}
				
		return attributeslist.trim();
	}

	
	public void setProductName(String set_product_name){
		this.product_name = set_product_name;
	}
	
	public void setUnitPrice(BigDecimal set_unit_price){
		this.unit_price = set_unit_price;
	}

	public void setUnitPrice(String set_unit_price){
		this.unit_price = new BigDecimal(set_unit_price);
	}
	
	public void setVendor(String set_vendor){
		this.vendor = set_vendor;
	}
	
	public void setProductID(String set_product_id){
		this.product_id = set_product_id;
	}
	
	public void setRecommendation(String set_recommendation){
		this.recommendation = set_recommendation;
	}
	
	public void setAttributes(SortedSet<String> set_attributes){
		this.attributes = set_attributes;
	}
	
	public void setAttributes(Collection<String> list_attributes){
		this.attributes = new TreeSet<String>(list_attributes);
	}

	public void addAttribute(String attribute){
		attributes.add(attribute);
	}
	
	public void createFromDB(Row row){
		if (row != null){
			this.setAttributes(row.getSet("attributes", String.class));
			this.setProductName(row.getString("product_name"));
			this.setUnitPrice(row.getDecimal("unit_price"));
			this.setVendor(row.getString("vendor"));
			this.setRecommendation(row.getString("recommendation"));
		}
		else{
			//debug
			//System.out.println("Product not found.");
			clearData();
			this.setProductName("NO PRODUCT FOUND");
			this.setVendor("UNKNOWN VENDOR");
		}
	}
	
	
	public void createFromDB(String product_id){
		PreparedStatement statement = session.prepare("select * from product where product_id = ?");
		ResultSet results = session.execute(statement.bind(product_id));
		this.setProductID(product_id);
		createFromDB(results.one());				
	}
	
	
	public void writeToDB(){
		Statement statement = QueryBuilder.insertInto("product")
				.value("product_name", this.getProductName())
				.value("unit_price", this.getUnitPrice())
				.value("vendor", this.getVendor())
				.value("product_id", this.getProductID())
				.value("recommendation", this.getRecommendation())
				.value("attributes", this.getAttributes());		
		session.execute(statement);	
		
		statement = QueryBuilder.insertInto("recommendations")
				.value("recommendation", this.getRecommendation())
				.value("product_id", this.getProductID());
		session.execute(statement);

		statement = QueryBuilder.insertInto("vendor_recommendations")
				.value("recommendation", this.getRecommendation())
				.value("vendor", this.getVendor())
				.value("product_id", this.getProductID());
		session.execute(statement);		
		
		PreparedStatement psRS = session.prepare("update recommendation_summary set num_products = num_products + 1 where recommendation = ?");
		session.execute(psRS.bind(this.getRecommendation()));
		
		PreparedStatement psVRS = session.prepare("update vendor_recommendation_summary set num_products = num_products + 1 where recommendation = ? and vendor = ?");
		session.execute(psVRS.bind(this.getRecommendation(), this.getVendor()));
	}
	
	
	public void clearData(){
		this.attributes = new TreeSet<String>();
		
		this.setProductName("");
		this.setUnitPrice(new BigDecimal(0));
		this.setVendor("");
		this.setRecommendation("Unknown");
	}
	
}
