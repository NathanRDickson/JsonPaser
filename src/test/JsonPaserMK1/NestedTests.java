package test.JsonPaserMK1;
import static org.junit.Assert.assertEquals;
import java.util.Map;

import org.junit.jupiter.api.Test;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;



class NestedTests {
	
	// ObjectParser Tests
	
	//NestedTests
	 @Test
	void JsonObjectNestedTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"Nest\":\"65\"}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals(65, jsonItems.get("Nest"));
	}
	
	 @Test
	void JsonObjectNestedWithMoreThanOneItemTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"FirstNest\":\"65\",\"NestedNum\":\"44\"}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals(65, jsonItems.get("FirstNest"));
		assertEquals(44, jsonItems.get("NestedNum"));
	}
	 
	 @Test
	void JsonObjectNestedWithStringeItemTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"FirstNest\":\"Fez\",\"NestedNum\":\"44\"}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals("Fez", jsonItems.get("FirstNest"));
		assertEquals(44, jsonItems.get("NestedNum"));
	}
	
	 
	 @Test
	void JsonObjectNestedWithDoubleNestItemTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"FirstNest\":\"Fez\",\"GlossEntry\":{\"SecondNest\":\"65\",\"NestedNum\":\"44\"}}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals("Fez", jsonItems.get("FirstNest"));
		assertEquals(44, jsonItems.get("NestedNum"));
	}
	  
	
	 @Test
	void JsonObjectNestedArrayTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"GridLock\":[\"Car0\",\"Car1\"]}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
	}
	
	@Test
	void JsonObjectNestedArrayMoreThanOneItemTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"GridLock\":[\"Car0\",\"Car1\"],\"Age\":\"73\"}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(73, jsonItems.get("Age"));
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
	}
	
	
	@Test
	void JsonObjectJsonDotOrg1() throws Exception {
		ObjectParser testData = new ObjectParser("{\"glossary\":{\"title\":\"example glossary\"}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals("example glossary", jsonItems.get("title"));

	}
	
	@Test
	// Note the Problem Where By It Will Only Find the Last Item Called title.
	void JsonObjectJsonDotOrg() throws Exception {
		ObjectParser testData = new ObjectParser("{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\"}}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals("S", jsonItems.get("title"));

	}
	
	@Test
	void JsonObjectJustNestedTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Nest\":\"65\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(65, jsonItems.get("Nest"));
	}
	
	
	


	
	
	
	
	

}