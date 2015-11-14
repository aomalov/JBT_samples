package z.drills.drill03;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import errorHandlers.MyErrorHandler;

public class PersonCounter {

	public static void main(String[] args) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setErrorHandler(new MyErrorHandler());
			Document doc = db.parse("files/people.xml");
			System.out.println("xml document is valid");

			NodeList persons = doc.getElementsByTagName("person");
			int numOfPerson = persons.getLength();
			System.out.println("number of 'person' elements = " + numOfPerson);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
