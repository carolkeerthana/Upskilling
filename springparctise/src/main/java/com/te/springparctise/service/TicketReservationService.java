package com.te.springparctise.service;

import com.te.springparctise.bean.TicketReservation;

public interface TicketReservationService {
	
	public TicketReservation addPassenger(TicketReservation reservation);
	
	public TicketReservation getPassenger(Integer tid);
	
	public TicketReservation updatePassenger(TicketReservation reservation, Integer tid);
	
	public void deletePassenger(Integer tid);

}
