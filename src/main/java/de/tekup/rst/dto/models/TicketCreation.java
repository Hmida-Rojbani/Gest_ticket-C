package de.tekup.rst.dto.models;

import lombok.Data;

@Data
public class TicketCreation {
	
	private long clientId;
	
	private long tableId;
	
	private Long[] metIds;
	
	private int nbCouverts;

}
