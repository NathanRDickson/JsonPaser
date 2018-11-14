package main.java.uk.ac.uos.i2p.PolyTask;

public class TextString implements Describer{
	
	String text = "example"; 
	
	@Override
	public String describe() {
		
		return wrap(text);
	}

	String wrap(String input) {
		return'"' + input + '"';
	}
	



}
