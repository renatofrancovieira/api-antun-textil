package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.Estoque;
import br.com.antun.apiantuntextil.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estoque> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idEstoque}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Estoque findById(@PathVariable(value = "idEstoque") Long idEstoque) {
		return service.findById(idEstoque);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Estoque create(@RequestBody Estoque Estoque) {
		return service.create(Estoque);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Estoque update(@RequestBody Estoque Estoque) {
		return service.update(Estoque);
	}
	
	@RequestMapping(value = "/{idEstoque}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idEstoque") Long idEstoque) {
		service.delete(idEstoque);
	}
}