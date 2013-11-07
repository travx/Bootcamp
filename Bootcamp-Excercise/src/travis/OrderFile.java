package travis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class OrderFile {
	private String strFile;
	
	private BufferedReader br;


	public OrderFile(String file) throws FileNotFoundException{
		this.strFile = file;
		this.br = new BufferedReader( new FileReader(strFile));
	}	
	
	public String readLine() throws IOException{
		return br.readLine();
	}
	
	public void skipLines(int numlines) throws IOException{
		//Jumps ahead in the file, allowing for stop & restart of the load process
		System.out.println("Skipping " + numlines + " lines.");
		for (int i=0; i<numlines; i++){
			br.readLine();
		}
	}
	
}
