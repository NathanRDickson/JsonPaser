package test.HTTPTasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.HTTPTasks.DoTask;
import main.java.uk.ac.uos.i2p.HTTPTasks.GetTasks;

class GetTasksTests {

	@Test
	void gets113867() throws Exception {

		String student = "s113867";
		String inputurl = "http://i2j.openode.io/student?id=" + student;

		GetTasks Tasks = new GetTasks(inputurl);

		Map<Object, Object> jsonItems = Tasks.jsonTask();
		
		String[] tasksarr = (String[]) jsonItems.get("tasks");

		assertEquals("/task/5447", tasksarr[0]);
		assertEquals("/task/3652", tasksarr[1]);
	}
	
	@Test
	void getsWrongStudent() throws Exception {

		String student = "s1136776867";
		String inputurl = "http://i2j.openode.io/student?id=" + student;

		GetTasks Tasks = new GetTasks(inputurl);
		try {
			Tasks.jsonTask();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}

	}
	
	@Test
	void getsBadUrl() throws Exception {

		String student = "s113867";
		String inputurl = "http://i2j.opfsdfsdenode.idassdo/student?id=" + student;

		GetTasks Tasks = new GetTasks(inputurl);
		try {
			Tasks.jsonTask();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}

	}
	



}