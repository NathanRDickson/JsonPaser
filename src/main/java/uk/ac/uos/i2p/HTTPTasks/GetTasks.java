/**
* Author: S195224
* Version info: v1.1
*/
package main.java.uk.ac.uos.i2p.HTTPTasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;

public class GetTasks {
	private String url;
	public Map<Object, Object> tasks = new HashMap<Object, Object>();

	/** 
	* Class constructor.
	*/
	public GetTasks(String url) {
		this.url = url;
	}

	public Map<Object, Object> jsonTask() throws Exception {
		URL oracle = new URL(url);

		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			ObjectParser testData = new ObjectParser(inputLine);
			Map<Object, Object> jsonItems = testData.jsonObject();
			tasks.putAll(jsonItems);
			System.out.println(inputLine);

		}
		in.close();

		return tasks;

	}
}
