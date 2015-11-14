package a.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import errorHandlers.MyErrorHandler;

public class Demo5Elements {

	public static void main(String[] args) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setErrorHandler(new MyErrorHandler());
			Document doc = db.parse("files/people.xml");
			System.out.println("xml document is valid");
			System.out.println();

			// getting the ROOT ELEMENT of the xml document
			Element root = doc.getDocumentElement();
			System.out.println("root element name: " + root.getNodeName());
			System.out.println("root element value: " + root.getNodeValue());
			System.out.println("root element type: " + root.getNodeType());
			// type value 1 is element

			System.out.println("\nchild element:");
			NodeList nodes = root.getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {
				if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
					System.out.print("node: name="
							+ nodes.item(i).getNodeName());
					System.out.println(", type=" + nodes.item(i).getNodeType());
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
