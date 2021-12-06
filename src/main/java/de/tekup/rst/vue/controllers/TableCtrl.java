package de.tekup.rst.vue.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import de.tekup.rst.dto.models.TableReq;
import de.tekup.rst.dto.models.TableRes;
import de.tekup.rst.services.TableService;
import lombok.AllArgsConstructor;

@Controller(value = "TableCtrlVue")
@RequestMapping("/tables")
@AllArgsConstructor
public class TableCtrl {
	
	private TableService tableService;
	
	@GetMapping("/add")
	public String tableForm(Model model) {
		model.addAttribute("table", new TableReq());
		return "tables/add";
	}

	@PostMapping("/add")
	public String addTable(@ModelAttribute("table") TableReq tableReq) {
		tableService.saveTableToDB(tableReq);
		return "redirect:/tables/display";
	}
	
	@GetMapping("/display")
	public String tableDispaly(Model model) {
		model.addAttribute("listTable", tableService.getAllTables());
		return "tables/display";
	}

}
