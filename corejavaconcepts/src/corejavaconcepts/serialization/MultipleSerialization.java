package corejavaconcepts.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MultipleSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student student1 = new Student(1, "Srinivasan", 90, Long.parseLong("8124706168"),5);
		Employee emp = new Employee(1112, "testEmployee", "TESTSOCIAL1234");
		List<Object> studEmpList = new ArrayList<Object>();
		studEmpList.add(student1);
		studEmpList.add(emp);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<Serilaize>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		serialize(studEmpList);
		//FIXME I have used two streams , need to find a better solution with streams 
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<Serilaize>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		List<Object> deSerStudEmpList= deserialize();
		deSerStudEmpList.stream().filter(obj->obj instanceof Student).map(mapper->(Student)mapper).
						forEach(action->System.out.println(action.printStudDetails()));
		deSerStudEmpList.stream().filter(obj->obj instanceof Employee).map(mapper->(Employee)mapper).
						forEach(action->System.out.println(action.printEmpDetails()));
		//FIXME uncomment me and delete stream implementation if solution not feasible with streams
		//without streams
//		deSerStudEmpList.forEach(obj->{
//			if(obj instanceof Student) {
//				System.out.println("Student Object deserialized and typcasted");
//				System.out.println((Student)obj);
//			}else if(obj instanceof Employee) {
//				System.out.println("Employee Object deserialized and typcasted");
//				System.out.println((Employee)obj);
//			}else {
//				System.out.println("issue with objects in the list type casted");
//			}
//		});
	}
	private static List<Object> deserialize() throws IOException, ClassNotFoundException {
		//Creating File input stream
		FileInputStream fis = new FileInputStream("Strudent-Emp.ser");
		//Creating Object input stream
		ObjectInputStream ois = new ObjectInputStream(fis);
		//read object from ser file or network 
		List<Object> studEmpList = new ArrayList<Object>();
		studEmpList = (List<Object>)ois.readObject();
		ois.close();
		return studEmpList;
	}

	private static void serialize(List<Object> studEmpList) throws IOException {
		//Creating File output stream
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("Strudent-Emp.ser");
		}catch (FileNotFoundException exception) {
			 File studentSerFile = new File("Strudent-Emp.ser");
			 studentSerFile.createNewFile();
			 fos = new FileOutputStream(studentSerFile);
			 System.out.println("file not found");
		}
		//Creating Object output stream
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//save object to ser file or network
		oos.writeObject(studEmpList);
		oos.close();
		studEmpList.forEach(action->System.out.println(action));
		System.out.println("Object serialized suceess fully");
	}
}
