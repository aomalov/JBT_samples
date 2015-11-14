package d.trasformers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Demo1DocumentToXML {

	public static void main(String[] args) {
		
		try {
			Document domDocument = getDocument();
			DOMSource source = new DOMSource(domDocument);
			StreamResult result = new StreamResult(new FileOutputStream("transformers/result.xml"));
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.transform(source, result); // creating the xml
			System.out.println("done");
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}

	public static Document getDocument() throws ParserConfigurationException {

		// 1. Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// 2. Get a Parser
		DocumentBuilder db = dbf.newDocumentBuilder();

		// 3. Get a new empty document (to build from scratch)
		Document doc = db.newDocument();

		// 4. == creating nodes ================
		Element people = doc.createElement("people");
		Element person = doc.createElement("person");
		Element name = doc.createElement("name");
		Element age = doc.createElement("age");
		Text nameVal = doc.createTextNode("Tom");
		Text ageVal = doc.createTextNode("30");

		// 5. === binding nodes ================
		name.appendChild(nameVal);
		age.appendChild(ageVal);
		person.appendChild(name);
		person.appendChild(age);
		person.setAttribute("gender", "M");
		people.appendChild(person);
		doc.appendChild(people);

		System.out.println("document is built in memory");

		return doc;

	}

}
