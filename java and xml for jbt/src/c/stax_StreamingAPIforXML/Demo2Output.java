package c.stax_StreamingAPIforXML;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

public class Demo2Output {

	public static void main(String[] args) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		try {
			XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileReader("files/people.xml"));
			XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileWriter("copies/people.xml"));
			eventWriter.add(eventReader);

			while (eventReader.hasNext()) {
				eventWriter.add(eventReader.nextEvent());
			}

			eventWriter.flush();

		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}
	}

}
