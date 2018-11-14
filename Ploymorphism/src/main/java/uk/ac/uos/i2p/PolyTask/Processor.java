package main.java.uk.ac.uos.i2p.PolyTask;

import java.io.IOException;
import java.util.Iterator;

public interface Processor {
	void process(Iterator<String> it) throws IOException;
}
