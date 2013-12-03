package travisweb;

import com.datastax.driver.core.Row;

public class VendorRecommendation {
	private String recommendation;
	private String vendor;
	private long num_products;
	
	public VendorRecommendation(Row row){
		this.setNum_products(row.getLong("num_products"));
		this.setRecommendation(row.getString("recommendation"));
		this.setVendor(row.getString("vendor"));
	}
	
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public long getNum_products() {
		return num_products;
	}
	public void setNum_products(long num_products) {
		this.num_products = num_products;
	}
	
}
