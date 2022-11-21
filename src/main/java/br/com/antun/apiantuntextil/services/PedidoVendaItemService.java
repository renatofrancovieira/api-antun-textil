package br.com.antun.apiantuntextil.services;

import br.com.antun.apiantuntextil.exceptions.ResourceNotFoundException;
import br.com.antun.apiantuntextil.models.PedidoVendaItem;
import br.com.antun.apiantuntextil.repositories.PedidoVendaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PedidoVendaItemService {

	private Logger logger = Logger.getLogger(PedidoVendaItem.class.getName());

	@Autowired
	PedidoVendaItemRepository repository;

	public List<PedidoVendaItem> findAll() {

		logger.info("Listando todos os itens de pedidos de vendas.");

		return repository.findAll();
	}

	public PedidoVendaItem findById(Long id) {

		logger.info(String.format("Procurando item de pedido de venda com ID [%s].", id));

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum item de pedido de venda foi encontrado com ID [%s].", id)));
	}

	public PedidoVendaItem create(PedidoVendaItem pedidoVendaItem) {

		logger.info(String.format("Criando novo item de pedido de venda. [%s]", pedidoVendaItem.toString()));

		return repository.save(pedidoVendaItem);
	}

	public PedidoVendaItem update(PedidoVendaItem pedidoVendaItem) {

		logger.info(String.format("Atualizando item de pedido de venda com ID [%s].", pedidoVendaItem.getId()));

		var entity = repository.findById(pedidoVendaItem.getId())
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum item de pedido de venda foi encontrado com ID [%s].", pedidoVendaItem.getId())));

		entity.setQuantidade(pedidoVendaItem.getQuantidade());

		return repository.save(pedidoVendaItem);
	}

	public void delete(Long id) {

		logger.info(String.format("Apagando item de pedido de venda com ID [%s].", id));

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Nenhum item de pedido de venda foi encontrado com ID [%s].", id)));
		repository.delete(entity);
	}
}
