package a.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Demo1MainObjects {

	public static void main(String[] args) {
		try {

			// 1. Instantiate the Factory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			
			// 2. Get a Parser
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			// 3. Parse the File
			Document doc = db.parse("files/people.xml");
			
			System.out.println("Success: " + doc.toString());

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
