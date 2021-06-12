package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ChildSerializableInheritence {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog bichonFriseDog = new Dog("scooby", 4, "how-how", "cornivoroud", "bichon-frise", "milk");
		System.out.println("<<<<<<<<<<<<<<<<<<<Serialize>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		serialize(bichonFriseDog);
		System.out.println("<<<<<<<<<<<<<<<<<<<DeSerialize>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Dog bichon = (Dog) deserialize();
		System.out.println(bichon);
	}
	private static Object deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("Dog.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		Object obj =  ois.readObject();
		ois.close();
		return obj;
	}

	private static void serialize(Dog dog) throws IOException {
		//Creating File output stream
		System.out.println(dog);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Dog.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("Dog.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(dog);
		oos.close();
		System.out.println("Object serialized suceess fully");
	}
}
class Animal{
	public Animal(){
		System.out.println();
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", legs=" + legs + ", sound=" + sound + ", type=" + type + "]";
	}
	private String name = "Animal";
	private int legs=4;
	private String sound="Animal Sound";
	private String type = "Carnivorous";
	public String getName() {
		return name;
	}
	public int getLegs() {
		return legs;
	}
	public String getSound() {
		return sound;
	}
	public String getType() {
		return type;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Animal(String name, int legs, String sound, String type) {
		super();
		this.name = name;
		this.legs = legs;
		this.sound = sound;
		this.type = type;
	}
}
class Dog extends Animal implements Serializable {
	
	@Override
	public String toString() {
		return "Dog [breed=" + breed + ", food=" + food + ", getName()=" + getName() + ", getLegs()=" + getLegs()
				+ ", getSound()=" + getSound() + ", getType()=" + getType() 
				+ ", toString()=" + super.toString() + "]";
	}
	public Dog(String name, int legs, String sound, String type, String breed, String food) {
		super(name, legs, sound, type);
		this.breed = breed;
		this.food = food;
	}
	private String breed;
	private String food;
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
}

