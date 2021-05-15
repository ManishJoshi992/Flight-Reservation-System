package service;

import java.time.LocalDate;
import java.util.List;

import domain.Agent;
import domain.Airline;
import domain.Airport;
import domain.Flight;
import domain.Passenger;
import domain.Reservation;
import domain.Ticket;

public interface ReservationSystemService {
	
	List<Airport> findAllAirports();
	
	Airport findAirportByAirportCode(String airportCode);
	
	List<Airport> findAirportsByCity(String city); // Airport(s) of a city, e.g. Chicago has two major airports
	
	List<Airline> findAirlines();
	
	List<Airline> findAirlinesByAirportCode(String airportCode);
	
	List<Flight> findFlights();
	
	void findFlightsFromTo(String departure, String arrival, LocalDate flightDate);
	
	List<Reservation> findReservationsByPassengerId(Integer passengerId);
	
	List<Passenger> findPassengersByAgentCode(String agentCode);
	
	Reservation createReservation(List<Passenger> passenger, Flight flights); // Passenger reserves
	
	Reservation createReservation(Agent agent, List<Passenger> passenger, Flight flights); // Agent reserves
	
	List<Ticket> confirmReservation(Reservation reservation);
	
	//void confirmReservation(String reservationCode);
	
	//void confirmReservation(String reservationCode, String agentCode);
	
	List<Agent> findAgentList();
	
//	List<Reservation> viewReservation();
	
}
