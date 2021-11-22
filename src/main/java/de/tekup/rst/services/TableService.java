package de.tekup.rst.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.TableReq;
import de.tekup.rst.dto.models.TableRes;
import de.tekup.rst.entities.TableEntity;
import de.tekup.rst.entities.TableType;
import de.tekup.rst.repositories.TableRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TableService {
	
	private TableRepository tableRepository;
	private ModelMapper mapper;

	public TableRes saveTableToDB(TableReq tableReq) {
		 	
//		TableEntity tableEntity = new TableEntity();
//		tableEntity.setNbCouverts(tableReq.getNbCouverts());
//		tableEntity.setType(tableReq.getType());
//		tableEntity.setSupplement(tableReq.getSupplement());
		TableEntity tableEntity = mapper.map(tableReq, TableEntity.class);
		tableRepository.save(tableEntity);
//		TableRes tableRes = new TableRes();
//		tableRes.setNumero(tableEntity.getNumero());
//		tableRes.setNbCouverts(tableEntity.getNbCouverts());
//		tableRes.setType(tableEntity.getType());
//		tableRes.setSupplement(tableEntity.getSupplement());
		return mapper.map(tableEntity, TableRes.class);
	}

}
