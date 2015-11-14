package a.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import errorHandlers.MyErrorHandler;

public class Demo6ExtractingData {

	public static void main(String[] args) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			dbf.setIgnoringElementContentWhitespace(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setErrorHandler(new MyErrorHandler());
			Document doc = db.parse("files/people.xml");
			System.out.println("xml document is valid");
			System.out.println();

			Node root = doc.getDocumentElement();
			System.out.println("root: " + root.getNodeName());
			NodeList nodes = root.getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				System.out.println();
				printNodeContent(node);
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void printNodeContent(Node node) {

		if (node.getNodeType() == Node.ELEMENT_NODE) {
			System.out.print(node.getNodeName());

			// print attributes if any
			NamedNodeMap attribs = node.getAttributes();

			if (attribs.getLength() > 0) {
				System.out.print(" | attributes: ");
			}

			for (int i = 0; i < attribs.getLength(); i++) {
				System.out.print(attribs.item(i) + ", ");
			}

			System.out.println();
			//

			// print nested nodes
			NodeList nodes = node.getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {
				Node n1 = nodes.item(i);
				System.out.print("  ");
				printNodeContent(n1);
			}
			//

		} else if (node.getNodeType() == Node.TEXT_NODE) {
			System.out.println("  " + node.getParentNode().getNodeName()
					+ " value=" + node.getNodeValue());

		}

	}

}
