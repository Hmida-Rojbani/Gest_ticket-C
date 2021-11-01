package de.tekup.rst.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class TableEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;
	
	private int nbCouverts;
	private double supplement;
	@Enumerated(EnumType.STRING)
	private TableType type;
	
	@OneToMany(mappedBy = "table")
	private List<TicketEntity> tickets = new ArrayList<>();
	

}
