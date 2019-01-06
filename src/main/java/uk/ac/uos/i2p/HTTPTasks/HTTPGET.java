/**
* Author: S195224
* Version info: v1.1
*/

package main.java.uk.ac.uos.i2p.HTTPTasks;

import java.util.Map;

public class HTTPGET {
	public static void main(String[] args) throws Exception {

		String student = "s195224";
		String inputurl = "http://i2j.openode.io/student?id=" + student;

		GetTasks tasks = new GetTasks(inputurl);

		Map<Object, Object> jsonItems = tasks.jsonTask();

		System.out.println("Student id: " + jsonItems.get("id"));

		String[] tasksarr = (String[]) jsonItems.get("tasks");

		for (int i = 0; i < tasksarr.length; i++) {
			DoTask task = new DoTask(tasksarr[i]);
			Map<Object, Object> taskData = task.jsonTask();

			String posturl = (String) taskData.get("response URL");
			String answer = (String) taskData.get("answer");

			SendResult postRequest = new SendResult(posturl, answer);
			postRequest.postResults();
		}
	}
}
