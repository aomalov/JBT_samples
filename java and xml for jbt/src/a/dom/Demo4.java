package a.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Demo4 {

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("files/people.xml");
			
			NodeList names =  doc.getElementsByTagName("name");
			
			for (int i = 0; i < names.getLength(); i++) {
				Node n = names.item(i);
				Text name = (Text) n.getFirstChild();
				System.out.println(name.getNodeValue());
			}
			
			

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
