package main.java.uk.ac.uos.i2p.JsonParser;

public class BoolToString{
	private String json;

	public BoolToString(String json) {
		this.json = json;
	}

	public  String boolValue(boolean input) {
		return String.valueOf(input);
	}
}