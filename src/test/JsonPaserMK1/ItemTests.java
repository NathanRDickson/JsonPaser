package test.JsonPaserMK1;
import static org.junit.Assert.assertEquals;
import java.util.Map;

import org.junit.jupiter.api.Test;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;
import main.java.uk.ac.uos.i2p.JsonParser.ItemParser;



class ItemTests {
	
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
	
	
	


	
	
	
	
	

}