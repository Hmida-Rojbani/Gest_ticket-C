package de.tekup.rst.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import de.tekup.rst.dto.models.*;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.repositories.MetRepository;
import lombok.AllArgsConstructor;

import java.time.*;
import java.util.*;

@Service
@AllArgsConstructor
public class StatService {
	
	private MetRepository metRepository;
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

}
