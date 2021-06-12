package corejavaconcepts.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
	private int empId;
	private String name;
	//static variables do not participate in selialization as it is class specific,selerialization 
	//deals with object of the class
	//transient has no effect on it
	private static int departmentId;
	//For transient variables , the JVM assignes default value and its original value not serialized
	private transient String socialId;
	//final values take part in serialization as a value , as it cannot be changed 
	public final int finalValue = 300;
	//transient has no effect on final values when values assigned directly 
	public transient final int taransienttFinalValue =200 ;
	//When final variable declared at instance block transient keyword has effect on final variable
	//FIXME uncomment to check the effect of transient keyword on final variable declared in instance block
//	{
//		taransienttFinalValue = 200;
//	}
	
	public Employee(int empId, String name, String socialId) {
		super();
		this.empId = empId;
		this.name = name;
		this.socialId = socialId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", socialId=" + socialId + ", finalValue=" + finalValue
				+ ", taransienttFinalValue=" + taransienttFinalValue + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public static int getDepartmentId() {
		return departmentId;
	}
	public String getSocialId() {
		return socialId;
	}
	public int getFinalValue() {
		return finalValue;
	}
	public int getTaransienttFinalValue() {
		return taransienttFinalValue;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void setDepartmentId(int departmentId) {
		Employee.departmentId = departmentId;
	}
	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}
	public String printEmpDetails() {
		return "Employee [empId=" + empId + ", name=" + name + ", socialId=" + socialId + ", finalValue=" + finalValue
				+ ", taransienttFinalValue=" + taransienttFinalValue + "]";
	}
}
