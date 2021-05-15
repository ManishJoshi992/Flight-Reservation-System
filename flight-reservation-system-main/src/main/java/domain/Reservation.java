package domain;

import java.util.List;
import java.util.UUID;

public class Reservation {
	
	private String reservationId;
	private String reservationCode;
	private List<Passenger> passengers;
	private List<FlightInstance> flightInstance;
	private Agent agent;
	
	public void makeReservation() {
		
	}
	public Reservation(String reservationCode, List<Passenger> passengers, List<FlightInstance> flightInstance, Agent agent) {
		this.reservationId = UUID.randomUUID().toString();
		this.reservationCode = reservationCode;
		this.passengers = passengers;
		this.flightInstance = flightInstance;
		this.agent = agent;
	}
	
	public String getReservationId() {
		return reservationId;
	}
	public String getReservationCode() {
		return reservationCode;
	}
	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public void confirmReservation() {
		
	}
	public List<FlightInstance> getFlightInstance() {
		return flightInstance;
	}
	public void setFlightInstance(List<FlightInstance> flightInstance) {
		this.flightInstance = flightInstance;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	@Override
	public String toString() {
		
		String s;
		if (agent == null) {
			s = "N/A";
		}else
		s = agent.getName();
		
		String output = "";
		output += "Agent: " + s + ", \n" + "Flight Details: " + flightInstance.toString() + " "
				+ "Passenger Details: " + passengers.toString() +"\n";
		
		/*
		for (Passenger p : passengers) {
			output += " Name - " + p.getFirstName() + " " + p.getLastName() + " email - " + p.getEmailAddress();
		}
		*/
		return output;
	}
	
/*	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", reservationCode=" + reservationCode + ", passengers="
				+ passengers + ", flightInstance=" + flightInstance + ", agent=" + agent + "]";
	}		
*/
}
