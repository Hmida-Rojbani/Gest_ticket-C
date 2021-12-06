package de.tekup.rst.vue.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String tableForm() {
		return "tables/add";
	}

	@PostMapping("/add")
	public TableRes addTable(@Valid @RequestBody TableReq tableReq) {
		return tableService.saveTableToDB(tableReq);
	}

}
