package main.java.uk.ac.uos.i2p.JsonParser;

public class Bool implements Describer{
	private String bool;

	public Bool(String input) {
		bool = input;
	}

	@Override
	public  Boolean describebool() {
		return Boolean.valueOf(bool);
	}

	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return null;
	}

}
