package main.java.uk.ac.uos.i2p.JsonParserMK2;

public class Symbol {

		public enum Type {OPEN_OB , CLOSE_OB, QUOTE, COLON, WORD, SPACE, COMMA, OPEN_ARRAY, CLOSE_ARRAY,OTHER}

		public Type type;
		public final String value;

		public Symbol(Type type, String value) {
			this.type = type;
			this.value = value;
		}

		public Symbol(Type type) {
			this(type, null);
		}
		
}
