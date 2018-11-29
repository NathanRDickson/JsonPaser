package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;
import main.java.uk.ac.uos.i2p.JsonParserMK2.Lexer;
import main.java.uk.ac.uos.i2p.JsonParserMK2.Symbol;

class PolyTests {
	
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
	
	
	
	


	
	
	
	
	

}
