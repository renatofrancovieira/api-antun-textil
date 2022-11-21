package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.Unidade;
import br.com.antun.apiantuntextil.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {
	
	@Autowired
	private UnidadeService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Unidade> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idUnidade}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Unidade findById(@PathVariable(value = "idUnidade") Long idUnidade) {
		return service.findById(idUnidade);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Unidade create(@RequestBody Unidade Unidade) {
		return service.create(Unidade);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Unidade update(@RequestBody Unidade Unidade) {
		return service.update(Unidade);
	}
	
	@RequestMapping(value = "/{idUnidade}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idUnidade") Long idUnidade) {
		service.delete(idUnidade);
	}
}