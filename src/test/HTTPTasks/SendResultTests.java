package test.HTTPTasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import main.java.uk.ac.uos.i2p.HTTPTasks.SendResult;

class SendResultTests {

	@Test
	void Post7286WithCorrectAns() throws Exception {
		SendResult PostRequest = new SendResult("/answer/7286", "6770");
		String[] sendConfirmation = PostRequest.postResults();
		assertEquals("http://i2j.openode.io/answer/7286", sendConfirmation[0]);
		assertEquals("6770", sendConfirmation[1]);
		assertEquals("200", sendConfirmation[2]);
		assertEquals("OK", sendConfirmation[3]);
	}
	
	@Test
	void Post7943WithCorrectAns() throws Exception {
		SendResult PostRequest = new SendResult("/answer/7943", "83884496");
		String[] sendConfirmation = PostRequest.postResults();
		assertEquals("http://i2j.openode.io/answer/7943", sendConfirmation[0]);
		assertEquals("83884496", sendConfirmation[1]);
		assertEquals("200", sendConfirmation[2]);
		assertEquals("OK", sendConfirmation[3]);
	}

	@Test
	void Post7286WithWrongAns() throws Exception {
		SendResult PostRequest = new SendResult("/answer/7286", "6771");
		try {
			PostRequest.postResults();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}

	@Test
	void Post7286WithBadTask() throws Exception {
		SendResult PostRequest = new SendResult("/answer/755s586", "6771");
		try {
			PostRequest.postResults();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}

	}
	
	@Test
	void Post2867BadTask() throws Exception {
		SendResult PostRequest = new SendResult("/answer/2867", "Bad Request");
		try {
			PostRequest.postResults();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void PostNoTask() throws Exception {
		SendResult PostRequest = new SendResult("", "Bad Request");
		try {
			PostRequest.postResults();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void Post7286WithNoAns() throws Exception {
		SendResult PostRequest = new SendResult("/answer/7286", "");
		try {
			PostRequest.postResults();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}

}