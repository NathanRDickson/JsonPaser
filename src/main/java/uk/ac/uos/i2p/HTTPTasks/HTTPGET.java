package main.java.uk.ac.uos.i2p.HTTPTasks;

import java.util.Map;

public class HTTPGET {
    public static void main(String[] args) throws Exception {
        	
    		String student = "s113867";
        	String inputurl = "http://i2j.openode.io/student?id="+student;
        	
			GetTasks testData = new GetTasks(inputurl);
			SendResult SendData = new SendResult();
			SendData.main();
			
    		Map<Object, Object> jsonItems= testData.jsonTask();
    		
    		System.out.println("Student id: " + jsonItems.get("id"));
    		
    		String[] tasksarr = (String[]) jsonItems.get("tasks");
    		
    		for (int i = 0; i < tasksarr.length; i++)
    	     {
    			DoTask task = new DoTask(tasksarr[i]);
    			Map<Object, Object> taskItems = task.jsonTask();
    			System.out.println(tasksarr[i]);
    		}
    		
    		
    	

    }
}

