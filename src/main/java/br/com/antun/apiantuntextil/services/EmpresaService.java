package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.Empresa;
import br.com.antun.apiantuntextil.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EmpresaService {

	private Logger logger = Logger.getLogger(Empresa.class.getName());

	@Autowired
	EmpresaRepository repository;

	public List<Empresa> findAll() {

		logger.info("Listando todas as empresas.");

		return repository.findAll();
	}

	public Empresa findById(Long id) {

		logger.info(String.format("Procurando empresa com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum empresa foi encontrada com ID [%s].", id)));
	}

	public Empresa create(Empresa empresa) {

		logger.info(String.format("Criando nova empresa. [%s]", empresa.toString()));

		return repository.save(empresa);
	}

	public Empresa update(Empresa empresa) {

		logger.info(String.format("Atualizando empresa com ID [%s].", empresa.getId()));

		var entity = repository.findById(empresa.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum empresa foi encontrada com ID [%s].", empresa.getId())));

		entity.setCodigo(empresa.getCodigo());
		entity.setNome(empresa.getNome());
		entity.setDocumento(empresa.getDocumento());
		entity.setTipoDocumento(empresa.getTipoDocumento());

		return repository.save(empresa);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando empresa com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum empresa foi encontrada com ID [%s].", id)));
		repository.delete(entity);
	}
}
