package main.java.uk.ac.uos.i2p.PolyTask;

public class BoolToString implements Describer{

	boolean input = true; 
	@Override
	public  String describe() {
		 
		return String.valueOf(input);
	}
}
