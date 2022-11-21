package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.Estoque;
import br.com.antun.apiantuntextil.repositories.EstoqueRepository;
import br.com.antun.apiantuntextil.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EstoqueService {

	private Logger logger = Logger.getLogger(Estoque.class.getName());

	@Autowired
	EstoqueRepository repository;

	public List<Estoque> findAll() {

		logger.info("Listando todos os estoques.");

		return repository.findAll();
	}

	public Estoque findById(Long id) {

		logger.info(String.format("Procurando estoque com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum estoque foi encontrado com ID [%s].", id)));
	}

	public Estoque create(Estoque estoque) {

		logger.info(String.format("Criando novo estoque. [%s]", estoque.toString()));

		return repository.save(estoque);
	}

	public Estoque update(Estoque estoque) {

		logger.info(String.format("Atualizando estoque com ID [%s].", estoque.getId()));

		var entity = repository.findById(estoque.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum estoque foi encontrado com ID [%s].", estoque.getId())));

		entity.setQuantidade(estoque.getQuantidade());

		return repository.save(estoque);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando estoque com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum estoque foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
