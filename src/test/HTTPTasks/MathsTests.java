package test.HTTPTasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.HTTPTasks.Maths;
import main.java.uk.ac.uos.i2p.HTTPTasks.SendResult;

class MathsTests {
	public Map<Object, Object> tasks = new HashMap<Object, Object>();
	
	@Test
	void addWithCorrectAns() throws Exception {
		String[] tasksarr = {"589","4045"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.add();
		assertEquals("4634",answer);
	}
	@Test
	void addWithCorrectAnsAndNegativeNumbers() throws Exception {
		String[] tasksarr = {"-589","-94045"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.add();
		assertEquals("-94634",answer);
	}
	
	@Test
	void addWithCorrectAnsAndLargeNumbers() throws Exception {
		String[] tasksarr = {"55566589","988884045"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.add();
		assertEquals("1044450634",answer);
	}
	
	@Test
	void addWithStringValues() throws Exception {
		String[] tasksarr = {"Choclate","Cake"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		try {
			instructionProcessor.add();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void multiplyWithCorrectAns() throws Exception {
		String[] tasksarr = {"589","4045"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.multiply();
		assertEquals("2382505",answer);
	}
	
	@Test
	void multiplyWithStringValues() throws Exception {
		String[] tasksarr = {"Choclate","Cake"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		try {
			instructionProcessor.multiply();
			assertFalse("Exception Not Thrown", true);
		} catch (Exception e) {
			assertTrue("Exception Thrown", true);
		}
	}
	
	@Test
	void multiplyWithCorrectAnsAndNegNumbers() throws Exception {
		String[] tasksarr = {"-589","-44045"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.multiply();
		assertEquals("25942505",answer);
	}
	
	@Test
	void concatWithCorrectAns() throws Exception {
		String[] tasksarr = {"589","4045"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.concat();
		assertEquals("5894045",answer);
	}
	
	@Test
	void concatWithStringAndCorrectAns() throws Exception {
		String[] tasksarr = {"Choclate ","Cake"};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.concat();
		assertEquals("Choclate Cake",answer);
	}
	
	@Test
	void concatnovalues() throws Exception {
		String[] tasksarr = {"",""};
		Maths instructionProcessor = new Maths(tasksarr[0], tasksarr[1]);
		String answer = instructionProcessor.concat();
		assertEquals("",answer);
	}
	


}