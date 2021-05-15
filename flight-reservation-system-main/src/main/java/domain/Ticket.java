package domain;

import java.util.UUID;

public class Ticket {
	
	public String ticketId;
	public long ticketNumber;
	public String reservationCode;
	public FlightInstance singleInstance;
	
	public Ticket(long ticketNumber, String reservationCode, FlightInstance singleInstance) {
		this.ticketId = UUID.randomUUID().toString();;
		this.ticketNumber = ticketNumber;
		this.reservationCode = reservationCode;
		this.singleInstance = singleInstance;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getReservationCode() {
		return reservationCode;
	}
	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}
	public FlightInstance getSingleInstance() {
		return singleInstance;
	}
	public void setSingleInstance(FlightInstance singleInstance) {
		this.singleInstance = singleInstance;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketNumber=" + ticketNumber + ", reservationCode="
				+ reservationCode + ", singleInstance=" + singleInstance + "]";
	}

	
}
