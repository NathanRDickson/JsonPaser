package main.java.uk.ac.uos.i2p.JsonParserMK2;

import java.util.Arrays;
import java.util.Collection;

public class JsonArrayToCollection{
	private String json;
	
	public JsonArrayToCollection(String json) {
		this.json = json;
	}

	public Collection<String> jsonArrayToCollection() {

		String FormattedArray = json.replace("[", "");
		FormattedArray = FormattedArray.replace("]", "");
		FormattedArray = FormattedArray.replace("\"", "");

		Collection<String> collection = Arrays.asList(FormattedArray.split(","));
		return collection;
	}
	


}
