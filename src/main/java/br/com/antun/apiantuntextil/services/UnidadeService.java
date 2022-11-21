package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.Unidade;
import br.com.antun.apiantuntextil.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UnidadeService {

	private Logger logger = Logger.getLogger(Unidade.class.getName());

	@Autowired
	UnidadeRepository repository;

	public List<Unidade> findAll() {

		logger.info("Listando todos os unidades.");

		return repository.findAll();
	}

	public Unidade findById(Long id) {

		logger.info(String.format("Procurando unidade com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum unidade foi encontrado com ID [%s].", id)));
	}

	public Unidade create(Unidade unidade) {

		logger.info(String.format("Criando novo unidade. [%s]", unidade.toString()));

		return repository.save(unidade);
	}

	public Unidade update(Unidade unidade) {

		logger.info(String.format("Atualizando unidade com ID [%s].", unidade.getId()));

		var entity = repository.findById(unidade.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum unidade foi encontrado com ID [%s].", unidade.getId())));

		entity.setCodigo(unidade.getCodigo());
		entity.setNome(unidade.getNome());

		return repository.save(unidade);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando unidade com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum unidade foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
