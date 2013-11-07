package travis;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;

import com.datastax.driver.core.Session;



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
	
}

