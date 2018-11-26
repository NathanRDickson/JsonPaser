package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.JsonParser.JsonArrayToCollection;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;



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
	
	
	// ObjectParser Tests
	@Test
	void JsonObjectNum55Test() throws Exception {
		ObjectParser nathan = new ObjectParser("\"Num\":\"55\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		assertEquals(55, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectStringTest() throws Exception {
		ObjectParser nathan = new ObjectParser("\"Where\":\"New New York\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		assertEquals("New New York", jsonItems.get("Where"));
	}
	@Test
	void JsonObjectBoolTest() throws Exception {
		ObjectParser nathan = new ObjectParser("\"Really\":\"true\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		assertEquals(true, jsonItems.get("Really"));
	}
	
	@Test
	void JsonObjectArrayTest() throws Exception {
		ObjectParser nathan = new ObjectParser("\"Array\":\"[\\\"/task/452359-4435382-6595137\\\", \\\"/task/99012-65325148-3574826\\\"]\"");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		jsonItems.get("Array");
		
		assertEquals("/task/452359-4435382-6595137 /task/99012-65325148-3574826", jsonItems.get("Array"));
	}
	
	
	
	


	
	
	
	
	

}
