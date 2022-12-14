package com.te.springparctise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springparctise.bean.TicketReservation;
import com.te.springparctise.service.TicketReservationService;

@RestController
public class TicketReservationController {
	
	@Autowired
	private TicketReservationService service;
	
	@PostMapping(value = "/book")
	public ResponseEntity<?> booking(@RequestBody TicketReservation reservation){
		TicketReservation passenger = service.addPassenger(reservation);
		return new ResponseEntity<String>("data inserted", HttpStatus.OK);		
	}
	
	@GetMapping("/reservation/{tid}")
	public ResponseEntity<?> getpassenger(@PathVariable Integer tid){
		TicketReservation passenger = service.getPassenger(tid);
		return new ResponseEntity<TicketReservation>(passenger, HttpStatus.BAD_REQUEST);		
	}
	
	@PutMapping("/update/{tid}")
	public ResponseEntity<?> updatePassenger(@PathVariable Integer tid,@RequestBody TicketReservation reservation){
		TicketReservation updatePassenger = service.updatePassenger(reservation, tid);
		return new ResponseEntity<TicketReservation>(updatePassenger, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/reservation/{tid}")
	public ResponseEntity<?> deletedetail(@PathVariable Integer tid, TicketReservation reservation){
		//String deletePassenger = service.deletePassenger(tid);
		service.deletePassenger(tid);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.BAD_REQUEST);
		
	}

}
