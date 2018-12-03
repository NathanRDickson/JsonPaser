package main.java.uk.ac.uos.i2p.HTTPTasks;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;



public class GetTasks {
	private static String url;
	public  Map<Object, Object> tasks = new HashMap<Object, Object>();

	public GetTasks(String url) {
		GetTasks.url = url;
	}
	
	  public Map<Object, Object> jsonTask() throws Exception {
	        URL oracle = new URL(url);
	        
	        URLConnection yc = oracle.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
	    		ObjectParser testData = new ObjectParser(inputLine);
	    		Map<Object, Object> jsonItems = testData.jsonObject();
	    		tasks.putAll(jsonItems);
	            System.out.println(inputLine);
	            
	        }
	        in.close();
			
	        return tasks;

	    }
}
