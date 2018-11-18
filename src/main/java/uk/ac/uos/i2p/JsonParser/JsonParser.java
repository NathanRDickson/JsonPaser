package main.java.uk.ac.uos.i2p.JsonParser;

import java.util.Collection;

public interface JsonParser {

	Collection<String> jsonObject() throws Exception, Exception;

	Collection<String> jsonArrayToCollection();
	
}
