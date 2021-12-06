package de.tekup.rst.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import de.tekup.rst.dto.models.TicketCreation;
import de.tekup.rst.services.ClientService;
import de.tekup.rst.services.TableService;
import de.tekup.rst.services.TicketServices;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketCtrlVue {
	private TicketServices ticketServices;
	private ClientService clientService;
	private TableService tableService;
	
	@GetMapping("/add")
	public String createTicket(Model model) {
		// add creation of ticket
		model.addAttribute("ticket", new TicketCreation());
		model.addAttribute("clients", clientService.getClients());
		model.addAttribute("tables", tableService.getAllTables());
		return "tickets/add";
	}
	

	
	@PostMapping()
	public double createTicket(@ModelAttribute("ticket") TicketCreation creation) {
		return ticketServices.createTicket(creation);
	}

}
