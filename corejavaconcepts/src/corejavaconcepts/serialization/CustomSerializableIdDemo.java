package corejavaconcepts.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CustomSerializableIdDemo {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<DESERIALIZING>>>>>>>>>>>>>>>>>>>");
		TestCustomSerializerModel model = (TestCustomSerializerModel)deserialize();
		System.out.println(model);
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("TestCustomSerializerModel.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

}
