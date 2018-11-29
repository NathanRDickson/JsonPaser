package main.java.uk.ac.uos.i2p.JsonParserMK2;

public class TextString implements Describer{
	private String text;
	
	public TextString (String inputText) {
		text = inputText;
	}
	
	@Override public String describe() {
		//System.out.println("\""+text+"\"");
		return text;
		
	}

	@Override
	public Boolean describebool() {
		// TODO Auto-generated method stub
		return null;
	}




}
