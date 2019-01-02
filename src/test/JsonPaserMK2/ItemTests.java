package test.JsonPaserMK2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.JsonParser.ItemParser;
import main.java.uk.ac.uos.i2p.JsonParserMK2.Lexer;
import main.java.uk.ac.uos.i2p.JsonParserMK2.Symbol;

class ItemTests {
	
	//Lexer Tests
	
	@Test
	public void testSingleOpen() throws IOException {
		Lexer lex = new Lexer(new StringReader("{"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.OPEN_OB, symbol.type);
		assertNull(lex.next());
	}
	// ItemParser Tests
	@Test
	void JsonItemNum55Test() throws Exception {
		ItemParser testData = new ItemParser("\"Num\":\"55\"");
		Map<Object, Object> jsonItems= testData.jsonItem();
		assertEquals(55, jsonItems.get("Num"));
	}

	
	
	
	

}
