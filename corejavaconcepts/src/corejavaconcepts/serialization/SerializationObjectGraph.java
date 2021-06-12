package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationObjectGraph {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		TestClassOne testClassOne = new TestClassOne(1, "One");
		TestClassTwo testClassTwo = new TestClassTwo(2, "Two");
		ObjectGraphSer objectGraphSer = new ObjectGraphSer(testClassOne, testClassTwo, 12);
		System.out.println("<<<<<<<<<<<<<Serializing>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		serialize(objectGraphSer);
		System.out.println("<<<<<<<<<<<<<DeSerializing>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		ObjectGraphSer obj = (ObjectGraphSer)deserialize();
		System.out.println(obj);
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("ObjectGraph.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(ObjectGraphSer objectGraphSer) throws IOException {
		//Creating File output stream
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("ObjectGraph.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("ObjectGraph.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(objectGraphSer);
		oos.close();
		System.out.println(objectGraphSer);
		System.out.println("Object serialized suceess fully");
	}
}
class ObjectGraphSer implements Serializable{
	@Override
	public String toString() {
		return "ObjectGraphSer [testClassOne=" + testClassOne + ", testClassTwo=" + testClassTwo + ", testValue="
				+ testValue + "]";
	}
	public ObjectGraphSer(TestClassOne testClassOne, TestClassTwo testClassTwo, int testValue) {
		this.testClassOne = testClassOne;
		this.testClassTwo = testClassTwo;
		this.testValue = testValue;
	}
	private TestClassOne testClassOne;
	private TestClassTwo testClassTwo;
	private int testValue;
	public TestClassOne getTestClassOne() {
		return testClassOne;
	}
	public TestClassTwo getTestClassTwo() {
		return testClassTwo;
	}
	public int getTestValue() {
		return testValue;
	}
	public void setTestClassOne(TestClassOne testClassOne) {
		this.testClassOne = testClassOne;
	}
	public void setTestClassTwo(TestClassTwo testClassTwo) {
		this.testClassTwo = testClassTwo;
	}
	public void setTestValue(int testValue) {
		this.testValue = testValue;
	}
}
class TestClassOne implements Serializable {
	@Override
	public String toString() {
		return "TestClassOne [testIDOne=" + testIDOne + ", testStringOne=" + testStringOne + "]";
	}
	public TestClassOne(int testIDOne, String testStringOne) {
		this.testIDOne = testIDOne;
		this.testStringOne = testStringOne;
	}
	private int testIDOne;
	private String testStringOne;
	public int getTestIDOne() {
		return testIDOne;
	}
	public void setTestIDOne(int testIDOne) {
		this.testIDOne = testIDOne;
	}
	public String getTestStringOne() {
		return testStringOne;
	}
	public void setTestStringOne(String testStringOne) {
		this.testStringOne = testStringOne;
	}
}
class TestClassTwo implements Serializable{
	@Override
	public String toString() {
		return "TestClassTwo [testIDTwo=" + testIDTwo + ", testStringTwo=" + testStringTwo + "]";
	}
	public TestClassTwo(int testIDTwo, String testStringTwo) {
		this.testIDTwo = testIDTwo;
		this.testStringTwo = testStringTwo;
	}
	private int testIDTwo;
	private String testStringTwo;
	public int getTestIDTwo() {
		return testIDTwo;
	}
	public void setTestIDTwo(int testIDTwo) {
		this.testIDTwo = testIDTwo;
	}
	public String getTestStringTwo() {
		return testStringTwo;
	}
	public void setTestStringTwo(String testStringTwo) {
		this.testStringTwo = testStringTwo;
	}
}