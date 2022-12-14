package com.te.springparctise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.te.springparctise.bean.TicketReservation;
import com.te.springparctise.dao.TicketReservationDAO;
@Service
public class TicketReservationServiceImpl implements TicketReservationService{
	
	@Autowired
	private TicketReservationDAO dao;

	@Override
	public TicketReservation addPassenger(TicketReservation reservation) {
		
		return dao.save(reservation);
	}

	@Override
	//@Cacheable(cacheNames = "reservation", key = "#tid")
	public TicketReservation getPassenger(Integer tid) {
		
		return dao.findById(tid).get();
	}
	
	@Override
	//@CachePut(cacheNames = "reservation", key = "#reservation.tid" )
	public TicketReservation updatePassenger(TicketReservation reservation, Integer tid) {
		TicketReservation ticketReservation = dao.findById(reservation.getTid()).get();
		ticketReservation.setDateOfJourney(reservation.getDateOfJourney());
		return dao.save(ticketReservation);
	}

	@Override
	//@CacheEvict(cacheNames = "reservation", key = "#tid")
	public void deletePassenger(Integer tid) {
		dao.deleteById(tid);
	}


}
