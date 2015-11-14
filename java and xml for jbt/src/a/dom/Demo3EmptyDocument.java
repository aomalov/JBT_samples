package a.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Demo3EmptyDocument {

	public static void main(String[] args) {
		try {

			// 1. Instantiate the Factory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			// 2. Get a Parser
			DocumentBuilder db = dbf.newDocumentBuilder();

			// 3. Get a new empty document (to build from scratch)
			Document doc = db.newDocument();

			//4. == creating nodes ================
			Element people = doc.createElement("people");
			Element person = doc.createElement("person");
			Element name = doc.createElement("name");
			Element age = doc.createElement("age");
			Text nameVal = doc.createTextNode("Tom");
			Text ageVal = doc.createTextNode("30");
			
			//5. === binding nodes ================
			name.appendChild(nameVal);
			age.appendChild(ageVal);
			person.appendChild(name);
			person.appendChild(age);
			person.setAttribute("sex", "M");
			people.appendChild(person);
			doc.appendChild(people);
			
			System.out.println("document is built in memory");

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

}
