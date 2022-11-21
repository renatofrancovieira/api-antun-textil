package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.PedidoVenda;
import br.com.antun.apiantuntextil.services.PedidoVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoVenda")
public class PedidoVendaController {
	
	@Autowired
	private PedidoVendaService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoVenda> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idPedidoVenda}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVenda findById(@PathVariable(value = "idPedidoVenda") Long idPedidoVenda) {
		return service.findById(idPedidoVenda);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVenda create(@RequestBody PedidoVenda PedidoVenda) {
		return service.create(PedidoVenda);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PedidoVenda update(@RequestBody PedidoVenda PedidoVenda) {
		return service.update(PedidoVenda);
	}
	
	@RequestMapping(value = "/{idPedidoVenda}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idPedidoVenda") Long idPedidoVenda) {
		service.delete(idPedidoVenda);
	}
}