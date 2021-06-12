package corejavaconcepts.externalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class ExternalizationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExternalModel extmodel = new ExternalModel(1, "demo external ", true);
		System.out.println("<<<<<<<<<<<<<SERIALIZING>>>>>>>>>>>>>>>>>>>>");
		serialize(extmodel);
		System.out.println("<<<<<<<<<<<<<DESERIALIZING>>>>>>>>>>>>>>>>>>>>");
		ExternalModel extmodeldeser = (ExternalModel)deserialize();
		System.out.println(extmodeldeser);
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("ExternalModel.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(ExternalModel testobj) throws IOException {
		//Creating File output stream
		System.out.println(testobj);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("ExternalModel.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("ExternalModel.ser");
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
