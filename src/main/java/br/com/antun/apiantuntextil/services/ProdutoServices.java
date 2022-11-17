package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.Produto;
import br.com.antun.apiantuntextil.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProdutoServices {
	
	private Logger logger = Logger.getLogger(ProdutoServices.class.getName());
	
	@Autowired
	ProdutoRepository repository;

	public List<Produto> findAll() {

		logger.info("Procurando por todos os produtos.");

		return repository.findAll();
	}

	public Produto findById(Long id) {
		
		logger.info("Procurando por um produto.");
		
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID!"));
	}
	
	public Produto create(Produto produto) {

		logger.info("Criando um produto.");
		
		return repository.save(produto);
	}
	
	public Produto update(Produto produto) {
		
		logger.info("Atualizando um produto.");
		
		var entity = repository.findById(produto.getId())
			.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID!"));

		entity.setId(produto.getId());
		entity.setCodigoProduto(produto.getCodigoProduto());
		entity.setNomeProduto(produto.getNomeProduto());

		return repository.save(produto);
	}
	
	public void delete(Long id) {
		
		logger.info("Apagando um produto.");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID!"));
		repository.delete(entity);
	}
}
