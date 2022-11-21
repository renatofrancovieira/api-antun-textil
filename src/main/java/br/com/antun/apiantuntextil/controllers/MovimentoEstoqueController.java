package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.MovimentoEstoque;
import br.com.antun.apiantuntextil.services.MovimentoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentoMovimentoEstoque")
public class MovimentoEstoqueController {
	
	@Autowired
	private MovimentoEstoqueService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovimentoEstoque> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idMovimentoEstoque}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MovimentoEstoque findById(@PathVariable(value = "idMovimentoEstoque") Long idMovimentoEstoque) {
		return service.findById(idMovimentoEstoque);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MovimentoEstoque create(@RequestBody MovimentoEstoque MovimentoEstoque) {
		return service.create(MovimentoEstoque);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MovimentoEstoque update(@RequestBody MovimentoEstoque MovimentoEstoque) {
		return service.update(MovimentoEstoque);
	}
	
	@RequestMapping(value = "/{idMovimentoEstoque}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idMovimentoEstoque") Long idMovimentoEstoque) {
		service.delete(idMovimentoEstoque);
	}
}