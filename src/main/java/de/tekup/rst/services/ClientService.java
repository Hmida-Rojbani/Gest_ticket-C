package de.tekup.rst.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.ClientDTO;
import de.tekup.rst.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	private ClientRepository clientRepository;
	private ModelMapper mapper;
	
	public List<ClientDTO> getClients() {
		return clientRepository.findAll().stream()
					.map(cl-> mapper.map(cl, ClientDTO.class))
					.collect(Collectors.toList());
	}

}
