import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import org.junit.Test;

class Symbol {
	public enum Type { OPEN, CLOSE, SLASH, WORD, SPACE, OTHER };
	
	public final Type type;
	public final String value;
	
	public Symbol(Type type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public Symbol(Type type) {
		this(type, null);
	}
}


class Lexer {
	private PushbackReader reader;
	
	public Lexer(StringReader stringReader) {
		reader = new PushbackReader(stringReader);
	}
	
	public Symbol next() throws IOException {
		int c = reader.read();
		if (-1 == c) return null; // no more symbols
		if ('<' == c) return new Symbol(Symbol.Type.OPEN);
		if ('>' == c) return new Symbol(Symbol.Type.CLOSE);
		if ('/' == c) return new Symbol(Symbol.Type.SLASH);
		if (Character.isWhitespace(c)) {
			while (Character.isWhitespace(c)) {
				c = reader.read();
			}
			return new Symbol(Symbol.Type.SPACE);
		}
		if (Character.isLetterOrDigit(c)) {
			StringBuffer value = new StringBuffer();
			while (Character.isLetterOrDigit(c)) {
				value.append((char)c);
				c = reader.read();
			}
			reader.unread(c);
			return new Symbol(Symbol.Type.WORD, value.toString());
		}
		return new Symbol(Symbol.Type.OTHER, Character.toString((char)c));
	}
}

public class BugHunt {
	@Test
	public void testEmpty() throws IOException {
		Lexer lex = new Lexer(new StringReader(""));
		Symbol symbol = lex.next();
		assertNull(symbol);
	}
	@Test
	public void testSingleOpen() throws IOException {
		Lexer lex = new Lexer(new StringReader("<"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.OPEN, symbol.type);
	}
	@Test
	public void testSingleClose() throws IOException {
		Lexer lex = new Lexer(new StringReader(">"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.CLOSE, symbol.type);
	}
	@Test
	public void testSingleSlash() throws IOException {
		Lexer lex = new Lexer(new StringReader("/"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.SLASH, symbol.type);
	}
	
	@Test
	public void testWord() throws IOException {
		Lexer lex = new Lexer(new StringReader("hello"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.WORD, symbol.type);
		assertEquals("hello", symbol.value);
	}
	@Test
	public void testSpace() throws IOException {
		Lexer lex = new Lexer(new StringReader(" \n\t  "));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.SPACE, symbol.type);
		assertNull(lex.next());
	}
	
	@Test
	public void testCombination() throws IOException {
		Lexer lex = new Lexer(new StringReader("<ugh>"));
		Symbol symbol = lex.next();
		assertEquals(Symbol.Type.OPEN, symbol.type);
		symbol = lex.next();
		assertEquals(Symbol.Type.WORD, symbol.type);
		assertEquals("ugh", symbol.value);
		symbol = lex.next();
		assertEquals(Symbol.Type.CLOSE, symbol.type);
		assertNull(lex.next());
	}
	
}
