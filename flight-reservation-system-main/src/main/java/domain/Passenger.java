package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Passenger {

	private String id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String emailAddress;
	private Address residenceAddress;

	public Passenger(String firstName, String lastName, LocalDate birthDate, String emailAddress,
			Address residenceAddress) {
		super();
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
		this.residenceAddress = residenceAddress;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Address getResidenceAddress() {
		return residenceAddress;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setResidenceAddress(Address residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	@Override
	public String toString() {
		return "Passenger firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", emailAddress=" + emailAddress;
	}

}
