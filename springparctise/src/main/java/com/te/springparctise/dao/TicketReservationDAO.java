package com.te.springparctise.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springparctise.bean.TicketReservation;
@Repository
public interface TicketReservationDAO extends JpaRepository<TicketReservation, Integer>{

	//public 
}
