package main.java.uk.ac.uos.i2p.JsonParser;

public class ItemParser {
	private String json;
	public ObjectCollection describeList = new ObjectCollection();
	
	
	public ItemParser(String json) {
		this.json = json;
	}

	
	public ObjectCollection ItemProcessor() throws Exception {
		String next = json;
		
		System.out.println(next);
		if (next.equals("null")) {
			NullToString nullItem = new NullToString();
			describeList.addObCollection(nullItem);
		}
		else if (next.substring(0, 1).equals("\"") &&  next.substring(next.length()- 1 , next.length()).equals("\"")) {
			
	    	String testStringOutput = next.substring(1, next.length()-1);
	    	System.out.println(testStringOutput);
	    	TextString testStringOutputOut = new TextString(testStringOutput);
	    	describeList.addObCollection(testStringOutputOut);
		}else if (isNumeric(next)) {
				int num = Integer.parseInt(next);
			 	NumberCast numberOutput = new NumberCast(num);
			 	describeList.addObCollection(numberOutput);	
		}else if (next.equals("true") || next.equals("false")) {
    			Bool booleanobject = new Bool (true);
				describeList.addObCollection(booleanobject);
	    }else {
	    	throw new Exception("Not Vaild");
	    }
		
		return describeList;
}
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
}
