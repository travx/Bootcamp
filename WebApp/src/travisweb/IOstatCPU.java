package travisweb;

public class IOstatCPU {
	private double user;   
	private double nice;
	private double system; 
	private double iowait;
	private double steal;
	private double idle;
	
	public IOstatCPU(String data){
		String[] tokens = data.split("\\s+");
		
		this.setUser(Double.parseDouble(tokens[0]));
		this.setNice(Double.parseDouble(tokens[1]));
		this.setSystem(Double.parseDouble(tokens[2]));
		this.setIowait(Double.parseDouble(tokens[3]));
		this.setSteal(Double.parseDouble(tokens[4]));
		this.setIdle(Double.parseDouble(tokens[5]));
	}
	
	public double getUser() {
		return user;
	}
	public void setUser(double user) {
		this.user = user;
	}
	public double getNice() {
		return nice;
	}
	public void setNice(double nice) {
		this.nice = nice;
	}
	public double getSystem() {
		return system;
	}
	public void setSystem(double system) {
		this.system = system;
	}
	public double getIowait() {
		return iowait;
	}
	public void setIowait(double iowait) {
		this.iowait = iowait;
	}
	public double getSteal() {
		return steal;
	}
	public void setSteal(double steal) {
		this.steal = steal;
	}
	public double getIdle() {
		return idle;
	}
	public void setIdle(double idle) {
		this.idle = idle;
	}
	
	
}
