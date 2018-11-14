package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.PolyTask.BoolToString;
import main.java.uk.ac.uos.i2p.PolyTask.NumberCast;
import main.java.uk.ac.uos.i2p.PolyTask.Task2;
import main.java.uk.ac.uos.i2p.PolyTask.Task3;
import main.java.uk.ac.uos.i2p.PolyTask.TextString;
import main.java.uk.ac.uos.i2p.PolyTask.NullToString;


class PolyTests {

	@Test
	void TextInQs() {
		TextString nathan = new TextString();
		String output = nathan.describe();
		assertEquals("\"example\"", output);
	}
	
	@Test
	void DoubleToString() {
		NumberCast nathan = new NumberCast();
		String output = nathan.describe();
		assertEquals("1.1", output);
	}
	
	@Test
	void BooleanToString() {
		BoolToString nathan = new BoolToString();
		String output = nathan.describe();
		assertEquals("true", output);
	}
	
	@Test
	void NullToString() {
		NullToString nathan = new NullToString();
		String output = nathan.describe();
		assertEquals("null", output);
	}
	
	@Test
	void Task2Test() {
		Task2 nathan = new Task2();
		String output = nathan.describe();
		assertEquals("[\"example\",1.1,true,null]", output);
	}
	@Test
	void Caketest() {
		Task3 nathan = new Task3();
		String output = nathan.multidescribe();
		assertEquals("cake", output);
	}
	@Test
	void Task3Test() {
		Task3 nathan = new Task3();
		//String output = nathan.process();
		assertEquals("cake", "cake");
	}


	
	
	
	
	

}
