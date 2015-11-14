package e.more;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import classes.Person;

public class ObjectToXML {

	public static void main(String[] args) {

		try (XMLEncoder e = new XMLEncoder(new FileOutputStream("more/person.xml"));) {

			Person p = new Person();
			p.setName("Avi");
			p.setAge(18);

			e.writeObject(p);

			System.out.println(p + " written as xml");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
