package test;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.JsonParser.JsonArrayToCollection;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;
import main.java.uk.ac.uos.i2p.JsonParser.ItemParser;



class PolyTests {

	@Test
	void jsonArrayToCollectionTest() {
		JsonArrayToCollection nathan = new JsonArrayToCollection("[\"/task/452359-4435382-6595137\", \"/task/99012-65325148-3574826\"]");
		Collection<String> output = nathan.jsonArrayToCollection();
		
		String FinalCopy = "";
		
		for (Object o : output) {
			FinalCopy = FinalCopy + o;
			//System.out.println(FinalCopy);
			}
		
		assertEquals("/task/452359-4435382-6595137 /task/99012-65325148-3574826", FinalCopy);
	}
	
	// ItemParser Tests
	@Test
	void JsonObjectNum55Test() throws Exception {
		ObjectParser nathan = new ObjectParser("\"Num\":\"55\"");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
	}
	
	@Test
	void JsonObjectDoubleNum55Test() throws Exception {
		ObjectParser nathan = new ObjectParser("\"Num\":\"55\",\"SecNum\":\"66\"");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals(66, jsonItems.get("SecNum"));
	}
	
	
	// ItemParser Tests
	@Test
	void JsonItemNum55Test() throws Exception {
		ItemParser nathan = new ItemParser("\"Num\":\"55\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		assertEquals(55, jsonItems.get("Num"));
	}
	@Test
	void JsonItemStringTest() throws Exception {
		ItemParser nathan = new ItemParser("\"Where\":\"New New York\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		assertEquals("New New York", jsonItems.get("Where"));
	}
	@Test
	void JsonItemBoolTest() throws Exception {
		ItemParser nathan = new ItemParser("\"Really\":\"true\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		assertEquals(true, jsonItems.get("Really"));
	}
	
	@Test
	void JsonItemArrayTest() throws Exception {
		ItemParser nathan = new ItemParser("\"GridLock\":\"[\"Car0\",\"Car1\"]\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
	}
	
	
	
	


	
	
	
	
	

}
