package main.java.uk.ac.uos.i2p.JsonParser;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectParser {
	private String json;

	public ObjectParser(String json) {
		this.json = json.trim();
	}

	public Map<Object, Object> jsonObject() throws Exception {

		System.out.print("\nPassed into Object: " + json);

		String FirstChar = json.substring(0, 1);
		String LastChar = json.substring(json.length() - 1, json.length());

		if ((FirstChar.equals("{") && LastChar.equals("}")) == true) {

			String object = json.substring(1, json.length() - 1);

			Collection<String> NameItemSplit = jsonItemSplitter(object);

			Map<Object, Object> jsonItems = new HashMap<Object, Object>();

			Iterator<String> itr = NameItemSplit.iterator();
			while (itr.hasNext()) {
				String item = itr.next();

				ItemParser nathan = new ItemParser(item);
				Map<Object, Object> newitems = nathan.jsonItem();

				for (Map.Entry<Object, Object> m : newitems.entrySet()) {
					// System.out.println(m.getKey()+" "+m.getValue());
					jsonItems.put(m.getKey(), m.getValue());
				}

			}
			return jsonItems;

		} else {
			throw new Exception("Not Vaild Java Object");
		}
	}

	private Collection<String> jsonItemSplitter(String object) throws IOException {
		StringReader stringReader = new StringReader(object);
		PushbackReader reader = new PushbackReader(stringReader);

		ArrayList<String> items = new ArrayList<String>();
		int c = 0;
		int lastSubString = -1;
		int arrays = 0;
		int objects = 0;
		String subString = "";

		for (int x = 0; x <= object.length() - 1; x++) {
			c = reader.read();
			if ('[' == c)arrays++;
			if (']' == c)arrays--;
			if ('{' == c)objects++;
			if ('}' == c)objects--;

			if ((',' == c) && arrays < 1 && objects < 1) {
				subString = object.substring(lastSubString + 1, x);
				items.add(subString.trim());
				lastSubString = x;
			}
		}

		subString = object.substring(lastSubString + 1, object.length());
		items.add(subString);

		Collection<String> NameItemSplit = items;
		return NameItemSplit;
	}
}
