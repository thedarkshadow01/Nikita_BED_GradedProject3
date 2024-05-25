package com.greatlearning.tickets.controller;

import java.time.LocalDate; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.tickets.model.Ticket;
import com.greatlearning.tickets.repository.TicketRepository;
import com.greatlearning.tickets.service.TicketService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	TicketRepository ticketRepository;

	@GetMapping("/list")
	@Operation(summary = "To get the list of all the tickets")
	public ResponseEntity<?> findAll() {
		ResponseEntity<?> response= null;
		try {
			response= new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			response= new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping("/saveTicket")
	@Operation(summary= "To save tickets")
	public ResponseEntity<?> saveTicke(@RequestBody Ticket ticket) {
		ResponseEntity<?> response= null;
		try {
			response= new ResponseEntity<> (ticketService.saveTicket(ticket), HttpStatus.OK);
		}
		catch(Exception e) {
			response= new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping("/formForEdit/{id}")
	@Operation(summary = "to edit ticket by id")
	public ResponseEntity<?> formForEdit(@RequestBody Ticket ticket) {
		ResponseEntity<?> response= null;
		try {
			response= new ResponseEntity<> (ticketService.editById(ticket), HttpStatus.OK);
		}
		catch(Exception e) {
			response= new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@DeleteMapping("/deleteTicket/{id}")
	@Operation(summary= "to delete ticket by id")
	public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Integer id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<> (ticketService.deleteById(id), HttpStatus.OK);
		}
		catch(Exception e) {
			response= new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping("/viewTicket/{id}")
	@Operation(summary = "to view ticket by id")
	public ResponseEntity<?> getById(@PathVariable (value="id") int id){
		ResponseEntity<?> response= null;
		try {
		response= new ResponseEntity<>(ticketService.findById(id), HttpStatus.OK);
		}
		catch(Exception e) {
			response= new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	} 
	
	@GetMapping("/viewTicket/keyword")
	@Operation(summary= "to view ticket by keyword")
	public ResponseEntity<?> findByKeyword(String keyword) {
		ResponseEntity<?> response= null;
		try {
		response= new ResponseEntity<>(ticketService.findByKeyword(keyword), HttpStatus.OK);
		}
		catch(Exception e) {
			response= new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
