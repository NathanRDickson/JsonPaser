package main.java.uk.ac.uos.i2p.JsonParser;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class ObjectParser implements JsonParser {
	private String json;
	Map<Object, Object> jsonItems=new HashMap<Object, Object>();  
	
	public ObjectParser(String json) {
		this.json = json;
	}
	
	@Override
	public Map<Object, Object> jsonItem() throws Exception {
        
        // add elements to the array list
		Collection<String> NameItemSplit = Arrays.asList(json.split(":"));
		
		Iterator<String> itr = NameItemSplit.iterator();
		String name = itr.next();
		String item = itr.next();
		System.out.println(item);
		String FirstChar = item.substring(0, 1);
		String LastChar = item.substring(item.length()- 1 , item.length());
		
		name = name.substring(1, name.length()-1);
		item = item.substring(1, item.length()-1);
				
		if (item.equals("null")) {
			jsonItems.put(name,null);
		}else if (isNumeric(item)) {
			int num = Integer.parseInt(item);
			jsonItems.put(name,num);
		}
		else if (item.equals("true") || item.equals("false")) {
			Bool booleanobject = new Bool (item);
			Boolean output = booleanobject.describebool();
			jsonItems.put(name,output);
		} 
		else if (FirstChar.equals("[") &&  LastChar.equals("]") ) {
			JsonStringToArray ArrayDataObject = new JsonStringToArray(item);
			String[] Arr = ArrayDataObject.jsonStringToArray();
			jsonItems.put(name,Arr);
		}
		else if ((FirstChar.equals("\"") && LastChar.equals("\"") )== true) {
		    	//String testStringOutput = item.substring(1, item.length()-1);
		    	//System.out.println(testStringOutput);
		    	TextString StringOutputOut = new TextString(item);
		    	String outputString = StringOutputOut.describe();
		    	jsonItems.put(name,outputString);
		}
		else if (item.equals("true") || item.equals("false")) {
			Bool booleanobject = new Bool (item);
			Boolean output = booleanobject.describebool();
			jsonItems.put(name,output);
		}else {
	    	throw new Exception("Not Vaild");
	    }
	
	  return jsonItems;
	
	}
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	
			
}