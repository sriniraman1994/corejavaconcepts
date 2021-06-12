package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustomSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TestCustomSerialization testCustomSerialization = new TestCustomSerialization();
		testCustomSerialization.setAdharNo("12345678");
		testCustomSerialization.setUserName("user1");
		testCustomSerialization.setTestNum(854212);
		System.out.println("<<<<<<<<<<<<<<<<Serialization>>>>>>>>>>>>>>>>>");
		serialize(testCustomSerialization);
		System.out.println("<<<<<<<<<<<<<<<<DeSerialization>>>>>>>>>>>>>>>>>");
		System.out.println((TestCustomSerialization)deserialize());
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("Custom.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(TestCustomSerialization testobj) throws IOException {
		//Creating File output stream
		System.out.println(testobj);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Custom.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("Custom.ser");
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
class TestCustomSerialization implements Serializable{
	private String userName;
	private transient String adharNo;
	private transient int testNum;
	public int getTestNum() {
		return testNum;
	}
	public void setTestNum(int testNum) {
		this.testNum = testNum;
	}
	public String getUserName() {
		return userName;
	}
	public String getAdharNo() {
		return adharNo;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}
	@Override
	public String toString() {
		return "TestCustomSerialization [userName=" + userName + ", adharNo=" + adharNo + ", testNum=" + testNum + "]";
	}
	private void writeObject(ObjectOutputStream oos) throws IOException {
		System.out.println("Overridden writeObject called");
		oos.defaultWriteObject();
		adharNo = new StringBuffer(adharNo).reverse().toString();
		testNum = reversNumber(testNum);
		oos.writeObject(adharNo);
		oos.writeInt(testNum);
	}
	private int reversNumber(int testNum) {
		int reversedNum =0;
		while(testNum >0) {
			reversedNum = reversedNum*10+testNum%10;
			testNum/=10; 
		}
		return reversedNum;
	}
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		System.out.println("Overridden readObject called");
		ois.defaultReadObject();
		adharNo = new StringBuffer((String)ois.readObject()).reverse().toString();
		testNum = reversNumber(ois.readInt());
	}
}