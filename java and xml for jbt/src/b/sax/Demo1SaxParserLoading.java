package b.sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import classes.Person;

public class Demo1SaxParserLoading {

	public static void main(String[] args) {

		try {

			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			MyDefaultHandler dh = new MyDefaultHandler();
			sp.parse("files/people.xml", dh);

			List<Person> persons = dh.getPersons();
			System.out.println(persons);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}
}
