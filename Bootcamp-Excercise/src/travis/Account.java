package travis;

import java.math.BigDecimal;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class Account {

	private String account_id;
	private String user_id;
	private BigDecimal balance;
	private PreparedStatement selectstatement;
	private PreparedStatement updatestatement;
	
	private Session session;

	
	public Account(Session session){
		this.session = session;
		this.selectstatement = session.prepare("select * from account where account_id = ?");
		this.updatestatement = session.prepare("update account set balance = ? where account_id = ?");
	}	
	
	public String getAccount(){
		return account_id;
	}
	
	public String getUser(){
		return user_id;
	}
	
	public BigDecimal getBalance(){
		return balance;
	}
	
	public void setAccount(String setAccount_id){
		this.account_id = setAccount_id;
	}
	
	public void setUser(String setUser_id){
		this.user_id = setUser_id;
	}
	
	public void setBalance(BigDecimal setBalance){
		this.balance = setBalance;
	}
	
	public void createFromDB(Row row){
		this.setAccount(row.getString("account_id"));
		this.setBalance(row.getDecimal("balance"));
		this.setUser(row.getString("user_id"));
	}
	
	private String getAccountFromUser(String user_id){
		return user_id.replace("U", "A");
	}
	
	public void updateBalance(String user_id, BigDecimal order_amt){
		//retrieve current account balance
		this.createFromDB(session.execute(selectstatement.bind(this.getAccountFromUser(user_id))).one());
		//update with new balance
		session.execute(updatestatement.bind(this.getBalance().add(order_amt), this.getAccount()));
	}
}
