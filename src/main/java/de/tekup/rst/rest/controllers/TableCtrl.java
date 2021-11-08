package de.tekup.rst.rest.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.dto.models.TableReq;
import de.tekup.rst.dto.models.TableRes;
import de.tekup.rst.services.TableService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tables")
@AllArgsConstructor
public class TableCtrl {
	
	private TableService tableService;

	@PostMapping()
	public TableRes addTable(@Valid @RequestBody TableReq tableReq) {
		return tableService.saveTableToDB(tableReq);
	}
}
