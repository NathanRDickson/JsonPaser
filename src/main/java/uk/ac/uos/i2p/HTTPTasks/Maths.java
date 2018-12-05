package main.java.uk.ac.uos.i2p.HTTPTasks;

public class Maths {

	private String val1;
	private String val2;

	public Maths(String value1, String value2) {
		this.val1 = value1;
		this.val2 = value2;

	}
	public String add() throws Exception {
		int	intVal1 = Integer.parseInt(val1);
		int	intVal2 = Integer.parseInt(val2);
		int ans = intVal1 + intVal2;
		return Integer.toString(ans);
	}
	public String multiply() {
		int	intVal1 = Integer.parseInt(val1);
		int	intVal2 = Integer.parseInt(val2);
		int ans = intVal1 * intVal2;
		return Integer.toString(ans);
	}
	public String concat() {
		String result = val1+val2;
		return result;
	}



}

