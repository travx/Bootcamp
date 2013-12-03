package travisweb;

public class TPpool {
	private String PoolName;
	private int Active;
	private int Pending;
	private int Completed;
	private int Blocked;
	private int AllTimeBlocked;
	
	public TPpool(String data){
		String[] tokens = data.split("\\s+");
		
		this.setPoolName(tokens[0]);
		this.setActive(Integer.parseInt(tokens[1]));
		this.setPending(Integer.parseInt(tokens[2]));
		this.setCompleted(Integer.parseInt(tokens[3]));
		this.setBlocked(Integer.parseInt(tokens[4]));
		this.setAllTimeBlocked(Integer.parseInt(tokens[5]));
	}
	
	public String getPoolName() {
		return PoolName;
	}
	public void setPoolName(String poolName) {
		PoolName = poolName;
	}
	public int getActive() {
		return Active;
	}
	public void setActive(int active) {
		Active = active;
	}
	public int getPending() {
		return Pending;
	}
	public void setPending(int pending) {
		Pending = pending;
	}
	public int getCompleted() {
		return Completed;
	}
	public void setCompleted(int completed) {
		Completed = completed;
	}
	public int getBlocked() {
		return Blocked;
	}
	public void setBlocked(int blocked) {
		Blocked = blocked;
	}
	public int getAllTimeBlocked() {
		return AllTimeBlocked;
	}
	public void setAllTimeBlocked(int allTimeBlocked) {
		AllTimeBlocked = allTimeBlocked;
	}
}
