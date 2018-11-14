package main.java.uk.ac.uos.i2p.PolyTask;

public class Task2 implements Describer{
	
	@Override
	public String describe() {
    	
    	TextString testString = new TextString();
    	String testStringOutput = testString.describe();
    	
    	NumberCast numberCast = new NumberCast();
    	String numberCastOutput = numberCast.describe();
    	
    	BoolToString boolToString = new BoolToString();
    	String boolToStringOutput = boolToString.describe();
    	
    	NullToString nullToString = new NullToString();
    	String nullToStringOutput = nullToString.describe();
    	
    	String[]  objectToRun = {testStringOutput,numberCastOutput,boolToStringOutput,nullToStringOutput};
    	
    	String finalOutput = "[";
    	for (int i = 0; i < objectToRun.length; i++) {
    		finalOutput =finalOutput + objectToRun[i] + ",";
 
    	}
    	
    	finalOutput = finalOutput.substring(0, finalOutput.length() - 1);
    	finalOutput =finalOutput + "]";
    	return finalOutput;
   }
    


}
