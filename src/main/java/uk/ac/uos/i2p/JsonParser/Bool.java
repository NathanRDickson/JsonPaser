package main.java.uk.ac.uos.i2p.JsonParser;

public class Bool implements Describer{
	private boolean bool;

	public Bool(boolean input) {
		bool = input;
	}

	@Override
	public  String describe() {
		return String.valueOf(bool);
	}

}
