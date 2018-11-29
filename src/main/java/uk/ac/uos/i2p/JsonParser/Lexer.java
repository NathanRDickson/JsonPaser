package main.java.uk.ac.uos.i2p.JsonParser;

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
				return new Symbol(Symbol.Type.SPACE);
			}
			

		
		return new Symbol(Symbol.Type.OTHER, Character.toString((char)c));
	}
	
	
	
	/*
	
	public Symbol next() throws IOException {
		
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
	}*/
}
