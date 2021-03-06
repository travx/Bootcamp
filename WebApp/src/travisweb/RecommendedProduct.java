package travisweb;

import com.datastax.driver.core.Row;

public class RecommendedProduct {
	private String recommendation;
	private String product_id;
	private int orders;
	private String product_name;
	
	public RecommendedProduct(Row row){
		this.setOrders(row.getInt("orders"));
		this.setProduct_id(row.getString("product_id"));
		this.setProduct_name(row.getString("product_name"));
		this.setRecommendation(row.getString("recommendation"));
	}
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
