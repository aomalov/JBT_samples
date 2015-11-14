package e.more;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import classes.Person;

public class ObjectFromXML {
	
	public static void main(String[] args) {
		try(XMLDecoder decoder = new XMLDecoder(new FileInputStream("more/person.xml"));) {
			Person p = (Person) decoder.readObject();
			System.out.println("reading from xml file");
			System.out.println(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
