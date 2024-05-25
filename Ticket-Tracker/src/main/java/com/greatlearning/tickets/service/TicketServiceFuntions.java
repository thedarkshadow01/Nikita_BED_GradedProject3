package com.greatlearning.tickets.service;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.greatlearning.tickets.model.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;

@Service
public class TicketServiceFuntions implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findById(int theId) {
		Optional<Ticket> result = ticketRepository.findById(theId);
		Ticket ticket = null;
		if (result.isPresent()) {
			ticket = result.get();
		} else {
			throw new RuntimeException("Ticket is not present with given Id : " + theId);
		}
		return ticket;
	}

	@Override
	public Ticket saveTicket(Ticket theTicket) {
		Ticket t2 = new Ticket();
		if(ticketRepository.existsById(t2.getId())) {
			throw new RuntimeException("Ticket already exists");
		}
		else {
			t2= ticketRepository.save(theTicket);
		}
		return t2;

	}

	@Override
	public Ticket deleteById(int theId) throws Exception {
		Ticket ticket = ticketRepository.findById(theId).orElseThrow(() -> new Exception("Ticket not found for id " + theId));
		ticketRepository.delete(ticket);
		return ticket;
	}

	public List<Ticket> findByKeyword(String keyword) {
		return ticketRepository.findByKeyword(keyword);
	}

	@Override
	public Ticket editById(Ticket ticket) {
		if(ticketRepository.existsById(ticket.getId())) {
			ticketRepository.save(ticket);
		}
		else {
			throw new RuntimeException("Ticket is not present with given Id : ");
		}
		return ticket;
	}

}
