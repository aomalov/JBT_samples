package z.drills.drill05;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
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

			System.out.println("\nnames, ages and gender: ");
			NodeList names = doc.getElementsByTagName("name");
			NodeList ages = doc.getElementsByTagName("age");

			for (int i = 0; i < numOfPerson; i++) {
				Node name = names.item(i);
				Node age = ages.item(i);
				if (name.getFirstChild() instanceof Text) {
					Text textNode = (Text) name.getFirstChild();
					// print the name
					// System.out.print("name: " + textNode.getNodeValue());
					System.out.print("name: " + textNode.getData());
				}

				// print the age
				System.out
						.print(", age: " + age.getFirstChild().getNodeValue());

				// print the gender attribute
				NamedNodeMap genderAttribs = persons.item(i).getAttributes();
				Attr attrib = (Attr) genderAttribs.getNamedItem("gender");
				System.out.print("\t| " + attrib);
				System.out.println();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
