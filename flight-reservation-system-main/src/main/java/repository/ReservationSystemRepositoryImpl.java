package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import domain.Address;
import domain.Agent;
import domain.Airline;
import domain.Airport;
import domain.Crew;
import domain.Flight;
import domain.FlightInstance;
import domain.Passenger;
import domain.Pilot;
import domain.Reservation;
import domain.Ticket;

public class ReservationSystemRepositoryImpl implements ReservationSystemRepository {

	private List<Airport> airports = new ArrayList<>();
	private List<Airline> airlines = new ArrayList<>();
	private List<Flight> flights = new ArrayList<>();
	private List<Pilot> pilots = new ArrayList<>();
	private List<Crew> crews = new ArrayList<>();
//	private List<Passenger> passengers = new ArrayList<>();
	private List<Agent> agents = new ArrayList<>();

	ReservationSystemRepositoryImpl() {
		super();
		setupAirports();
		setupAirlines();
		setupPilots();
		setupCrew();
		setupFlights();
		// setupPassenger();
		setupAgent();
	}

	private void setupAirports() {

		Airport airport;
		airport = new Airport("CID", "Eastern Iowa Airport", new Address());
		airports.add(airport);
		airport = new Airport("ORD", "Chicago O'Hare International Airport", new Address());
		airports.add(airport);
		airport = new Airport("CLT", "Charlotte Douglas International Airport", new Address());
		airports.add(airport);

	}

	private void setupAirlines() {

		Airline airline;

		airline = new Airline("USA", "American Airlines", "Since 1992");
		airlines.add(airline);
		airline = new Airline("Qatar", "Qatar Airlines", "Since 1990");
		airlines.add(airline);
		airline = new Airline("Nepal", "Nepal Airlines", "Since 2000");
		airlines.add(airline);
		airline = new Airline("Doha", "Doha Airlines", "Since 2000");
		airlines.add(airline);

	}

	public void setupPilots() {
		Pilot pilot;
		pilot = new Pilot("Pascal", 25, "Senior Pilots");
		pilots.add(pilot);
		pilot = new Pilot("Biniyam", 25, "Senior Pilots");
		pilots.add(pilot);
		pilot = new Pilot("Tirth", 25, "Senior Pilots");
		pilots.add(pilot);
	}

	public void setupCrew() {
		Crew crew;
		crew = new Crew("Jenna", 20, "Senior airhostress");
		crews.add(crew);
		crew = new Crew("mina", 20, "Senior Pilots");
		crews.add(crew);
		crew = new Crew("Asmita", 20, "Senior Pilots");
		crews.add(crew);
	}

	public void setupAgent() {
		Agent agent;
		agent = new Agent("Agent1", 23, "Agent 1");
		agents.add(agent);
		agent = new Agent("Agent2", 23, "Agent 2");
		agents.add(agent);
		agent = new Agent("Agent3", 23, "Agent 3");
		agents.add(agent);
	}

	// to get random dates

