package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student student1 = new Student(1, "Srinivasan", 90, Long.parseLong("8124706168"),5);
		System.out.println("<<<<<<<<<<<<<Serializing>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		serialize(student1);
		System.out.println("<<<<<<<<<<<<<DeSerializing>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Student student2 = (Student)deserialize();
		System.out.println(student2);
	}

	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("Strudent.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(Student student1) throws IOException {
		//Creating File output stream
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Strudent.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("Strudent.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(student1);
		oos.close();
		System.out.println(student1);
		System.out.println("Object serialized suceess fully");
	}
}
