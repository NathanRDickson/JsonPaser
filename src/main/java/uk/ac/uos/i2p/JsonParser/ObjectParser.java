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
		
		Map<Object, Object> jsonItems=new HashMap<Object, Object>();  
		Collection<String> NameItemSplit = Arrays.asList(json.split(","));
		
		Iterator<String> itr = NameItemSplit.iterator();
		while (itr.hasNext()) {
		String item = itr.next();	
		
		ItemParser nathan = new ItemParser(item);
		Map<Object, Object> newitems = nathan.jsonItem();
		
		  for(Map.Entry<Object, Object> m:newitems.entrySet()){  
			   System.out.println(m.getKey()+" "+m.getValue()); 
			   jsonItems.put(m.getKey(),m.getValue());
			  }  

		}
	return jsonItems;
	
	}
	
	
}
