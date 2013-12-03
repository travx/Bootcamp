package travisweb;

import java.io.FileInputStream;
import java.io.IOException;


public class FileManager {
	private static String strPath = "/Users/tprice/Documents/workspace/WebApp/html/";
	private static String strHeader = "header.html";
	private static String strFooter = "footer.html";
	
	public String getHeader(){
		return getFile(strHeader);
	}
	
	public String getFooter(){
		return getFile(strFooter);
	}

	
	private String getFile(String strFilename){
		try {
			return readFile(strPath + strFilename);
		} catch (IOException e) {
			return "Error reading file";
		}
	}
	
	private String readFile(String strFile) throws IOException{
		FileInputStream input = new FileInputStream(strFile);
		byte[] fileData = new byte[input.available()];
		input.read(fileData);
		input.close();
		return new String(fileData, "UTF-8");
	}
	

}
