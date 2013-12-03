package travisweb;

import java.util.Date;

import org.joda.time.DateTime;

import com.datastax.driver.core.Row;

public class UserOrder {
	private String user_id;
	private String order_id;
	private DateTime order_time;
	private String product_id;
	private int quantity;
	private String product_name;
	private double unit_price;
	private String vendor;
	private String recommendation;
	private String product_attributes;
	private double order_amt;
	
	public UserOrder(Row row){
		this.setOrder_id(row.getString("order_id"));
		this.setOrder_time(row.getDate("order_time"));
		this.setProduct_attributes(row.getString("product_attributes"));
		this.setProduct_id(row.getString("product_id"));
		this.setProduct_name(row.getString("product_name"));
		this.setQuantity(row.getInt("quantity"));
		this.setRecommendation(row.getString("recommendation"));
		this.setUnit_price(row.getDouble("unit_price"));
		this.setUser_id(row.getString("user_id"));
		this.setVendor(row.getString("vendor"));
		this.setOrder_amt();
	}
	
	public double getOrder_amt() {
		return order_amt;
	}

	public void setOrder_amt() {
		this.order_amt = this.unit_price * this.quantity;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public DateTime getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date date) {
		this.order_time = new DateTime(date);
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getProduct_attributes() {
		return product_attributes;
	}
	public void setProduct_attributes(String product_attributes) {
		this.product_attributes = product_attributes;
	}
	
}
