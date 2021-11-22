package de.tekup.rst.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import de.tekup.rst.dto.models.*;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.entities.TicketEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import de.tekup.rst.repositories.TableRepository;
import lombok.AllArgsConstructor;

import java.time.*;
import java.time.format.TextStyle;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatService {
	
	private MetRepository metRepository;
	private ClientRepository clientRepository;
	private TableRepository tableRepository;
	private ModelMapper mapper;
	
	public MetDTO platPlusAchete(LocalDate debut, LocalDate fin) {
		List<MetEntity> metEntities =  metRepository.findAll();
		// remove all different the Plat
		metEntities.removeIf(met -> !(met instanceof Plat));
		// remove all ticket out of the given period for each plat
		for (MetEntity metEntity : metEntities) {
			metEntity.getTickets()
			.removeIf(tic -> tic.getDate().toLocalDate().isBefore(debut) 
					|| tic.getDate().toLocalDate().isAfter(fin));
		}
		// find the plat with max number of tickets
		int max = -1;
		MetEntity entity = null;
		
		for (MetEntity metEntity : metEntities) {
			if(metEntity.getTickets().size()>max) {
				max = metEntity.getTickets().size();
				entity = metEntity;
			}
		}
		MetDTO dto = mapper.map(entity, MetDTO.class);
		dto.setType(entity.getClass().getSimpleName());
		return dto;
	}
	
	public ClientDTO clientPlusFidele() {
		List<ClientEntity> clientEntities = clientRepository.findAll();
		int max = -1;
		ClientEntity entity = null;
		
		for (ClientEntity clientEntity : clientEntities) {
			if(clientEntity.getTickets().size()> max) {
				max = clientEntity.getTickets().size();
				entity = clientEntity;
			}
		}
		
		return mapper.map(entity, ClientDTO.class);
	}
	
	public TableRes tablePlusReservee() {
		
		TableEntity tableEntity = tableRepository.findAll()
								.stream()
								.max(Comparator.comparing(tab->tab.getTickets().size()))
								.orElse(null);
		return mapper.map(tableEntity, TableRes.class);
	}
	
	public String jourPlusReserveeParClient(long id) {
		ClientEntity clientEntity = clientRepository.findById(id).get();
	
		List<TicketEntity> ticketEntities = clientEntity.getTickets();
		List<DayOfWeek> days = ticketEntities.stream()
										.map(t -> t.getDate().getDayOfWeek())
										.collect(Collectors.toList());
		
		System.out.println(days);
		Map<DayOfWeek,Long> map =  days.stream()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		DayOfWeek day = map.entrySet().stream()
									.max(Map.Entry.comparingByValue())
									.get().getKey();
		System.out.println(day);
		
		return day.getDisplayName(TextStyle.FULL, new Locale("fr"));
	}

}
