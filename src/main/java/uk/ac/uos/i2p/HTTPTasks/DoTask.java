/**
* Author: Nathan Dickson
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

public class DoTask {
	private String url;
	public Map<Object, Object> tasks = new HashMap<Object, Object>();

	/** 
	* Class constructor.
	*/
	public DoTask(String url) {
		this.url = url;

	}

	public Map<Object, Object> jsonTask() throws Exception {

		URL oracle = new URL(" http://i2j.openode.io" + url);

		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

		String inputLine = null;

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			ObjectParser testData = new ObjectParser(inputLine);
			Map<Object, Object> jsonItems = testData.jsonObject();
			tasks.putAll(jsonItems);

			String instruction = (String) tasks.get("instruction");
			String[] tasksarr = (String[]) jsonItems.get("parameters");

			Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);

			if (instruction.equals("add")) {
				String answer = instructionProcessor.add();
				tasks.put("answer", answer);
			} else if (instruction.equals("multiply")) {
				String answer = instructionProcessor.multiply();
				tasks.put("answer", answer);
			} else if (instruction.equals("concat")) {
				String answer = instructionProcessor.concat();
				tasks.put("answer", answer);
			} else {
				throw new Exception("Not Valid Instruction");
			}
		}
		return tasks;
	}
}
