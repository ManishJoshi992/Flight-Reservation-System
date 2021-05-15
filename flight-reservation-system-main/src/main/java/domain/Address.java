package domain;

import java.util.Locale;
import java.util.UUID;

import com.github.javafaker.Faker;

public class Address {
	
	private final String id;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zip;

	public Address() {
		super();
		Faker faker = new Faker(new Locale("us-en"));

		this.street = faker.address().buildingNumber() + " " + faker.address().streetName();
		this.city = faker.address().city();
		this.state = faker.address().state();
		this.zip = faker.address().zipCode();
		
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "street=" + getStreet() + ", city=" + getCity() + ", state=" + getState() 
		+ ", zip=" + getZip() ;
	}
	
	

}
