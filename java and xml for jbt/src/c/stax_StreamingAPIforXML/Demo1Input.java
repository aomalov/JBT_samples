package c.stax_StreamingAPIforXML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class Demo1Input {

	public static void main(String[] args) {

		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("files/people.xml"));

			while (eventReader.hasNext()) {

				XMLEvent event = eventReader.nextEvent();

				if (event.getEventType() == XMLStreamConstants.START_ELEMENT) {
					StartElement startElement = event.asStartElement();
					String name = startElement.getName().getLocalPart();
					if (name.equals("name") || name.equals("age")) {
						System.out.print(name + ": ");
					} else {
						System.out.println(name);
					}
					Iterator<Attribute> iter=startElement.getAttributes();
					while(iter.hasNext()){
						Attribute att=iter.next();
						System.out.println("["+att.getName()+"]="+att.getValue());
					}
				}
				else if (event.getEventType() == XMLStreamConstants.CHARACTERS) {
					Characters characters = event.asCharacters();
					if (!characters.isWhiteSpace()) {
						System.out.println(characters);
					}
				}
				else if (event.getEventType()==XMLStreamConstants.ATTRIBUTE){
					StartElement attr=event.asStartElement();
					System.out.println("attribute "+attr.getName()); 
				}
			}

		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
