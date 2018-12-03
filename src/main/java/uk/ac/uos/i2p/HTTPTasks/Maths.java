package main.java.uk.ac.uos.i2p.HTTPTasks;

public class Maths {

	private int val1;
	private int val2;

	public Maths(String value1, String value2) {
		this.val1 = Integer.parseInt(value1);
		this.val2 = Integer.parseInt(value2);

	}
	  public int add() throws Exception {
		  return val1 + val2;
	  }
	public int multiply() {
		// TODO Auto-generated method stub
		return val1 * val2;
	}
	public String concat() {
		String result = ""+val1+val2;
		return result;
	}
	
	

}

