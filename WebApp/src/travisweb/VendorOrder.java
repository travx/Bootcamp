package travisweb;

import com.datastax.driver.core.Row;

public class VendorOrder {
	private String vendor;
	private String order_id;
	private int quantity;
	private double unit_price;
	private double order_amt;
	public String getVendor() {
		return vendor;
	}
	
	public VendorOrder(Row row){
		this.setVendor(row.getString("vendor"));
		this.setOrder_id(row.getString("order_id"));
		this.setQuantity(row.getInt("quantity"));
		this.setUnit_price(row.getDouble("unit_price"));
		this.setOrder_amt();
	}
	
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public double getOrder_amt() {
		return order_amt;
	}
	public void setOrder_amt() {
		this.order_amt = this.quantity*this.unit_price;
	}
	
	
}
