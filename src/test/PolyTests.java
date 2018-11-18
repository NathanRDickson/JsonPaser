package test;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import org.junit.jupiter.api.Test;

import main.java.uk.ac.uos.i2p.JsonParser.JsonArrayToCollection;
import main.java.uk.ac.uos.i2p.JsonParser.ObjectParser;



class PolyTests {

	@Test
	void jsonArrayToCollectionTest() {
		JsonArrayToCollection nathan = new JsonArrayToCollection("[\"/task/452359-4435382-6595137\", \"/task/99012-65325148-3574826\"]");
		Collection<String> output = nathan.jsonArrayToCollection();
		
		String FinalCopy = "";
		
		for (Object o : output) {
			FinalCopy = FinalCopy + o;
			System.out.println(FinalCopy);
			}
		
		assertEquals("/task/452359-4435382-6595137 /task/99012-65325148-3574826", FinalCopy);
	}
	
	@Test
	void ObjectParserArray() throws Exception {
		ObjectParser nathan = new ObjectParser("\"tasks\": [\"/task/452359-4435382-6595137\", \"/task/99012-65325148-3574826\"]");
		Collection<String> output = nathan.jsonObject();
		
		String FinalCopy = "";
		
		for (Object o : output) {
			FinalCopy = FinalCopy + o;
			System.out.println(FinalCopy);
			}
		
		assertEquals("/task/452359-4435382-6595137 /task/99012-65325148-3574826", FinalCopy);
	}
	


	
	
	
	
	

}
