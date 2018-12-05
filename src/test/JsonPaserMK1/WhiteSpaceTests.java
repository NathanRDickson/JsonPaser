package test.JsonPaserMK1;
import static org.junit.Assert.assertEquals;
import java.util.Map;

import org.junit.jupiter.api.Test;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;



class WhiteSpaceTests {
	@Test
	void JsonObjectNum55TestSpaces() throws Exception {
		ObjectParser testData = new ObjectParser("{ \"Num\" : \"55\" }");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
	}
	@Test
	void JsonObjectNum55TestExtremeSpaces() throws Exception {
		ObjectParser testData = new ObjectParser("{     \"Num\"    :     \"55\"    }");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
	}
	
	@Test
	void JsonObjectNum55TestExtremeSpacesTabsAndBreakLines() throws Exception {
		ObjectParser testData = new ObjectParser("{   \t  \"Num\"    :   \n  \"55\"    }");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
	}
	
	@Test
	void JsonObjectNestedWithDoubleNestItemTestAndWhiteSpace() throws Exception {
		ObjectParser testData = new ObjectParser("{   \"Num\":    \"55\",\"GlossEntry\"   :{   \"FirstNest\":\"Fez\",\"GlossEntry\":   {\"SecondNest\"   :   \"65\",\"NestedNum\"   :\"44\"}}}");
		Map<Object, Object> jsonItems= testData.jsonObject();
		assertEquals(55, jsonItems.get("Num"));
		assertEquals("Fez", jsonItems.get("FirstNest"));
		assertEquals(44, jsonItems.get("NestedNum"));
	}	
	

}