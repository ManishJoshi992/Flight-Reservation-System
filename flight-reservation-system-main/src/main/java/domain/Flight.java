package domain;

import java.time.LocalDate;
import java.util.UUID;

public class Flight {
	
	private String id;
	private String number;
	private int capacity;
	private Airline airline;
	private Airport departureAirport;
	private Airport arrivalAirport;
	private LocalDate departureTime;
	private LocalDate arrivalTime;

	public Flight(String number, int capacity, Airline airline, Airport departureAirport,
			Airport arrivalAirport, LocalDate departureTime, LocalDate arrivalTime) {

		this.id = UUID.randomUUID().toString();
		this.number = number;
		this.capacity = capacity;
		this.airline = airline;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDate getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDate arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		
		
		return "number= " + getNumber() + ", airline= " + getAirline().getName()
				+ ", departureAirport= " + getDepartureAirport().getName() + ", ArrivalAirport= " + getArrivalAirport().getName() + ", departureTime="
				+ getDepartureTime() + ", arrivalTime= " + getArrivalTime() + "\n";
	}
	
	

}
