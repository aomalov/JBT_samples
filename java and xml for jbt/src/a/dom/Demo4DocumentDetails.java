package a.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.xml.sax.SAXException;

import errorHandlers.MyErrorHandler;

public class Demo4DocumentDetails {

	public static void main(String[] args) {

		try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setErrorHandler(new MyErrorHandler());
			Document doc = db.parse("files/people.xml");

			// DTD info
			DocumentType dtd = doc.getDoctype();
			System.out.println("language name: " + dtd.getName());
			System.out.println("reference to dtd document: "
					+ dtd.getSystemId());
			System.out.println("the PUBLIC identifier: " + dtd.getPublicId());
			System.out.println();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
