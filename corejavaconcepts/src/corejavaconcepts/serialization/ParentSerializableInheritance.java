package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ParentSerializableInheritance {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Child child = new Child(10,"testchildNmae","male","B.Tech","Chennai");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<Serializing>>>>>>>>>>>>>>>>>>>>>>>>>>");
		serialize(child);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<DeSerializing>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Child child1 = (Child) deserialize();
		System.out.println(child.getAge());
		System.out.println(child.getGender());
		System.out.println(child.getName());
		System.out.println(child.getQualification());
		System.out.println(child.getPlace());
		
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("ParentSerInherit.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(Child Child) throws IOException {
		//Creating File output stream
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("ParentSerInherit.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("ParentSerInherit.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(Child);
		oos.close();
		System.out.println(Child);
		System.out.println("Object serialized suceess fully");
	}
}
class Parent implements Serializable{

	public Parent(int age, String name, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	private int age=40;
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	private String name="parentname";
	private String gender="male";
}
class Child extends Parent{
	public Child(int age, String name, String gender, String qualification, String place) {
		super(age, name, gender);
		this.qualification = qualification;
		this.place = place;
	}
	private String qualification;
	private String place;
	public String getQualification() {
		return qualification;
	}
	public String getPlace() {
		return place;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public void setPlace(String place) {
		this.place = place;
	}
}
