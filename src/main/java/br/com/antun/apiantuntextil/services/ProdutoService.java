package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.Produto;
import br.com.antun.apiantuntextil.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProdutoService {

	private Logger logger = Logger.getLogger(Produto.class.getName());

	@Autowired
	ProdutoRepository repository;

	public List<Produto> findAll() {

		logger.info("Listando todos os produtos.");

		return repository.findAll();
	}

	public Produto findById(Long id) {

		logger.info(String.format("Procurando produto com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum produto foi encontrado com ID [%s].", id)));
	}

	public Produto create(Produto produto) {

		logger.info(String.format("Criando novo produto. [%s]", produto.toString()));

		return repository.save(produto);
	}

	public Produto update(Produto produto) {

		logger.info(String.format("Atualizando produto com ID [%s].", produto.getId()));

		var entity = repository.findById(produto.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum produto foi encontrado com ID [%s].", produto.getId())));

		entity.setCodigo(produto.getCodigo());
		entity.setNome(produto.getNome());

		return repository.save(produto);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando produto com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum produto foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
