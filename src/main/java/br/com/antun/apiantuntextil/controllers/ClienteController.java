package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.Cliente;
import br.com.antun.apiantuntextil.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idCliente}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente findById(@PathVariable(value = "idCliente") Long idCliente) {
		return service.findById(idCliente);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente create(@RequestBody Cliente cliente) {
		return service.create(cliente);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente update(@RequestBody Cliente cliente) {
		return service.update(cliente);
	}
	
	@RequestMapping(value = "/{idCliente}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idCliente") Long idCliente) {
		service.delete(idCliente);
	}
}