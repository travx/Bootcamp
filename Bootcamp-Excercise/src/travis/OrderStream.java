package travis;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;


public class OrderStream {
	
	private String order_id;
	private String user_id;
	private String product_id;
	private int quantity;
	private Date order_time;
	
	private Session session;
	private User user;
	private Product product;
	
	private String suggested_product_id;
	
	public OrderStream(Session session){
		this.session = session;
		this.user = new User(this.session);
		this.product = new Product(this.session);
	}
	
	public String getOrderID(){
		return order_id;
	}
	
	public String getUserID(){
		return user_id;
	}
	
	public String getProductID(){
		return product_id;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public BigDecimal getAmount(){
		return product.getUnitPrice().multiply(new BigDecimal(this.getQuantity()));
	}
	
	public Date getOrderTime(){
		return order_time;
	}
	
	public void setOrderID(String order_id){
		this.order_id = order_id;
	}

	public void setUserID(String user_id){
		this.user_id = user_id;
		user.createFromDB(user_id);
	}
	
	public void setProductID(String product_id){
		this.product_id = product_id;
		product.createFromDB(product_id);
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	public void setOrderTime(Date order_time){
		this.order_time = order_time;
	}
	
	public void createFromDB(Row row){
		this.setOrderID(row.getString("order_id"));
		this.setProductID(row.getString("product_id"));
		this.setQuantity(row.getInt("quantity"));
		this.setOrderTime(row.getDate("order_time"));
		this.setUserID(row.getString("user_id"));
		this.setSuggestedProduct();
	}
	
	public void createFromFile(String line) throws ParseException{
    	String[] result = line.split(",");
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
    	this.setOrderID(result[0].trim());
    	this.setUserID(result[1].trim());
    	this.setProductID(result[2].trim());
    	this.setQuantity(Integer.parseInt(result[3].trim()));
    	this.setOrderTime(df.parse(result[4].trim()));		
    	this.setSuggestedProduct();
	}
	
	public void setSuggestedProduct(){
		PreparedStatement statement = session.prepare("select suggested_product_id from suggested_product where product_id = ?");
		this.suggested_product_id = session.execute(statement.bind(this.getProductID())).one().getString("suggested_product_id");
	}
	
	public String getSuggestedProduct(){
		if (this.suggested_product_id == null){
			this.suggested_product_id = "NONE";
		}
		return this.suggested_product_id;
	}

	
	public void writeToDB(){
		Statement statement = QueryBuilder.insertInto("orderstream")
				.value("order_id", this.getOrderID())
				.value("product_id", this.getProductID())
				.value("quantity", this.getQuantity())
				.value("order_time", this.getOrderTime())
				.value("user_id", this.getUserID())
				.value("suggested_product_id", this.getSuggestedProduct());
		session.execute(statement);
				
		writeQuser_orders();
		writeQvendor_orders();
		
		writeQproduct_users();
		writeQproduct_state();
		
		writeQvendor_users();
		writeQtime_orders();
		writeQuser_time_orders();
		
		writeQtime_summary();
		writeQproduct_summary();
		
		writeQuser_products();
	}

	
	private void writeQuser_orders(){
		Statement statement = QueryBuilder.insertInto("user_orders")
				.value("user_id", this.getUserID())
				.value("order_id", this.getOrderID())
				.value("order_time", this.getOrderTime())
				.value("product_id", this.getProductID())
				.value("quantity", this.getQuantity())
				.value("product_name", product.getProductName())
				.value("unit_price", product.getUnitPrice())
				.value("vendor", product.getVendor())
				.value("recommendation", product.getRecommendation())				
				.value("product_attributes", product.getAttributesDBCollection());		
		session.execute(statement);			
	}
	
	
	private void writeQvendor_orders(){
		Statement statement = QueryBuilder.insertInto("vendor_orders")
			.value("vendor", product.getVendor())
			.value("order_id", this.getOrderID())
			.value("order_time", this.getOrderTime())
			.value("product_id", this.getProductID())
			.value("quantity", this.getQuantity())
			.value("product_name", product.getProductName())
			.value("unit_price", product.getUnitPrice())
			.value("recommendation", product.getRecommendation())
			.value("product_attributes", product.getAttributesDBCollection());
		session.execute(statement);
	}


	private void writeQproduct_users(){
		//Statement statement = QueryBuilder.insertInto("product_users")
		//	.value("product_id", this.getProductID())
		//	.value("user_id", this.getUserID());
		//session.execute(statement);
		PreparedStatement statement = session.prepare("update product_users set quantity = quantity+? where product_id = ? and user_id = ?");
		session.execute(statement.bind((long)this.getQuantity(), this.getProductID(), this.getUserID()));			
	}

	private void writeQproduct_state(){
		PreparedStatement statement = session.prepare("update product_state set quantity = quantity+? where product_id = ? and state_name = ?");
		session.execute(statement.bind((long)this.getQuantity(), this.getProductID(), user.getState()));					
	}	
	
	private void writeQvendor_users(){
		//Statement statement = QueryBuilder.insertInto("vendor_users")
		//	.value("vendor", product.getVendor())
		//	.value("user_id", this.getUserID());
		//session.execute(statement);	
		PreparedStatement statement = session.prepare("update vendor_users set orders = orders+1 where vendor = ? and user_id = ?");
		session.execute(statement.bind(product.getVendor(), this.getUserID()));
	}
	
	private void writeQtime_orders(){
		DateTime time = new DateTime(this.order_time);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
		
		Statement statement = QueryBuilder.insertInto("time_orders")
			.value("order_date", time.withMillisOfDay(0).toDate())
			.value("order_date_str", time.withMillisOfDay(0).toString(fmt))
			.value("order_date_hours", hours(time))
			.value("order_seconds", time.getSecondOfDay())
			.value("order_id", this.getOrderID())
			.value("order_amt", this.getAmount());
		session.execute(statement);
	}
	
	
	private int hours(DateTime time){
		return org.joda.time.Hours.hoursBetween(new DateTime("2000-01-01"), time).getHours();	
	}

	
	private void writeQuser_time_orders(){
		DateTime time = new DateTime(this.order_time);
		
		Statement statement = QueryBuilder.insertInto("user_time_orders")
			.value("user_id", this.getUserID())
			.value("order_date", time.withMillisOfDay(0).toDate())
			.value("order_seconds", time.getSecondOfDay())
			.value("order_id", this.getOrderID())
			.value("order_amt", this.getAmount());
		session.execute(statement);
	}
	
	
	private void writeQtime_summary(){
		DateTime time = new DateTime(this.order_time);
		
		PreparedStatement statement = session.prepare("update time_summary set orders = orders + 1 where order_date = ?");
		session.execute(statement.bind(time.withMillisOfDay(0).toDate()));
	}
	
	private void writeQproduct_summary(){
		PreparedStatement statement = session.prepare("update product_summary set orders = orders + 1 where product_id = ?");
		session.execute(statement.bind(product.getProductID()));
	}

	private void writeQuser_products(){
		PreparedStatement statement = session.prepare("update user_products set orders = orders+1 where user_id = ? and product_id = ?");
		session.execute(statement.bind(this.getUserID(), this.getProductID()));
		//Statement statement = QueryBuilder.insertInto("user_products")
		//	.value("product_id", this.getProductID())
		//	.value("user_id", this.getUserID());
	}
	

}
