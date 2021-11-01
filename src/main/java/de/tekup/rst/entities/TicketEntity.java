package de.tekup.rst.entities;

import java.time.LocalDateTime;
import java.util.List;

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
	
	@ManyToOne
	private TableEntity table;
	
	@ManyToMany
	@JoinTable(name = "compose",
	joinColumns = @JoinColumn(name="ticket_number"),
	inverseJoinColumns = @JoinColumn(name="met_id"))
	private List<MetEntity> mets;
}
