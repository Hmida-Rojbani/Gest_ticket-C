package de.tekup.rst.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class TicketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private LocalDateTime date;
	
	private int nbCouverts;
	
	private double addition;
	
	@ManyToOne
	private ClientEntity client;
	
}
