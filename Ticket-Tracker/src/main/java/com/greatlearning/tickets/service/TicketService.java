package com.greatlearning.tickets.service;

import java.util.List;

import com.greatlearning.tickets.model.Ticket;

public interface TicketService {
	public List<Ticket> findAll();

	public Ticket findById(int theId);

	public Ticket saveTicket(Ticket theTicket);

	public Ticket deleteById(int theId) throws Exception;

	public List<Ticket> findByKeyword(String keyword);
	
	public Ticket editById(Ticket ticket);

}
