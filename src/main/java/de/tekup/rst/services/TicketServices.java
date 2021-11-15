package de.tekup.rst.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.dto.models.TicketCreation;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.entities.TicketEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TableRepository;
import de.tekup.rst.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketServices {
	
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private MetRepository metRepository;
	private TicketRepository ticketRepository;
	
	public double createTicket(TicketCreation creation) {
		TicketEntity ticketEntity = new TicketEntity();
		ClientEntity clientEntity = clientRepository.findById(creation.getClientId())
												.get();
		TableEntity tableEntity = tableRepository.findById(creation.getTableId())
													.get();
		List<MetEntity> mets= metRepository.findAllById(Arrays.asList(creation.getMetIds()));
		
		ticketEntity.setClient(clientEntity);
		ticketEntity.setTable(tableEntity);
		ticketEntity.setMets(mets);
		ticketEntity.setNbCouverts(creation.getNbCouverts());
		
		double addition= tableEntity.getSupplement();
		
		for (MetEntity met : mets) {
			addition += met.getPrix();
		}
		
		ticketEntity.setAddition(addition);
		ticketEntity.setDate(LocalDateTime.now());
		
		ticketRepository.save(ticketEntity);
		
		return addition;
		
	}

}
