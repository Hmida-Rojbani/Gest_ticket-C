package de.tekup.rst.dto.models;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ClientDTO {
	
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private LocalDate dateDeNaissance;
	
	private String courrier;
	
	private String telephone;

}
