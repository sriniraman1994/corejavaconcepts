package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeCustomSerilaizerModel {
	public static void main(String[] args) throws IOException {
		TestCustomSerializerModel model = new TestCustomSerializerModel();
		model.setId(123);
		model.setName("TestforSerailization");
		serialize(model);
	}
	private static void serialize(TestCustomSerializerModel testobj) throws IOException {
		//Creating File output stream
		System.out.println(testobj);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("TestCustomSerializerModel.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("TestCustomSerializerModel.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(testobj);
		oos.close();
		System.out.println("Object serialized suceess fully");
	}
	
}
