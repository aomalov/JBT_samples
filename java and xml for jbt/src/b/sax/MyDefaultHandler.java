package b.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import classes.Person;

public class MyDefaultHandler extends DefaultHandler {

	private List<Person> persons = new ArrayList<>();
	private Person currPerson;
	private int currPersonAttribIndex;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("start document       : ");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end document         : ");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print("start element        : " + qName);

		if (attributes.getLength() > 0) {
			System.out.print(" (");
			for (int i = 0; i < attributes.getLength(); i++) {
				System.out.print(attributes.getQName(i) + "=");
				System.out.print(attributes.getValue(i));
			}
			System.out.print(")");
		}

		System.out.println();

		if (qName.equals("person")) {
			currPerson = new Person();
		} else if (qName.equals("name")) {
			currPersonAttribIndex = 1;
		} else if (qName.equals("age")) {
			currPersonAttribIndex = 2;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("end element          : " + qName);
		
		if(qName.equals("person")){
			persons.add(currPerson);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String val = new String(ch, start, length);
		System.out.println("start characters	     	: " + val);

		switch (currPersonAttribIndex) {
		case 1:
			currPerson.setName(val);
			break;
		case 2:
			currPerson.setAge(Integer.parseInt(val));
			break;

		default:
			break;
		}
	}

	// exceptions
	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("warning              : " + e);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("error                : " + e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("fatal error          : " + e);
	}
	
	

	public List<Person> getPersons() {
		return persons;
	}

}
