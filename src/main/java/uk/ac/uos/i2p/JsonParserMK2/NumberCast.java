package main.java.uk.ac.uos.i2p.JsonParserMK2;

public class NumberCast implements Describer{
	private int num;
	
	public NumberCast (int newValue) {
		num = newValue;	
		}
	
	public String describe() {
		
		return Integer.toString(num);
	}


	
}
