package project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import domain.Address;
import domain.Agent;
import domain.Flight;
import domain.Passenger;
import domain.Reservation;
import domain.Ticket;
import service.ReservationSystemService;
import service.ServiceFactory;

public class Application {

	public static void main(String[] args) {
		System.out.println("Airline Reservation System  \n");
		
		System.out.println("hi this is manish");

		ReservationSystemService service = ServiceFactory.getReservationSystemService();
		// System.out.println(service.findAllAirports());
		// System.out.println(service.findAirportByAirportCode("CID"));
		// System.out.println(service.findAirportsByCity("Gleichnerchester"));
		// System.out.println(service.findAirlines());
		// System.out.println(service.findFlights());
		input(service);
	}

	public static void input(ReservationSystemService service) {
		List<Reservation> reservations = new ArrayList<>();
		List<Passenger> passangers = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("Please select a user:" + "\n" + "1: Admin" + "\n" + "2: Agent" + "\n" + "3: User");

		Scanner scc = new Scanner(System.in);
		int input1 = scc.nextInt();

		// for agent
		if (input1 == 2) {
			System.out.println("Please enter the username");
			Scanner username = new Scanner(System.in);
			int flag = 0;
			Agent agent = null;
			String in = username.next();
			for (Agent a : service.findAgentList()) {
				// System.out.println(a.getName());
				if (a.getName().equalsIgnoreCase(in)) {
					agent = a;
					flag++;
				}
			}
			// System.out.println(flag);

			if (flag == 0) {
				System.out.println("Incorrect username.");
				// input(service);
				System.exit(0);
			}
			while (true) {
				System.out.println("Please choose any operation from the list:" + "\n" + "1: View the list of Airports."
						+ "\n" + "2: View the list of Airlines." + "\n" + "3: View the list of Flights." + "\n"
						+ "4: Make Reservation." + "\n" + "5: Cancel Reservatin." + "\n" + "6: Confirm Reservatin."
						+ "\n"
						+ "7: View list of airlines flying out of an airport (search by airport three letter code)"
						+ "\n" + "8: View list of flights between a departure and destination for a date");
				int input = sc.nextInt();
				if (input == 1) {
					System.out.println(service.findAllAirports());
				}
				if (input == 2) {
					System.out.println(service.findAirlines());
				}

				if (input == 3) {
					System.out.println(service.findFlights());
				}
				if (input == 4) {

					Passenger p1 = new Passenger("Tirth", "Joshi", LocalDate.parse("1995-02-01"),
							"joshimanish992@gmail.com", new Address());
					Passenger p2 = new Passenger("Pascal", "Joshi", LocalDate.parse("1995-03-01"), "pascal@gmail.com",
							new Address());
					passangers.add(p1);
					passangers.add(p2);

					List<Flight> flights = new ArrayList<>();
					flights = service.findFlights();

					for (Flight f : flights) {
						if (f.getDepartureAirport().getName().equals("Chicago O'Hare International Airport") && 
								f.getArrivalAirport().getName().equals("Eastern Iowa Airport")) {
							reservations.add(service.createReservation(agent, passangers, f));
						}
						if (f.getArrivalAirport().getName().equals("Eastern Iowa Airport")) {
							reservations.add(service.createReservation(agent, passangers, f));
						}
					}
					System.out.println("---------------------------");
					System.out.println("Reservation Code(s):");
					for (Reservation r : reservations) {
						System.out.println(r.getReservationCode());
					}
					System.out.println("---------------------------");
					System.out.println("Would you like to see the reservation? Yes/No");
					Scanner scyes = new Scanner(System.in);
					String inputyes = scyes.next();
					if (inputyes.equalsIgnoreCase("Yes")) {
						System.out.println(reservations);
					}
				}

				if (input == 5) {
					System.out.println("---------------------------");
					System.out.println("Enter Reservation Code to Cancel: ");
					sc.nextLine();
					String code = sc.nextLine();
					List<Reservation> toRemove = new ArrayList();
					// reservations.remove(code);
					for (Reservation r : reservations) {
						if (r.getReservationCode().equals(code)) {
							toRemove.add(r);
						}
					}
					reservations.removeAll(toRemove);
					boolean rem = reservations.removeAll(toRemove);
					if(rem) {
					System.out.println("Reservation has been Canceled : " + code);
					}
					System.out.println("---------------------------");
				}

				if (input == 6) {
					Map<Reservation, List<Ticket>> tickets = new HashMap<>();
					System.out.println("---------------------------");
					System.out.println("Enter Reservation Code to Confirm: ");
					sc.nextLine();
					String code = sc.nextLine();
					System.out.println("Confirmed Reservation and Ticket(s):");
					for (Reservation r : reservations) {
						if(r.getReservationCode().equals(code)) {
						tickets.put(r, service.confirmReservation(r));
						}
						}
					for (Reservation k : tickets.keySet()) {
						for (Ticket t : tickets.get(k)) {
						System.out.println("Reservation:" + k.getReservationCode() + ", Ticket: " + t.ticketNumber);
							}
						}
					
					System.out.println("---------------------------");
				}

				if (input == 7) {
					System.out.println("Please enter the airport code: ");
					Scanner codes = new Scanner(System.in);
					String code = codes.next();
					System.out.println(service.findAirlinesByAirportCode(code));
				}
				if (input == 8) {
					System.out.println("Please enter the departure code: ");
					Scanner departure = new Scanner(System.in);
					String departureloc = departure.next();
					System.out.println("Please enter the destination code: ");
					Scanner destination = new Scanner(System.in);
					String destinationloc = departure.next();

					System.out.println("Please enter the date in the following format (YYYY-MM-DD): ");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					Scanner date = new Scanner(System.in);
					String datevalue = date.next();
					LocalDate localDate = LocalDate.parse(datevalue, formatter);
					List<Flight> li = new ArrayList();
					service.findFlightsFromTo(departureloc, destinationloc, localDate);

				}

			}
		}
// for admin
		else if (input1 == 1) {
			while (true) {
				System.out.println("Please choose any operation from the list:" + "\n" + "1: View the list of Airports."
						+ "\n" + "2: View the list of Airlines." + "\n" + "3: View the list of Flights." + "\n"
						+ "4: View list of airlines flying out of an airport (search by airport three letter code)"
						+ "\n" + "5: View list of flights between a departure and destination for a date");
				int input = sc.nextInt();
				if (input == 1) {
					System.out.println(service.findAllAirports());
				}
				if (input == 2) {
					System.out.println(service.findAirlines());
				}

				if (input == 3) {
					System.out.println(service.findFlights());
				}
				if (input == 4) {
					System.out.println("Please enter the airport code: ");
					Scanner codes = new Scanner(System.in);
					String code = codes.next();
					System.out.println(service.findAirlinesByAirportCode(code));
				}
				if (input == 5) {
					System.out.println("Please enter the departure code: ");
					Scanner departure = new Scanner(System.in);
					String departureloc = departure.next();
					System.out.println("Please enter the destination code: ");
					Scanner destination = new Scanner(System.in);
					String destinationloc = departure.next();

					System.out.println("Please enter the date in the following format (YYYY-MM-DD): ");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					Scanner date = new Scanner(System.in);
					String datevalue = date.next();
					LocalDate localDate = LocalDate.parse(datevalue, formatter);
					List<Flight> li = new ArrayList();
					service.findFlightsFromTo(departureloc, destinationloc, localDate);

				}
			}
		} else {
			while (true) {
				System.out.println("Please choose any operation from the list:" + "\n" + "1: View the list of Airports."
						+ "\n" + "2: View the list of Airlines." + "\n" + "3: View the list of Flights." + "\n"
						+ "4: Make Reservation." + "\n" + "5: Cancel Reservatin." + "\n" + "6: Confirm Reservatin."
						+ "\n"
						+ "7: View list of airlines flying out of an airport (search by airport three letter code)"
						+ "\n" + "8: View list of flights between a departure and destination for a date");
				;
				int input = sc.nextInt();
				if (input == 1) {
					System.out.println(service.findAllAirports());
				}
				if (input == 2) {
					System.out.println(service.findAirlines());
				}
				if (input == 3) {
					System.out.println(service.findFlights());
				}
				if (input == 4) {

					Passenger p1 = new Passenger("Tirth", "Joshi", LocalDate.parse("1995-02-01"),
							"joshimanish992@gmail.com", new Address());
					Passenger p2 = new Passenger("Pascal", "Joshi", LocalDate.parse("1995-03-01"), "pascal@gmail.com",
							new Address());
					passangers.add(p1);
					passangers.add(p2);

					List<Flight> flights = new ArrayList<>();
					flights = service.findFlights();

					for (Flight f : flights) {
						if (f.getDepartureAirport().getName().equals("Chicago O'Hare International Airport") && 
								f.getArrivalAirport().getName().equals("Eastern Iowa Airport")) {
							reservations.add(service.createReservation(passangers, f));
						}
						if (f.getArrivalAirport().getName().equals("Eastern Iowa Airport")) {
							reservations.add(service.createReservation(passangers, f));
						}
						
					}
					System.out.println("---------------------------");
					System.out.println("Reservation Code(s):");
					for (Reservation r : reservations) {
						System.out.println(r.getReservationCode());
					}
					System.out.println("---------------------------");
					System.out.println("Would you like to see the reservation? Yes/No");
					Scanner userin = new Scanner(System.in);
					String useryes = userin.next();
					if (useryes.equalsIgnoreCase("Yes")) {
						System.out.println(reservations);
					}
				}

				if (input == 5) {
					System.out.println("---------------------------");
					System.out.println("Enter Reservation Code to Cancel: ");
					sc.nextLine();
					String code = sc.nextLine();
					List<Reservation> toRemove = new ArrayList();
					// reservations.remove(code);
					for (Reservation r : reservations) {
						if (r.getReservationCode().equals(code)) {
							toRemove.add(r);
						}
					}
					reservations.removeAll(toRemove);
					boolean rem = reservations.removeAll(toRemove);
					if(rem) {
					System.out.println("Reservation has been Canceled : " + code);
					}
					System.out.println("---------------------------");
				}

				if (input == 6) {
					Map<Reservation, List<Ticket>> tickets = new HashMap<>();
					System.out.println("---------------------------");
					System.out.println("Enter Reservation Code to Confirm: ");
					sc.nextLine();
					String code = sc.nextLine();
					System.out.println("Confirmed Reservation and Ticket(s):");
					for (Reservation r : reservations) {
						if(r.getReservationCode().equals(code)) {
						tickets.put(r, service.confirmReservation(r));
						}
						}
					for (Reservation k : tickets.keySet()) {
						for (Ticket t : tickets.get(k)) {
						System.out.println("Reservation:" + k.getReservationCode() + ", Ticket: " + t.ticketNumber);
							}
						}
					
					System.out.println("---------------------------");
				}

				if (input == 7) {
					System.out.println("Please enter the airport code: ");
					Scanner codes = new Scanner(System.in);
					String code = codes.next();
					System.out.println(service.findAirlinesByAirportCode(code));
				}
				if (input == 8) {
					System.out.println("Please enter the departure code: ");
					Scanner departure = new Scanner(System.in);
					String departureloc = departure.next();
					System.out.println("Please enter the destination code: ");
					Scanner destination = new Scanner(System.in);
					String destinationloc = departure.next();

					System.out.println("Please enter the date in the following format (YYYY-MM-DD): ");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					Scanner date = new Scanner(System.in);
					String datevalue = date.next();
					LocalDate localDate = LocalDate.parse(datevalue, formatter);
					List<Flight> li = new ArrayList();
					service.findFlightsFromTo(departureloc, destinationloc, localDate);

				}
			}
		}
	}
}
