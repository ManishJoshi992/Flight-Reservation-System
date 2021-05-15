package service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import domain.Agent;
import domain.Airline;
import domain.Airport;
import domain.Flight;
import domain.Passenger;
import domain.Reservation;
import domain.Ticket;
import repository.ReservationSystemRepository;

public class ReservationSystemServiceImpl implements ReservationSystemService {

	private ReservationSystemRepository repository;

	ReservationSystemServiceImpl(ReservationSystemRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Airport> findAllAirports() {
		return repository.findAllAirports();
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		return repository.findAirportByAirportCode(airportCode);
	}

	@Override
	public List<Airport> findAirportsByCity(String city) {
		return repository.findAirportsByCity(city);
	}

	@Override
	public List<Airline> findAirlines() {
		return repository.findAirlines();
	}

	@Override
	public List<Flight> findFlights() {
		return repository.findFlights();
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {
		
		return repository.findAirlinesByAirportCode(airportCode);
	}

	@Override
	public List<Reservation> findReservationsByPassengerId(Integer passengerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> findPassengersByAgentCode(String agentCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation createReservation(List<Passenger> passenger, Flight flights) {
		// TODO Auto-generated method stub
		return repository.createReservation(passenger, flights);
	}

	@Override
	public Reservation createReservation(Agent agent, List<Passenger> passenger, Flight flights) {
		// TODO Auto-generated method stub
		
		return repository.createReservation(agent, passenger, flights);
	}

	/*
	 * @Override public void confirmReservation(String reservationCode) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public List<Ticket> confirmReservation(Reservation reservation) {
		return repository.confirmReservation(reservation);
	}
	
	@Override
	public void findFlightsFromTo(String departure, String arrival, LocalDate flightDate) {
		
		  repository.findFlightsFromTo( departure,  arrival,  flightDate);
	}
	
	/*
	 * @Override public void confirmReservation(String reservationCode, String
	 * agentCode) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	@Override
	public List<Agent> findAgentList(){
		return repository.findAgentList();
	}
	/*
	@Override
	public List<Reservation> viewReservation() {
		return repository.viewReservation();
	}
	*/

	

}
