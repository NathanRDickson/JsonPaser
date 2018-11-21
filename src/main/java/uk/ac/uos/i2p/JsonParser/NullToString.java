package main.java.uk.ac.uos.i2p.JsonParser;

public class NullToString implements Describer {

	@Override
	public String describe() {

		return String.valueOf(NullGen());
		
	}
	
	public String NullGen() {
		return null;
	}


}
