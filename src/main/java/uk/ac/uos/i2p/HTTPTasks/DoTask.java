package main.java.uk.ac.uos.i2p.HTTPTasks;
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
*/
import java.util.HashMap;
import java.util.Map;

import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;

public class DoTask {
	private static String url;
	public  Map<Object, Object> tasks = new HashMap<Object, Object>();

	public DoTask(String url) {
		DoTask.url = url;
	}
	
	
	  public Map<Object, Object> jsonTask() throws Exception {
	        //URL oracle = new URL("{\"instruction\": \"add\",\"parameters\": [\"23\",45],\"response URL\": \"/answer/d3ae45\"}");
	        
	        //URLConnection yc = oracle.openConnection();
	        //BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	        
	       // String inputLine;
	        //while ((inputLine = in.readLine()) != null) {
	    		ObjectParser testData = new ObjectParser("{\"instruction\":\"munis\",\"parameters\":[\"23\",45],\"response URL\":\"/answer/d3ae45\"}");
	    		Map<Object, Object> jsonItems = testData.jsonObject();
	    		tasks.putAll(jsonItems);
	          //  System.out.println(inputLine);
	    		String instruction = (String) tasks.get("instruction");
	            String[] tasksarr = (String[]) jsonItems.get("parameters");
	            System.out.print(tasksarr[0]+ " ");
	            System.out.print(instruction + " ");
	            System.out.println(tasksarr[1]);
	            System.out.println(tasks.get("response URL"));
	        
	            Maths instructionProcessor = new Maths(tasksarr[0],tasksarr[1]);
	            
	            if (instruction.equals("add")) {
		            int answer = instructionProcessor.add();
		            System.out.println("Add:" + answer);
	            } else if (instruction.equals("multiply")) {
		            int answer = instructionProcessor.multiply();
		            System.out.println("Multiply:" + answer);
	            } else  if (instruction.equals("concat")) {
		            String answer = instructionProcessor.concat();
		            System.out.println("Concat:" + answer);
	            } else {
	            	throw new Exception("Not Vaild Instruction");
	            }
	        
	        
	        
	        
	       // in.close();
			
	        return tasks;

	    }
}