	public static LocalDate date() {
		int hundredYears = 100 * 365;
		return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-hundredYears, hundredYears));
	}

	public void setupFlights() {
		Flight flight;
		flight = new Flight("1A", 100, airlines.get(0), airports.get(1), airports.get(0), LocalDate.parse("2021-01-22"),
				LocalDate.parse("2021-01-23"));
		flights.add(flight);
		flight = new Flight("1B", 100, airlines.get(1), airports.get(1), airports.get(2), LocalDate.parse("2021-01-21"),
				LocalDate.parse("2021-01-23"));
		flights.add(flight);
		flight = new Flight("1C", 100, airlines.get(2), airports.get(0), airports.get(2), LocalDate.parse("2021-02-24"),
				LocalDate.parse("2021-01-25"));
		flights.add(flight);
		flight = new Flight("1D", 100, airlines.get(3), airports.get(2), airports.get(1), LocalDate.parse("2021-01-25"),
				LocalDate.parse("2021-01-25"));
		flights.add(flight);

	}

	/*
	 * public void setupPassenger() {
	 * 
	 * Passenger passenger; passenger = new Passenger("Tirth", "Joshi",
	 * LocalDate.parse("1995-02-01"), "joshimanish992@gmail.com", new Address());
	 * passengers.add(passenger); passenger = new Passenger("Pascal", "Joshi",
	 * LocalDate.parse("1995-03-01"), "pascal@gmail.com", new Address());
	 * passengers.add(passenger); passenger = new Passenger("Biniyam", "Joshi",
	 * LocalDate.parse("1995-04-01"), "biniyam@gmail.com", new Address());
	 * passengers.add(passenger); passenger = new Passenger("Manish", "Joshi",
	 * LocalDate.parse("1995-05-01"), "manish992@gmail.com", new Address());
	 * passengers.add(passenger);
	 * 
	 * }
	 */
	public FlightInstance setupFlightInstance(LocalDate flightDate, List<Passenger> passenger, List<Pilot> pilots,
			List<Crew> crew, Flight flight) {

		return new FlightInstance(flightDate, passenger, pilots, crew, flight);
	}

	public Reservation setupReservation(String reservationCode, List<Passenger> passengers,
			List<FlightInstance> flightInstance, Agent agent) {

		return new Reservation(reservationCode, passengers, flightInstance, agent);
	}

	public Ticket setupTicket(long ticketNumber, String reservationCode, FlightInstance singleInstance) {
		return new Ticket(ticketNumber, reservationCode, singleInstance);
	}

	@Override
	public List<Airport> findAllAirports() {
		return airports;
	}

	@Override
	public Airport findAirportByAirportCode(String airportCode) {
		for (Airport airport : findAllAirports()) {
			if (airport.getCode().equalsIgnoreCase(airportCode)) {
				return airport;
			}
		}
		return null;
	}

	@Override
	public List<Airport> findAirportsByCity(String city) {
		List<Airport> li = new ArrayList<>();
		for (Airport airport : airports) {
			if (airport.getAddress().getCity().equals(city)) {
				li.add(airport);
			}
			return li;
		}
		return null;
	}

	@Override
	public List<Airline> findAirlines() {
		return airlines;
	}

	@Override
	public List<Airline> findAirlinesByAirportCode(String airportCode) {

		List<Airline> li = new ArrayList();
		for (Flight f : flights) {
			if (f.getDepartureAirport().getCode().equalsIgnoreCase(airportCode)) {
				if (f.getDepartureTime().equals(LocalDate.now())) {
					li.add(f.getAirline());
				}
			}
		}
		return li;
	}

	@Override
	public List<Flight> findFlights() {
		return flights;
	}

	@Override
	public void findFlightsFromTo(String departure, String arrival, LocalDate flightDate) {

		List<Flight> li = new ArrayList();
		for (Flight f : flights) {
			if (f.getDepartureAirport().getCode().equalsIgnoreCase(departure)) {
				if (f.getArrivalAirport().getCode().equalsIgnoreCase(arrival))
					if (f.getDepartureTime().equals(flightDate)) {
						li.add(f);
					}
			}
		}
		System.out.println(li);

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
	public List<Agent> findAgentList() {
		return agents;

	}

	public FlightInstance createFlightInstance(List<Passenger> passengers, Flight flights) {
		// TODO Auto-generated method stub
		List<Pilot> pilotsIns = new ArrayList<Pilot>();
		pilotsIns.add(pilots.get(2));
		pilotsIns.add(pilots.get((int) (Math.random() * 2)));

		List<Crew> crewsIns = new ArrayList<Crew>();
		crewsIns.add(crews.get(1));
		crewsIns.add(crews.get((int) (Math.random() * 2)));

		return setupFlightInstance(LocalDate.now(), passengers, pilotsIns, crewsIns, flights);
	}

	@Override
	public Reservation createReservation(List<Passenger> passengers, Flight flights) {
		// TODO Auto-generated method stub
		List<FlightInstance> flightIns = new ArrayList<>();
		flightIns.add(createFlightInstance(passengers, flights));

		return setupReservation(ReservationSystemRepositoryImpl.randomUpper(), passengers, flightIns, null);
	}

	@Override
	public Reservation createReservation(Agent agent, List<Passenger> passenger, Flight flights) {
		// TODO Auto-generated method stub
		List<FlightInstance> flightIns = new ArrayList<>();
		flightIns.add(createFlightInstance(passenger, flights));

		return setupReservation(ReservationSystemRepositoryImpl.randomUpper(), passenger, flightIns, agent);
	}

	@Override
	public List<Ticket> confirmReservation(Reservation reservation) {
		return createTicket(reservation.getReservationCode(), reservation);
	}

	// @Override
	public List<Ticket> createTicket(String reservationCode, Reservation reservation) {
		List<Ticket> t = new ArrayList<>();
		for (FlightInstance singleInstance : reservation.getFlightInstance()) {
			t.add(setupTicket(randomTicket(), reservationCode, singleInstance));
		}
		return t;
	}

	public static String randomUpper() {
		String myString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

		Random randomNumber = new Random();
		StringBuilder sb = new StringBuilder(myString.length());

		for (int i = 0; i < 10; i++) {
			int randomNo = randomNumber.nextInt(myString.length());
			Character character = myString.charAt(randomNo);
			sb.append(Character.toUpperCase(character));

		}
		return sb.toString();
	}

	public static int randomTicket() {
		Random r = new Random();
		int low = 100000001;
		int high = 999999999;
		int result = r.nextInt(high - low) + low;
		return result;
	}

}
