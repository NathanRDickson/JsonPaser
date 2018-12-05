package test.JsonPaserMK1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
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
	void JsonItemNum55NoColonTest() throws Exception {
		ItemParser testData = new ItemParser("\"Num\"\"55\"");
		try {
			testData.jsonItem();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	
	@Test
	void JsonItemStringTest() throws Exception {
		ItemParser testData = new ItemParser("\"Where\":\"New New York\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals("New New York", jsonItems.get("Where"));
	}
	
	@Test
	void JsonItemStringTestBraketInString() throws Exception {
		ItemParser testData = new ItemParser("\"Nu{m\":\"55\"");
		try {
			testData.jsonItem();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void JsonItemBoolTestTrue() throws Exception {
		ItemParser testData = new ItemParser("\"Really\":\"true\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals(true, jsonItems.get("Really"));
	}
	
	@Test
	void JsonItemBoolTestFalse() throws Exception {
		ItemParser testData = new ItemParser("\"Really\":\"false\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals(false, jsonItems.get("Really"));
	}
	
	@Test
	void JsonItemArrayTest() throws Exception {
		ItemParser testData = new ItemParser("\"GridLock\":[\"Car0\",\"Car1\"]");
		Map<Object, Object> jsonItems= testData.jsonItem();
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
	}
	@Test
	void JsonItemMissformedArray() throws Exception {
		ItemParser testData = new ItemParser("\"GridLock\":\"Car0\",\"Car1\"]");
		try {
			testData.jsonItem();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void JsonItemArrayTestNumbers() throws Exception {
		ItemParser testData = new ItemParser("\"GridLock\":[\"55\",\"66\"]");
		Map<Object, Object> jsonItems= testData.jsonItem();
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("55", out[0]);
		assertEquals("66", out[1]);
	}
	
	@Test
	void JsonItemArrayTestBigArray() throws Exception {
		ItemParser testData = new ItemParser("\"GridLock\":[\"Car0\",\"Car1\",\"Car3\",\"Car1\",\"Car1\",\"Car1\",\"6655\",\"Car1\",\"Car1\",\"Car1\",\"Car1\",\"Car1\",\"Car13\"]");
		Map<Object, Object> jsonItems= testData.jsonItem();
		String[] out = (String[]) jsonItems.get("GridLock");
		assertEquals("Car0", out[0]);
		assertEquals("Car1", out[1]);
		assertEquals("Car13", out[12]);
	}
	
	@Test
	void JsonItemRandomString() throws Exception {
		ItemParser testData = new ItemParser("dfsfsgfdgf877");
		try {
			testData.jsonItem();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void JsonItemRandomNumber() throws Exception {
		ItemParser testData = new ItemParser("666");
		try {
			testData.jsonItem();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	


	
	
	
	
	

}