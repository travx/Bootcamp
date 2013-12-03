package travisweb;

public class CFHistogram {
	private int Offset;
	private int SSTables;
	private int WriteLatency;
	private int ReadLatency;
	private int RowSize;      
	private int ColumnCount;
	
	public CFHistogram(String data){
		String[] tokens = data.split("\\s+");

		this.setOffset(Integer.parseInt(tokens[0]));
		this.setSSTables(Integer.parseInt(tokens[1]));
		this.setWriteLatency(Integer.parseInt(tokens[2]));
		this.setReadLatency(Integer.parseInt(tokens[3]));
		this.setRowSize(Integer.parseInt(tokens[4]));
		this.setColumnCount(Integer.parseInt(tokens[5]));
	}
	
	public int getOffset() {
		return Offset;
	}
	public void setOffset(int offset) {
		Offset = offset;
	}
	public int getSSTables() {
		return SSTables;
	}
	public void setSSTables(int sSTables) {
		SSTables = sSTables;
	}
	public int getWriteLatency() {
		return WriteLatency;
	}
	public void setWriteLatency(int writeLatency) {
		WriteLatency = writeLatency;
	}
	public int getReadLatency() {
		return ReadLatency;
	}
	public void setReadLatency(int readLatency) {
		ReadLatency = readLatency;
	}
	public int getRowSize() {
		return RowSize;
	}
	public void setRowSize(int rowSize) {
		RowSize = rowSize;
	}
	public int getColumnCount() {
		return ColumnCount;
	}
	public void setColumnCount(int columnCount) {
		ColumnCount = columnCount;
	}
}
