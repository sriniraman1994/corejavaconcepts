package corejavaconcepts.serialization;

import java.io.Serializable;

public class TestCustomSerializerModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "TestCustomSerializerModel [id=" + id + ", name=" + name + ", testNewField=" + testNewField + "]";
	}
	private int id;
	private String name;
	private String testNewField="new field added after serialization completed";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTestNewField() {
		return testNewField;
	}
	public void setTestNewField(String testNewField) {
		this.testNewField = testNewField;
	}
	
}
