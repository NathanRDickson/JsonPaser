package test;
import static org.junit.Assert.assertEquals;
import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.JsonParser.JsonArrayToCollection;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;
import main.java.uk.ac.uos.i2p.JsonParser.ItemParser;



class PolyTests {
	
	// ObjectParser Tests
	@Test
	void JsonObjectNum55Test() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNumBigTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"554332456\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(554332456, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNumMinusTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"-55\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(-55, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNumVerySmallMinusTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"-554332456\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(-554332456, jsonItems.get("Num"));
	}
	
	@Test
	void JsonObjectStringTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Legend\":\"He will speak those words only to one like himself.\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals("He will speak those words only to one like himself.", jsonItems.get("Legend"));
	}
	
	@Test
	void JsonObjectDoubleNum55Test() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"SecNum\":\"66\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals(66, jsonItems.get("SecNum"));
	}
	
	@Test
	void JsonObjectDoubleNum55AndStringTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"Num\":\"55\",\"Time\":\"timey wimey\"}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals("timey wimey", jsonItems.get("Time"));
	}
	
	@Test
	void JsonObjectArrayTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"tasks\":[\"/task/452359-4435382-6595137\"]}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		String[] out = (String[]) jsonItems.get("tasks");
		assertEquals("/task/452359-4435382-6595137", out[0]);
	}
	
	@Test
	void JsonObjectArray2ItemTest() throws Exception {
		ObjectParser testData = new ObjectParser("{\"tasks\":[\"/task/452359-4435382-6595137\",\"/task/99012-65325148-3574826\"]}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		String[] out = (String[]) jsonItems.get("tasks");
		assertEquals("/task/452359-4435382-6595137", out[0]);
	}
	
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

	
	// ItemParser Tests
	@Test
	void JsonItemNum55Test() throws Exception {
		ItemParser testData = new ItemParser("\"Num\":\"55\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals(55, jsonItems.get("Num"));
	}
	@Test
	void JsonItemStringTest() throws Exception {
		ItemParser testData = new ItemParser("\"Where\":\"New New York\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals("New New York", jsonItems.get("Where"));
	}
	@Test
	void JsonItemBoolTest() throws Exception {
		ItemParser testData = new ItemParser("\"Really\":\"true\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals(true, jsonItems.get("Really"));
	}
	
	@Test
	void JsonItemArrayTest() throws Exception {
		ItemParser testData = new ItemParser("\"GridLock\":[\"Car0\",\"Car1\"]");
		Map<Object, Object> jsonItems= testData.jsonItem();
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
	}
	
	
	//Old Tests
	@Test
	void jsonArrayToCollectionTest() {
		JsonArrayToCollection testData = new JsonArrayToCollection("[\"/task/452359-4435382-6595137\", \"/task/99012-65325148-3574826\"]");
		Collection<String> output = testData.jsonArrayToCollection();
		
		String FinalCopy = "";
		
		for (Object o : output) {
			FinalCopy = FinalCopy + o;
			//System.out.println(FinalCopy);
			}
		
		assertEquals("/task/452359-4435382-6595137 /task/99012-65325148-3574826", FinalCopy);
	}
	
	
	


	
	
	
	
	

}