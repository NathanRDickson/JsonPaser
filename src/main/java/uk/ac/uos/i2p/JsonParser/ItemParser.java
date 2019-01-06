/**
* Author: S195224
* Version info: v1.1
*/
package main.java.uk.ac.uos.i2p.JsonParser;

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

   /** 
    * Class constructor.
    */
	public ItemParser(String json) {
		this.json = json;
	}

	@Override
	public Map<Object, Object> jsonItem() throws Exception {

		Collection<String> nameItemSplit = jsonItemSplitter(json);

		Iterator<String> itr = nameItemSplit.iterator();
		String name = itr.next().trim();
		String item = itr.next().trim();
		String firstChar = item.substring(0, 1);
		String lastChar = item.substring(item.length() - 1, item.length());

		name = name.substring(1, name.length() - 1);
		item = item.substring(1, item.length() - 1);

		if (firstChar.equals("{") && lastChar.equals("}")) {
			ObjectParser nestedObject = new ObjectParser("{" + item + "}");
			Map<Object, Object> nestedJsonItems = nestedObject.jsonObject();
			jsonItems.putAll(nestedJsonItems);
		} else if (item.equals("null")) {
			jsonItems.put(name, null);
		} else if (isNumeric(item)) {
			int num = Integer.parseInt(item);
			jsonItems.put(name, num);
		} else if (item.equals("true") || item.equals("false")) {
			Bool booleanobject = new Bool(item);
			Boolean output = booleanobject.describebool();
			jsonItems.put(name, output);
		} else if (firstChar.equals("[") && lastChar.equals("]")) {
			JsonStringToArray arrayDataObject = new JsonStringToArray(item);
			String[] Arr = arrayDataObject.jsonStringToArray();
			jsonItems.put(name, Arr);
		} else if ((firstChar.equals("\"") && lastChar.equals("\"")) == true) {
			TextString stringOutputOut = new TextString(item);
			String outputString = stringOutputOut.describe();
			jsonItems.put(name, outputString);
		} else {
			throw new Exception("Not Valid Java Item");
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
		
		Collection<String> nameItemSplit = items;
		return nameItemSplit;
	}

}