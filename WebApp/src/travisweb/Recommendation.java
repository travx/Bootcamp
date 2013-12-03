package travisweb;

import com.datastax.driver.core.Row;

public class Recommendation {
	private String recommendation;
	private long num_products;
	
	public Recommendation(Row row){
		this.setNum_products(row.getLong("num_products"));
		this.setRecommendation(row.getString("recommendation"));
	}
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public long getNum_products() {
		return num_products;
	}
	public void setNum_products(long num_products) {
		this.num_products = num_products;
	}
	
}
