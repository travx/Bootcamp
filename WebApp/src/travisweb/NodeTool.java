package travisweb;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class NodeTool {
	private static String cmd_cfhistogram = "nodetool cfhistograms KS CF";
	private static String cmd_tpstats = "nodetool tpstats";
	private static String cmd_iostat = "iostat -xmt";
	
	public String cfHistogram(String keyspace, String table){
		List<String> results = null;
		List<CFHistogram> cfhistograms = new ArrayList<CFHistogram>();
		
		try {
			results = runOS(cmd_cfhistogram.replace("KS", keyspace).replace("CF", table));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String result:results.subList(2, results.size())){ //skip first two rows
			CFHistogram cfh = new CFHistogram(result);
			cfhistograms.add(cfh);
		}
		
		return new Gson().toJson(cfhistograms);
	}
	
	public String tpMessage(){
		List<String> results = null;
		List<TPmessage> tpmsgs = new ArrayList<TPmessage>();
		
		try {
			results = runOS(cmd_tpstats);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String result:results.subList(18, 24)){ 
			TPmessage tp = new TPmessage(result);
			tpmsgs.add(tp);
		}
		
		return new Gson().toJson(tpmsgs);		
	}
	
	public String tpPool(){
		List<String> results = null;
		List<TPpool> tppools = new ArrayList<TPpool>();
		
		try {
			results = runOS(cmd_tpstats);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String result:results.subList(1, 15)){ 
			TPpool tp = new TPpool(result);
			tppools.add(tp);
		}
		
		return new Gson().toJson(tppools);
	}
	
	public String iostatCPU(){
		List<String> results = null;
		List<IOstatCPU> iostatcpu = new ArrayList<IOstatCPU>();
		
		try {
			results = runOS(cmd_iostat);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String result:results.subList(4, 5)){ 
			//System.out.println(result);
			IOstatCPU cpu = new IOstatCPU(result);
			iostatcpu.add(cpu);
		}
		
		return new Gson().toJson(iostatcpu);
	}
	
	public String iostatDevice(){
		List<String> results = null;
		List<IOstatDevice> iostatdevice = new ArrayList<IOstatDevice>();
		
		try {
			results = runOS(cmd_iostat);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String result:results.subList(7, results.size()-1)){ 
			//System.out.println(result);
			IOstatDevice device = new IOstatDevice(result);
			iostatdevice.add(device);
		}
		
		return new Gson().toJson(iostatdevice);
	}
	
	
	private List<String> runOS(String command) throws IOException, InterruptedException{
		ProcessBuilder pb = new ProcessBuilder("ssh", 
                "root@debian1", 
                command);
		pb.redirectErrorStream(); //redirect stderr to stdout

		Process p = pb.start();
		p.waitFor();
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		List<String> results = new ArrayList<String>();
		String line = "";

		while ((line = b.readLine()) != null) {
			  results.add(line.trim());
			  //System.out.println(line);
			}
		
		//debug
		//System.out.println(command);
		//System.out.println(results.toString());
		
		return results;
	}		
}

