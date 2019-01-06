/**
* Author: S195224
* Version info: v1.1
*/
package main.java.uk.ac.uos.i2p.JsonParser;

public class JsonStringToArray{
	private String json;
	
	/** 
	* Class constructor.
	*/
	public JsonStringToArray(String json) {
		this.json = json;
	}

	public String[] jsonStringToArray() {

		String formattedArray = json.replace("[", "");
		formattedArray = formattedArray.replace("]", "");
		formattedArray = formattedArray.replace("\"", "");

		String[] arr = formattedArray.split(",");
		
		return arr;
	}
	


}
