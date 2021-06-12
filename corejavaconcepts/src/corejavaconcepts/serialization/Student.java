package corejavaconcepts.serialization;

import java.io.Serializable;

//serializable is a marker interface , it must be implemented to serialize this object
@SuppressWarnings("serial")
public class Student implements Serializable {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", phno=" + phno + ", testExtra="
				+ testExtra + "]";
	}
	private int id;
	private String name;
	private int marks;
	private long phno;
	private int testExtra;
	public Student(int id, String name, int marks, long phno,int testExtra) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.phno = phno;
		this.testExtra = testExtra;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getMarks() {
		return marks;
	}
	public long getPhno() {
		return phno;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public int getTestExtra() {
		return testExtra;
	}
	public void setTestExtra(int testExtra) {
		this.testExtra = testExtra;
	}
	public String printStudDetails() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", phno=" + phno + ", testExtra="
				+ testExtra + "]";
	}
}
