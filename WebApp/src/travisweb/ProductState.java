package travisweb;

import com.datastax.driver.core.Row;

public class ProductState {
	private String product_id;
	private String state_name;
	private long quantity;
	
	public ProductState(Row row){
		this.setProduct_id(row.getString("product_id"));
		this.setQuantity(row.getLong("quantity"));
		this.setState_name(row.getString("state_name"));
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
}
