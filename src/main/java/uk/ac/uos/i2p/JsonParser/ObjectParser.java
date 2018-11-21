package main.java.uk.ac.uos.i2p.JsonParser;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class ObjectParser implements JsonParser {
	private String json;
	public ObjectCollection describeList = new ObjectCollection();
	
	public ObjectParser(String json) {
		this.json = json;
	}
	
	@Override
	public void jsonItem() throws Exception {
        
        // add elements to the array list
		Collection<String> NameItemSplit = Arrays.asList(json.split(":"));
		
		Iterator<String> itr = NameItemSplit.iterator();
		String name = itr.next();
		String item = itr.next();
		
		ItemParser itemcollection = new ItemParser(item);		
    	System.out.println(itemcollection);
	}
			
}