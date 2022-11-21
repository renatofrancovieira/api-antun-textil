package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.Cliente;
import br.com.antun.apiantuntextil.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClienteService {

	private Logger logger = Logger.getLogger(Cliente.class.getName());

	@Autowired
	ClienteRepository repository;

	public List<Cliente> findAll() {

		logger.info("Listando todos os clientes.");

		return repository.findAll();
	}

	public Cliente findById(Long id) {

		logger.info(String.format("Procurando cliente com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum cliente foi encontrado com ID [%s].", id)));
	}

	public Cliente create(Cliente cliente) {

		logger.info(String.format("Criando novo cliente. [%s]", cliente.toString()));

		return repository.save(cliente);
	}

	public Cliente update(Cliente cliente) {

		logger.info(String.format("Atualizando cliente com ID [%s].", cliente.getId()));

		var entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum cliente foi encontrado com ID [%s].", cliente.getId())));

		entity.setCodigo(cliente.getCodigo());
		entity.setNome(cliente.getNome());
		entity.setDocumento(cliente.getDocumento());
		entity.setTipoDocumento(cliente.getTipoDocumento());

		return repository.save(cliente);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando cliente com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum cliente foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
