package main.java.uk.ac.uos.i2p.JsonParserMK2;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ItemParser implements JsonParser {
	private String json;
	Map<Object, Object> jsonItems = new HashMap<Object, Object>();

	public ItemParser(String json) {
		this.json = json;
	}

	@Override
	public Map<Object, Object> jsonItem() throws Exception {

		System.out.println("\n" + json + "\n");

		Collection<String> NameItemSplit = jsonItemSplitter(json);

		Iterator<String> itr = NameItemSplit.iterator();
		String name = itr.next();
		String item = itr.next();
		String FirstChar = item.substring(0, 1);
		String LastChar = item.substring(item.length() - 1, item.length());

		name = name.substring(1, name.length() - 1);
		item = item.substring(1, item.length() - 1);

		if (FirstChar.equals("{") && LastChar.equals("}")) {
			System.out.println("\nNest");
			ObjectParser NestedObject = new ObjectParser("{" + item + "}");
			Map<Object, Object> nestedJsonItems = NestedObject.jsonObject();
			jsonItems.putAll(nestedJsonItems);
			System.out.println("\n" + name + " " + jsonItems + nestedJsonItems);
		} else if (item.equals("null")) {
			jsonItems.put(name, null);
		} else if (isNumeric(item)) {
			int num = Integer.parseInt(item);
			jsonItems.put(name, num);
		} else if (item.equals("true") || item.equals("false")) {
			Bool booleanobject = new Bool(item);
			Boolean output = booleanobject.describebool();
			jsonItems.put(name, output);
		} else if (FirstChar.equals("[") && LastChar.equals("]")) {
			JsonStringToArray ArrayDataObject = new JsonStringToArray(item);
			String[] Arr = ArrayDataObject.jsonStringToArray();
			jsonItems.put(name, Arr);
		} else if ((FirstChar.equals("\"") && LastChar.equals("\"")) == true) {
			TextString StringOutputOut = new TextString(item);
			String outputString = StringOutputOut.describe();
			jsonItems.put(name, outputString);
		} else if (item.equals("true") || item.equals("false")) {
			Bool booleanobject = new Bool(item);
			Boolean output = booleanobject.describebool();
			jsonItems.put(name, output);
		} else {
			throw new Exception("Not Vaild Java Item");
		}

		return jsonItems;

	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	private Collection<String> jsonItemSplitter(String object) throws IOException {
		StringReader stringReader = new StringReader(object);
		PushbackReader reader2 = new PushbackReader(stringReader);

		ArrayList<String> items = new ArrayList<String>();
		int c = 0;
		int lastSubString = -1;
		int arrays = 0;
		int objects = 0;
		String subString = "";

		for (int x = 0; x <= object.length() - 1; x++) {
			c = reader2.read();
			// char A = ((char)c);
			if ('[' == c)arrays++;
			if (']' == c)arrays--;
			if ('{' == c)objects++;
			if ('}' == c)objects--;

			if ((':' == c) && arrays < 1 && objects < 1) {
				subString = object.substring(lastSubString + 1, x);

				items.add(subString);
				lastSubString = x;
			}

		}
		subString = object.substring(lastSubString + 1, object.length());
		items.add(subString);
		
		Collection<String> NameItemSplit = items;
		return NameItemSplit;
	}

}