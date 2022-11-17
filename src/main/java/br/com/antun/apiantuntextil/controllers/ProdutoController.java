package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.Produto;
import br.com.antun.apiantuntextil.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoServices service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Produto> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idProduto}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto findById(@PathVariable(value = "idProduto") Long idProduto) {
		return service.findById(idProduto);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto create(@RequestBody Produto Produto) {
		return service.create(Produto);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Produto update(@RequestBody Produto Produto) {
		return service.update(Produto);
	}
	
	@RequestMapping(value = "/{idProduto}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idProduto") Long idProduto) {
		service.delete(idProduto);
	}
}