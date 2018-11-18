package main.java.uk.ac.uos.i2p.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class ObjectParser implements JsonParser {
	private String json;
	ArrayList<String> JsonItems;
	
	public ObjectParser(String json) {
		this.json = json;
	}


	


	@Override
	public Collection<String> jsonObject() throws Exception  {
		
    	JsonItems =  new ArrayList<String>();
        
        // add elements to the array list
    	
    	
    	
		Collection<String> NameItemSplit = Arrays.asList(json.split(": "));
		
		Iterator<String> iter = NameItemSplit.iterator();
		String name = iter.next();
		String item = iter.next();
		
		//If Item is an Array
		if (item.substring(0,1).equals("[") &&  item.substring(item.length()- 1 , item.length()).equals("]") ) {
			JsonArrayToCollection ArrayDataObject = new JsonArrayToCollection(item);
			JsonItems.addAll(ArrayDataObject.jsonArrayToCollection());
		}else if (item.substring(0,1).equals("\"") &&  item.substring(item.length()- 1 , item.length()).equals("\"") ) {	
		//If item is a String
			TextString testString = new TextString();
			JsonItems.add(testString.jsonStringItem(item));
	    	
		}else{
			throw new Exception("Not Vaild");
			f
		}
		
		
		return JsonItems;
	}





	@Override
	public Collection<String> jsonArrayToCollection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

		
}