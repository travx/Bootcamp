package travisweb;

public class IOstatDevice {
	private String Device;
	private double rrqm_s;
	private double wrqm_s;
	private double r_s;
	private double w_s;
	private double rMB_s;
	private double wMB_s;
	private double avgrq_sz;
	private double avgqu_sz;
	private double await;
	private double svctm;
	private double util;
	
	public IOstatDevice(String data){
		String[] tokens = data.split("\\s+");
		
		this.setDevice(tokens[0]);
		this.setRrqm_s(Double.parseDouble(tokens[1]));
		this.setWrqm_s(Double.parseDouble(tokens[2]));
		this.setR_s(Double.parseDouble(tokens[3]));
		this.setW_s(Double.parseDouble(tokens[4]));
		this.setrMB_s(Double.parseDouble(tokens[5]));
		this.setwMB_s(Double.parseDouble(tokens[6]));
		this.setAvgrq_sz(Double.parseDouble(tokens[7]));
		this.setAvgqu_sz(Double.parseDouble(tokens[8]));
		this.setAwait(Double.parseDouble(tokens[9]));
		this.setSvctm(Double.parseDouble(tokens[10]));
		this.setUtil(Double.parseDouble(tokens[11]));
	}
	
	public String getDevice() {
		return Device;
	}
	public void setDevice(String device) {
		Device = device;
	}
	public double getRrqm_s() {
		return rrqm_s;
	}
	public void setRrqm_s(double rrqm_s) {
		this.rrqm_s = rrqm_s;
	}
	public double getWrqm_s() {
		return wrqm_s;
	}
	public void setWrqm_s(double wrqm_s) {
		this.wrqm_s = wrqm_s;
	}
	public double getR_s() {
		return r_s;
	}
	public void setR_s(double r_s) {
		this.r_s = r_s;
	}
	public double getW_s() {
		return w_s;
	}
	public void setW_s(double w_s) {
		this.w_s = w_s;
	}
	public double getrMB_s() {
		return rMB_s;
	}
	public void setrMB_s(double rMB_s) {
		this.rMB_s = rMB_s;
	}
	public double getwMB_s() {
		return wMB_s;
	}
	public void setwMB_s(double wMB_s) {
		this.wMB_s = wMB_s;
	}
	public double getAvgrq_sz() {
		return avgrq_sz;
	}
	public void setAvgrq_sz(double avgrq_sz) {
		this.avgrq_sz = avgrq_sz;
	}
	public double getAvgqu_sz() {
		return avgqu_sz;
	}
	public void setAvgqu_sz(double avgqu_sz) {
		this.avgqu_sz = avgqu_sz;
	}
	public double getAwait() {
		return await;
	}
	public void setAwait(double await) {
		this.await = await;
	}
	public double getSvctm() {
		return svctm;
	}
	public void setSvctm(double svctm) {
		this.svctm = svctm;
	}
	public double getUtil() {
		return util;
	}
	public void setUtil(double util) {
		this.util = util;
	}
	
}
