package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.MovimentoEstoque;
import br.com.antun.apiantuntextil.repositories.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MovimentoEstoqueService {

	private Logger logger = Logger.getLogger(MovimentoEstoque.class.getName());

	@Autowired
	MovimentoEstoqueRepository repository;

	public List<MovimentoEstoque> findAll() {

		logger.info("Listando todos os movimentoEstoques.");

		return repository.findAll();
	}

	public MovimentoEstoque findById(Long id) {

		logger.info(String.format("Procurando movimentoEstoque com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum movimentoEstoque foi encontrado com ID [%s].", id)));
	}

	public MovimentoEstoque create(MovimentoEstoque movimentoEstoque) {

		logger.info(String.format("Criando novo movimentoEstoque. [%s]", movimentoEstoque.toString()));

		return repository.save(movimentoEstoque);
	}

	public MovimentoEstoque update(MovimentoEstoque movimentoEstoque) {

		logger.info(String.format("Atualizando movimentoEstoque com ID [%s].", movimentoEstoque.getId()));

		var entity = repository.findById(movimentoEstoque.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum movimentoEstoque foi encontrado com ID [%s].", movimentoEstoque.getId())));

		entity.setData(movimentoEstoque.getData());
		entity.setEntrada(movimentoEstoque.getEntrada());
		entity.setSaida(movimentoEstoque.getSaida());

		return repository.save(movimentoEstoque);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando movimentoEstoque com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum movimentoEstoque foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
