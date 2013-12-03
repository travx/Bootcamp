package travisweb;

import org.joda.time.DateTime;

import com.datastax.driver.core.Row;

public class UserTimeOrder {
	private String user_id;
	private DateTime order_date;
	private int order_seconds;
	private String order_id;
	private double order_amt;
	
	public UserTimeOrder(Row row){
		this.setUser_id(row.getString("user_id"));
		this.setOrder_amt(row.getDouble("order_amt"));
		this.setOrder_date(new DateTime(row.getDate("order_date")));
		this.setOrder_id(row.getString("order_id"));
		this.setOrder_seconds(row.getInt("order_seconds"));
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public DateTime getOrder_date() {
		return order_date;
	}
	public void setOrder_date(DateTime order_date) {
		this.order_date = order_date;
	}
	public int getOrder_seconds() {
		return order_seconds;
	}
	public void setOrder_seconds(int order_seconds) {
		this.order_seconds = order_seconds;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public double getOrder_amt() {
		return order_amt;
	}
	public void setOrder_amt(double order_amt) {
		this.order_amt = order_amt;
	}
	
}
