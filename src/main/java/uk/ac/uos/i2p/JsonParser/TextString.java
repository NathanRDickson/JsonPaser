package main.java.uk.ac.uos.i2p.JsonParser;

public class TextString{
	
	public String jsonStringItem(String text) {
		String stringOutput = text.substring(1, text.length()-1);
		return stringOutput;
		
		//Wraps Text
		//return wrap(text);
	}

	String wrap(String input) {
		return'"' + input + '"';
	}


	



}
