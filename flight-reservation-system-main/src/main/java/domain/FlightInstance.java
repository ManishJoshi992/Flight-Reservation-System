package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlightInstance {
	
	private String id;
	private LocalDate flightDate;
	private List<Passenger> passenger = new ArrayList<>();
	private List<Pilot> pilots = new ArrayList<>();
	private List<Crew> crews = new ArrayList();
	private Flight flight;

	public FlightInstance(LocalDate flightDate, List<Passenger> passenger, List<Pilot> pilots, List<Crew> crew,
			Flight flight) {
		this.id = UUID.randomUUID().toString();
		this.flightDate = flightDate;
		this.passenger = passenger;
		this.pilots = pilots;
		this.crews = crew;
		this.flight = flight;
	}

	public String getId() {
		return id;
	}
	
	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate flightDate) {
		this.flightDate = flightDate;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public List<Crew> getCrew() {
		return crews;
	}

	public void setCrew(List<Crew> crews) {
		this.crews = crews;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
/*
	@Override
	public String toString() {
		return "FlightInstance [id=" + id + ", flightDate=" + flightDate + ", passenger=" + passenger + ", pilots="
				+ pilots + ", crews=" + crews + ", flight=" + flight + "]";
	}
	*/
	@Override
	public String toString() {
		return flight.toString();
	}

	
}
