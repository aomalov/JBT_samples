package b.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Demo2Simple {

	public static void main(String[] args) {

		try {

			SAXParserFactory spf = SAXParserFactory.newInstance(); // factory
			SAXParser sp = spf.newSAXParser(); // parser
			MyDefaultHandlerSimple dh = new MyDefaultHandlerSimple(); // handler object
			sp.parse("files/people.xml", dh); // parsing the xml doc

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}
}
