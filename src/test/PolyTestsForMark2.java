package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;
import main.java.uk.ac.uos.i2p.JsonParserMK2.Lexer;
import main.java.uk.ac.uos.i2p.JsonParserMK2.Symbol;

class PolyTestsForMark2 {
	
	//Lexer Tests
	
	@Test
	public void testSingleOpen() throws IOException {
		Lexer lex = new Lexer(new StringReader("{"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.OPEN_OB, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleClose() throws IOException {
		Lexer lex = new Lexer(new StringReader("}"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.CLOSE_OB, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleArrayOpen() throws IOException {
		Lexer lex = new Lexer(new StringReader("[") );
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.OPEN_ARRAY, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleArrayClose() throws IOException {
		Lexer lex = new Lexer(new StringReader("]"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.CLOSE_ARRAY, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleComma() throws IOException {
		Lexer lex = new Lexer(new StringReader(","));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.COMMA, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleColon() throws IOException {
		Lexer lex = new Lexer(new StringReader(":"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.COLON, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleSpace() throws IOException {
		Lexer lex = new Lexer(new StringReader("\n"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.SPACE, symbol.type);
		assertNull(lex.next());
	}
	@Test
	public void testSingleWord() throws IOException {
		Lexer lex = new Lexer(new StringReader("fez"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.WORD, symbol.type);
		assertEquals("fez", symbol.value);
	}
	
	@Test
	public void testSingleWordWithSlash() throws IOException {
		Lexer lex = new Lexer(new StringReader("/fez"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.WORD, symbol.type);
		assertEquals("/fez", symbol.value);
	}
	
	@Test
	public void testSingleWordWithTwoSlash() throws IOException {
		Lexer lex = new Lexer(new StringReader("/fez/"));
		assertNextSymbol(lex, Symbol.Type.WORD, "/fez/");
	}
	@Test
	public void testMultiWord() throws IOException {
		Lexer lex = new Lexer(new StringReader("\"fez\""));
		assertNextSymbol(lex, Symbol.Type.QUOTE);
		assertNextSymbol(lex, Symbol.Type.WORD, "fez");
		assertNextSymbol(lex, Symbol.Type.QUOTE);
	}
	@Test
	public void testJson1() throws IOException {
		Lexer lex = new Lexer(new StringReader("{\"id\":\"S1232\"}"));
		assertNextSymbol(lex, Symbol.Type.OPEN_OB);
		assertNextSymbol(lex, Symbol.Type.QUOTE);
		assertNextSymbol(lex, Symbol.Type.WORD,"id");
		assertNextSymbol(lex, Symbol.Type.QUOTE);
		assertNextSymbol(lex, Symbol.Type.COLON);
		assertNextSymbol(lex, Symbol.Type.QUOTE);
		assertNextSymbol(lex, Symbol.Type.WORD,"S1232");
		assertNextSymbol(lex, Symbol.Type.QUOTE);
		assertNextSymbol(lex, Symbol.Type.CLOSE_OB);
	}
	
	
	
	
	
	
	
	void assertNextSymbol(Lexer lex, Symbol.Type type, String value) throws IOException {
		Symbol symbol = lex.next();
		assertEquals(type, symbol.type);
		assertEquals(value, symbol.value);
	}

	void assertNextSymbol(Lexer lex, Symbol.Type type) throws IOException {
		assertNextSymbol(lex, type, null);
	}

	
	
	
	

}
