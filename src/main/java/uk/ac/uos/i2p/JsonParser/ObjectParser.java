package main.java.uk.ac.uos.i2p.JsonParser;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectParser {
	private String json;
	
	public ObjectParser(String json) {
		this.json = json;
	}
	
	public Map<Object, Object> jsonObject() throws Exception {
		
		String FirstChar = json.substring(0, 1);
		String LastChar = json.substring(json.length()- 1 , json.length());
		
		
		if ((FirstChar.equals("{") && LastChar.equals("}") )== true) {
			
		String object = json.substring(1, json.length()-1);
			
		Map<Object, Object> jsonItems=new HashMap<Object, Object>();  
		//Collection<String> NameItemSplit = Arrays.asList(object.split(",(?=(?:[^\\[]*\"[^\"]*\")*[^\"]*$)"));
		Collection<String> NameItemSplit = Arrays.asList(object.split(","));
		
		
		Iterator<String> itr = NameItemSplit.iterator();
		while (itr.hasNext()) {
		String item = itr.next();	
		
		ItemParser nathan = new ItemParser(item);
		Map<Object, Object> newitems = nathan.jsonItem();
		
		  for(Map.Entry<Object, Object> m:newitems.entrySet()){  
			 //  System.out.println(m.getKey()+" "+m.getValue()); 
			   jsonItems.put(m.getKey(),m.getValue());
			  }  

		}
	return jsonItems;
	
		} else {
			throw new Exception("Not Vaild Java Object");
		}
	}
	
	
}
