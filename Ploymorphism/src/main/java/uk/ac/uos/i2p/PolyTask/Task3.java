package main.java.uk.ac.uos.i2p.PolyTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Task3 implements Processor  {
	
	public String multidescribe() {
		System.out.println("ddd");
		return "cake";
		
	}
	@Override
	public void process(Iterator<String> it) throws IOException {
	      // Create an array list
		
		
    	TextString testString = new TextString();
    	String testStringOutput = testString.describe();
    	
    	NumberCast numberCast = new NumberCast();
    	String numberCastOutput = numberCast.describe();
    	
    	BoolToString boolToString = new BoolToString();
    	String boolToStringOutput = boolToString.describe();
    	
    	NullToString nullToString = new NullToString();
    	String nullToStringOutput = nullToString.describe();
    	
    	ArrayList<String> objectToRun =  new ArrayList<String>();
        
        // add elements to the array list
    	objectToRun.add("testStringOutput");
    	objectToRun.add("numberCastOutput");
    	objectToRun.add("boolToStringOutput");
    	objectToRun.add("nullToStringOutput");
 
  Iterator<String> itr = objectToRun.iterator();
	      
	      while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }
	      System.out.println();
	      
		
	}

}
