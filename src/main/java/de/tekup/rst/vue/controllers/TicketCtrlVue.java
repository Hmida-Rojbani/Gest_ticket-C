package de.tekup.rst.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketCtrlVue {
	
	@GetMapping("/add")
	public String createTicket(Model model) {
		return "tickets/add";
	}

}
