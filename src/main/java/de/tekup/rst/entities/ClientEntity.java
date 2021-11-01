package de.tekup.rst.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private LocalDate dateDeNaissance;
	
	private String courrier;
	
	private String telephone;
	
	@OneToMany(mappedBy = "client")
	private List<TicketEntity> tickets = new ArrayList<>();

}
