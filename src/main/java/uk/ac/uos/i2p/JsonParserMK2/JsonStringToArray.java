package main.java.uk.ac.uos.i2p.JsonParserMK2;

public class JsonStringToArray{
	private String json;
	
	public JsonStringToArray(String json) {
		this.json = json;
	}

	public String[] jsonStringToArray() {

		String FormattedArray = json.replace("[", "");
		FormattedArray = FormattedArray.replace("]", "");
		FormattedArray = FormattedArray.replace("\"", "");

		String[] arr = FormattedArray.split(",");
		
		return arr;
	}
	


}
