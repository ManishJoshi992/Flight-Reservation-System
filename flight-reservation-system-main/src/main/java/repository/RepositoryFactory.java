package repository;

public class RepositoryFactory {
	
	private static ReservationSystemRepository reservationSystemRepository = new ReservationSystemRepositoryImpl();
	
	public static ReservationSystemRepository getReservationSystemRepository() {
		return reservationSystemRepository;
	}
	

}
