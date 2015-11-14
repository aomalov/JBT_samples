package z.drills.drill04;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
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
			
			System.out.println("\nnames: ");
			NodeList names = doc.getElementsByTagName("name");
			
			for (int i = 0; i < names.getLength(); i++) {
				Node name = names.item(i);
				
				if(name.getFirstChild() instanceof Text){
					Text textNode = (Text)name.getFirstChild();
					System.out.println(textNode.getNodeValue());
				}
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
