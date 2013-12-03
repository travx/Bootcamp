package travisweb;

public class TPmessage {
	private String MessageType;           
	private int Dropped;
	
	public TPmessage(String data){
		String[] tokens = data.split("\\s+");
		
		this.setMessageType(tokens[0]);
		this.setDropped(Integer.parseInt(tokens[1]));
	}
	
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}
	public int getDropped() {
		return Dropped;
	}
	public void setDropped(int dropped) {
		Dropped = dropped;
	}
	
	
}
