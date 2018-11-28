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
	
	// ObjectParser Tests
	@Test
	void JsonObjectNum55Test() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"55\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNumBigTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"554332456\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(554332456, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNumMinusTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"-55\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(-55, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNumVerySmallMinusTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"-554332456\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(-554332456, jsonItems.get("Num"));
	}
	
	@Test
	void JsonObjectStringTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Legend\":\"He will speak those words only to one like himself.\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals("He will speak those words only to one like himself.", jsonItems.get("Legend"));
	}
	
	@Test
	void JsonObjectDoubleNum55Test() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"55\",\"SecNum\":\"66\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals(66, jsonItems.get("SecNum"));
	}
	
	@Test
	void JsonObjectDoubleNum55AndStringTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"55\",\"Time\":\"timey wimey\"}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals("timey wimey", jsonItems.get("Time"));
	}
	
	@Test
	void JsonObjectArrayTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"tasks\":[\"/task/452359-4435382-6595137\"]}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		String[] out = (String[]) jsonItems.get("tasks");
		assertEquals("/task/452359-4435382-6595137", out[0]);
	}
	
	//@Test
	//void JsonObjectArray2ItemTest() throws Exception {
	//	ObjectParser nathan = new ObjectParser("{\"tasks\":[\"/task/452359-4435382-6595137\",\"/task/99012-65325148-3574826\"]}");
	//	Map<Object, Object> jsonItems= nathan.jsonObject();
	//	String[] out = (String[]) jsonItems.get("tasks");
	//	assertEquals("/task/452359-4435382-6595137", out[0]);
	//}
	
	@Test
	void JsonObjectNestedTest() throws Exception {
		ObjectParser nathan = new ObjectParser("{\"Num\":\"55\",\"GlossEntry\":{\"\"Nest\":\"65\"}}");
		Map<Object, Object> jsonItems= nathan.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals(65, jsonItems.get("GlossEntry"));
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
		ItemParser nathan = new ItemParser("\"GridLock\":[\"Car0\",\"Car1\"]");
		Map<Object, Object> jsonItems= nathan.jsonItem();
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
	}
	
	
	
	


	
	
	
	
	

}
