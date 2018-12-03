package main.java.uk.ac.uos.i2p.JsonParserMK2;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

public class Lexer {
private PushbackReader reader;
	
	public Lexer(StringReader stringReader) {
		reader = new PushbackReader(stringReader);
	}

	public Symbol next() throws IOException {
		int c = reader.read();
		if (-1 == c) return null;
		if ('{' == c) return new Symbol(Symbol.Type.OPEN_OB);
		if ('}' == c) return new Symbol(Symbol.Type.CLOSE_OB);
		if ('[' == c) return new Symbol(Symbol.Type.OPEN_ARRAY);
		if (']' == c) return new Symbol(Symbol.Type.CLOSE_ARRAY);
		if ('"' == c) return new Symbol(Symbol.Type.QUOTE);
		if (',' == c) return new Symbol(Symbol.Type.COMMA);
		if (':' == c) return new Symbol(Symbol.Type.COLON);
		if (Character.isWhitespace(c)) {
			do {
				c = reader.read();
			}
			while (Character.isWhitespace(c));
			
			if (-1 != c) reader.unread(c);
			return new Symbol(Symbol.Type.SPACE);
			
		}
		System.out.print(c);
		if (Character.isLetterOrDigit(c) || '/' == c) {
			StringBuffer word = new StringBuffer();
			do {
				word.append((char)c);
				c = reader.read();
			}
			while (Character.isLetterOrDigit(c) || '/' == c);
			if (-1 != c) reader.unread(c);
			return new Symbol(Symbol.Type.WORD , word.toString());
		}
		System.out.print(c);
		return new Symbol(Symbol.Type.OTHER, Character.toString((char)c));
	
   }
}
	
	
	
	/*
	
	 */
