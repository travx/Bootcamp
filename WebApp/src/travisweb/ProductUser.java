package travisweb;

import com.datastax.driver.core.Row;

public class ProductUser {
	private String product_id;
	private String user_id;
	private long quantity;
	
	public ProductUser(Row row){
		this.setProduct_id(row.getString("product_id"));
		this.setQuantity(row.getLong("quantity"));
		this.setUser_id(row.getString("user_id"));
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
