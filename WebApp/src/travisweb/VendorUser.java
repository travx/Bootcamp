package travisweb;

import com.datastax.driver.core.Row;

public class VendorUser implements Comparable<VendorUser>{
	private String vendor;
	private String user_id;
	private long orders;
	
	public VendorUser(Row row){
		this.setOrders(row.getLong("orders"));
		this.setUser_id(row.getString("user_id"));
		this.setVendor(row.getString("vendor"));
	}
	
	
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public long getOrders() {
		return orders;
	}
	public void setOrders(long orders) {
		this.orders = orders;
	}


	public int compareTo(VendorUser vu) {
		final int LESS=-1;
		final int EQUAL=0;
		final int GREATER=1;
		
		if (this.getOrders() < vu.getOrders()){
			return LESS;
		}

		if (this.getOrders() > vu.getOrders()){
			return GREATER;
		}
		
		return EQUAL;
	}
}
