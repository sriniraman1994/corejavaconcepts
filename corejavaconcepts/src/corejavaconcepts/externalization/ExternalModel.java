package corejavaconcepts.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalModel implements Externalizable {
	public ExternalModel() {
		System.out.println("No-args constructor is must for the Externalization");
	}
	@Override
	public String toString() {
		return "ExternalModel [id=" + id + ", name=" + name + ", isExternal=" + isExternal + "]";
	}

	private int id;
	private String name;
	private boolean isExternal;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(name);
		out.writeInt(id);
	}

	public ExternalModel(int id, String name, boolean isExternal) {
		super();
		this.id = id;
		this.name = name;
		this.isExternal = isExternal;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readObject().toString();
		this.id = in.readInt();
	}

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

	public boolean isExternal() {
		return isExternal;
	}

	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}

}
