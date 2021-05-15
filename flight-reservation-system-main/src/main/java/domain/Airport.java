package domain;

import java.util.UUID;

public class Airport {
	
	private final String id;
	
	private String code;
	
	private String name;
	
	private Address address;

	public Airport(String code, String name, Address address) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String output ="code=" + getCode() + ", name=" + getName() + ", Address=" +getAddress().toString()+"\n";
		return output;
	}

}
