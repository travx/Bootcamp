package travisweb;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.google.gson.Gson;



public class DataHelper {
	
	private String node;
	private String keyspace;
	private Cluster cluster;
	private Session session;
	
	public DataHelper(String node, String keyspace){
		setNode(node);
		setKeyspace(keyspace);
		connect();
	}
	

	public void setNode(String node) {
		this.node = node;
	}

	
	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}	
	
	public void connect() {
		Builder builder = Cluster.builder();
		builder.addContactPoints(node);
		cluster = builder.build();
		session = cluster.connect(keyspace);
	}
	
	public Session getSession(){
		return session;
	}
	
	public int countProcessedOrders(){
		return (int) session.execute("select count(*) from orderstream limit 3000000").one().getLong("count");
	}
	

	public String getMovingAverage(){
		ResultSet results = session.execute("select * from moving_average");
		List<MovingAverage> madata = new ArrayList<MovingAverage>();
		
		for (Row row : results){
			MovingAverage ma = new MovingAverage(row);
			madata.add(ma);
		}
		
		Collections.sort(madata);
		
		return new Gson().toJson(madata);
	}
	
	public String getUserOrders(String user_id){
		PreparedStatement ps = session.prepare("select * from user_orders where user_id = ?");
		ResultSet results = session.execute(ps.bind(user_id));
		List<UserOrder> userorders = new ArrayList<UserOrder>();
		
		for (Row row : results){
			UserOrder uo = new UserOrder(row);
			userorders.add(uo);
		}
		
		return new Gson().toJson(userorders);
	}
	
	public String getVendorOrders(String vendor){
		PreparedStatement ps = session.prepare("select * from vendor_orders where vendor = ?");
		ResultSet results = session.execute(ps.bind(vendor));
		List<VendorOrder> vendororders = new ArrayList<VendorOrder>();
		
		for (Row row : results){
			VendorOrder vo = new VendorOrder(row);
			vendororders.add(vo);
		}
		
		return new Gson().toJson(vendororders);
	}
	
	public String getVendorUsers(String vendor){
		PreparedStatement ps = session.prepare("select * from vendor_users where vendor = ?");
		ResultSet results = session.execute(ps.bind(vendor));
		List<VendorUser> vendorusers = new ArrayList<VendorUser>();
		
		for (Row row : results){
			VendorUser vu = new VendorUser(row);
			vendorusers.add(vu);
		}
		
		Collections.sort(vendorusers);
		Collections.reverse(vendorusers);
		
		return new Gson().toJson(vendorusers);
	}
	
	public String getProductUsers(String product_id){
		PreparedStatement ps = session.prepare("select * from product_users where product_id = ?");
		ResultSet results = session.execute(ps.bind(product_id));
		List<ProductUser> productusers = new ArrayList<ProductUser>();
		
		for (Row row : results){
			ProductUser pu = new ProductUser(row);
			productusers.add(pu);
		}
		
		return new Gson().toJson(productusers);
	}
	
	public String getProductStates(String product_id){
		PreparedStatement ps = session.prepare("select * from product_state where product_id = ?");
		ResultSet results = session.execute(ps.bind(product_id));
		List<ProductState> productstates = new ArrayList<ProductState>();
		
		for (Row row : results){
			ProductState prodstate = new ProductState(row);
			productstates.add(prodstate);
		}
		
		return new Gson().toJson(productstates);
	}
	
	public String getTimeOrders(Date date, int start, int end){
		PreparedStatement ps = session.prepare("select * from time_orders where order_date = ? and order_seconds >= ? and order_seconds <= ? limit 100");
		ResultSet results = session.execute(ps.bind(date, start, end));
		List<TimeOrder> timeorders = new ArrayList<TimeOrder>();
		
		for (Row row : results){
			TimeOrder to = new TimeOrder(row);
			timeorders.add(to);
		}
		
		return new Gson().toJson(timeorders);
	}

	public String getUserTimeOrders(String user_id, Date date, int start, int end){
		PreparedStatement ps = session.prepare("select * from user_time_orders where user_id = ? and order_date = ? and order_seconds >= ? and order_seconds <= ? limit 100");
		ResultSet results = session.execute(ps.bind(user_id, date, start, end));
		List<UserTimeOrder> usertimeorders = new ArrayList<UserTimeOrder>();
		
		for (Row row : results){
			UserTimeOrder uto = new UserTimeOrder(row);
			usertimeorders.add(uto);
		}
		
		return new Gson().toJson(usertimeorders);
	}	
	
	public String getRecommendations(){
		ResultSet results = session.execute("select * from recommendation_summary");
		List<Recommendation> rlist = new ArrayList<Recommendation>();
		
		for (Row row : results){
			Recommendation r = new Recommendation(row);
			rlist.add(r);
		}
		
		return new Gson().toJson(rlist);		
	}
	
	public String getRecommendationsHive(){
		ResultSet results = session.execute("select * from recommendation_summary_hive");
		List<Recommendation> rlist = new ArrayList<Recommendation>();
		
		for (Row row : results){
			Recommendation r = new Recommendation(row);
			rlist.add(r);
		}
		
		return new Gson().toJson(rlist);		
	}
	
	public String getVendorRecommendations(){
		ResultSet results = session.execute("select * from vendor_recommendation_summary limit 200");
		List<VendorRecommendation> vrlist = new ArrayList<VendorRecommendation>();
		
		for (Row row : results){
			VendorRecommendation vr = new VendorRecommendation(row);
			vrlist.add(vr);
		}
		
		return new Gson().toJson(vrlist);		
	}
	
	public String getRecommendedProducts(){
		ResultSet results = session.execute("select * from hr_products where recommendation='highly recommend' limit 20;");
		List<RecommendedProduct> rplist = new ArrayList<RecommendedProduct>();
		
		for (Row row : results){
			RecommendedProduct rp = new RecommendedProduct(row);
			rplist.add(rp);
		}
		
		return new Gson().toJson(rplist);				
	}

	public String getVendorRecommendedProducts(String vendor){
		PreparedStatement ps = session.prepare("select * from vendor_hr_products where vendor = ? limit 20;");
		ResultSet results = session.execute(ps.bind(vendor));
		List<VendorRecommendedProduct> vrplist = new ArrayList<VendorRecommendedProduct>();
		
		for (Row row : results){
			VendorRecommendedProduct vrp = new VendorRecommendedProduct(row);
			vrplist.add(vrp);
		}
		
		return new Gson().toJson(vrplist);				
	}
}

