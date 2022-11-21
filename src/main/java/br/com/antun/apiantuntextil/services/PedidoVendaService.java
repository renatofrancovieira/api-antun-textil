package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.PedidoVenda;
import br.com.antun.apiantuntextil.repositories.PedidoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PedidoVendaService {

	private Logger logger = Logger.getLogger(PedidoVenda.class.getName());

	@Autowired
	PedidoVendaRepository repository;

	public List<PedidoVenda> findAll() {

		logger.info("Listando todos os pedidos de vendas.");

		return repository.findAll();
	}

	public PedidoVenda findById(Long id) {

		logger.info(String.format("Procurando pedido de venda com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum pedido de venda foi encontrado com ID [%s].", id)));
	}

	public PedidoVenda create(PedidoVenda pedidoVenda) {

		logger.info(String.format("Criando novo pedido de venda. [%s]", pedidoVenda.toString()));

		return repository.save(pedidoVenda);
	}

	public PedidoVenda update(PedidoVenda pedidoVenda) {

		logger.info(String.format("Atualizando pedido de venda com ID [%s].", pedidoVenda.getId()));

		var entity = repository.findById(pedidoVenda.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum pedido de venda foi encontrado com ID [%s].", pedidoVenda.getId())));

		entity.setData(pedidoVenda.getData());
		entity.setStatus(pedidoVenda.getStatus());

		return repository.save(pedidoVenda);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando pedido de venda com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum pedido de venda foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
