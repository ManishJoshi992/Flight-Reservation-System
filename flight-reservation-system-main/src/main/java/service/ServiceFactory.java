package service;

import repository.RepositoryFactory;

public class ServiceFactory {
	
	private static ReservationSystemService reservationSystemService = 
			new ReservationSystemServiceImpl(RepositoryFactory.getReservationSystemRepository());
	
	public static ReservationSystemService getReservationSystemService() {
		return reservationSystemService;		
	}
}
