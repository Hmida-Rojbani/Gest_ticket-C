package de.tekup.rst.rest.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.dto.models.TicketCreation;
import de.tekup.rst.services.TicketServices;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tickets")
public class TicketCtrl {
	
	private TicketServices ticketServices;
	
	@PostMapping()
	public double createTicket(@RequestBody TicketCreation creation) {
		return ticketServices.createTicket(creation);
	}
	

}
