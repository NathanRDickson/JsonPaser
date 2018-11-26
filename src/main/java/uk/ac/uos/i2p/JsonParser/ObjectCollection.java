package main.java.uk.ac.uos.i2p.JsonParser;

import java.util.*;

public class ObjectCollection implements Describer {
	public List<Describer> mylist = new ArrayList<Describer>();
	

	public String describe() {
		String finalstring = "[";
		
		for (Describer desc : mylist) {
			finalstring =finalstring + desc.describe() + ",";
	}
		if (finalstring.substring(finalstring.length()-1).equals(",")) {
		finalstring = finalstring.substring(0, finalstring.length() - 1);
		}
		finalstring =finalstring + "]";
    	return finalstring;
	}


	public void addObCollection (Describer ObCollection) {
		
		mylist.add(ObCollection);


	}


	@Override
	public Boolean describebool() {
		// TODO Auto-generated method stub
		return null;
	}
}
