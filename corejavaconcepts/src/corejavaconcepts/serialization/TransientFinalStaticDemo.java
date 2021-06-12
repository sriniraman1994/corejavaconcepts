package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientFinalStaticDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Employee emp = new Employee(1112, "testEmployee", "TESTSOCIAL1234");
		Employee.setDepartmentId(1234);
		System.out.println("<<<<<<<<<<<<<Serializing>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		serialize(emp);
		System.out.println("<<<<<<<<<<<<<DeSerializing>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Employee empAfterDeserialize = (Employee) deserialize();
		System.out.println(empAfterDeserialize);
		
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("Employee.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(Employee emp) throws IOException {
		//Creating File output stream
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Employee.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("Employee.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(emp);
		oos.close();
		System.out.println(emp);
		System.out.println("Object serialized suceess fully");
	}
}
