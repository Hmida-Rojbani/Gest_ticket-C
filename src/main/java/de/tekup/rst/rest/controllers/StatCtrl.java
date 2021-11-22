package de.tekup.rst.rest.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.services.StatService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StatCtrl {
	
	private StatService statService;
	
	@GetMapping("/api/stats/day/client/{id}")
	public String getDayofWeekForAClient(@PathVariable long id) {
		return statService.jourPlusReserveeParClient(id);
	}
	
	@GetMapping("/api/stats/revenue")
	public HashMap<String, Double> getRevenue() {
		return statService.revenueStat();
	}

}
