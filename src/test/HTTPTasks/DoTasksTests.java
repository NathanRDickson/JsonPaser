package test.HTTPTasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.HTTPTasks.DoTask;

class DoTasksTests {

	@Test
	void Post3652WithCorrectAns() throws Exception {
		DoTask task = new DoTask("/task/3652");
		Map<Object, Object> taskData = task.jsonTask();
		
		String posturl = (String) taskData.get("response URL");
		String answer = (String) taskData.get("answer");
		
		assertEquals("/answer/3652", posturl);
		assertEquals("48147029", answer);
	}
	
	@Test
	void Post7286WithCorrectAns() throws Exception {
		DoTask task = new DoTask("/task/7286");
		Map<Object, Object> taskData = task.jsonTask();
		
		String posturl = (String) taskData.get("response URL");
		String answer = (String) taskData.get("answer");
		
		assertEquals("/answer/7286", posturl);
		assertEquals("6770", answer);
	}
	
	@Test
	void Post3652WithInvalidTask() throws Exception {
		DoTask task = new DoTask("/task/3652435");
		try {
			task.jsonTask();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	
	}
	
	@Test
	void NoTask() throws Exception {
		DoTask task = new DoTask("");
		try {
			task.jsonTask();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	
	}


}