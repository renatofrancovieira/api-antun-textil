package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.PedidoVendaItem;
import br.com.antun.apiantuntextil.services.PedidoVendaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoVendaItem")
public class PedidoVendaItemController {
	
	@Autowired
	private PedidoVendaItemService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoVendaItem> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idPedidoVendaItem}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVendaItem findById(@PathVariable(value = "idPedidoVendaItem") Long idPedidoVendaItem) {
		return service.findById(idPedidoVendaItem);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVendaItem create(@RequestBody PedidoVendaItem PedidoVendaItem) {
		return service.create(PedidoVendaItem);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVendaItem update(@RequestBody PedidoVendaItem PedidoVendaItem) {
		return service.update(PedidoVendaItem);
	}
	
	@RequestMapping(value = "/{idPedidoVendaItem}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idPedidoVendaItem") Long idPedidoVendaItem) {
		service.delete(idPedidoVendaItem);
	}
}