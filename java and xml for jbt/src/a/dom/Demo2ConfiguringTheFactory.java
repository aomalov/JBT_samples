package a.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import errorHandlers.MyErrorHandler;

public class Demo2ConfiguringTheFactory {

	public static void main(String[] args) {
		try {

			// 1. Instantiate the Factory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			dbf.setValidating(true); // the parser produced by this code will
										// validate documents as they are parsed
										// using DTD

			dbf.setNamespaceAware(true);// Specifies that the parser produced by
										// this code will provide support for
										// XML namespaces.

			dbf.setIgnoringComments(true);// Specifies that the parser produced
											// by this code will ignore
											// comments.

			dbf.setIgnoringElementContentWhitespace(true);// Specifies that the
															// parsers created
															// by this factory
															// must eliminate
															// whitespace in
															// element content
															// when parsing XML
															// documents

			System.out.println("DocumentBuilderFactory");
			System.out.println("isValidating = " + dbf.isValidating());
			System.out.println("isNamespaceAware = " + dbf.isNamespaceAware());
			System.out.println("isIgnoringComments = "
					+ dbf.isIgnoringComments());
			System.out.println("isIgnoringElementContentWhitespace = "
					+ dbf.isIgnoringElementContentWhitespace());
			System.out.println("getSchema = " + dbf.getSchema());

			// 2. Get a Parser
			DocumentBuilder db = dbf.newDocumentBuilder();
			db.setErrorHandler(new MyErrorHandler()); // SET ERROR HANDLER
			System.out.println("\nDocumentBuilder");
			System.out.println("isValidating = " + db.isValidating());
			System.out.println("isNamespaceAware = " + db.isNamespaceAware());
			System.out.println("getSchema = " + db.getSchema());

			// 3. Parse the File
			Document doc = db.parse("files/people.xml");

			System.out.println("Success: " + doc.toString());

		} catch (ParserConfigurationException | IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println(e.getMessage());
		}

	}

}
