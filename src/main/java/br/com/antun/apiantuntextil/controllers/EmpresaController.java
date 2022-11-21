package br.com.antun.apiantuntextil.controllers;

import br.com.antun.apiantuntextil.models.Empresa;
import br.com.antun.apiantuntextil.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;

	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Empresa> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/{idEmpresa}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Empresa findById(@PathVariable(value = "idEmpresa") Long idEmpresa) {
		return service.findById(idEmpresa);
	}
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Empresa create(@RequestBody Empresa empresa) {
		return service.create(empresa);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Empresa update(@RequestBody Empresa empresa) {
		return service.update(empresa);
	}
	
	@RequestMapping(value = "/{idEmpresa}",
			method=RequestMethod.DELETE)
	public void delete(@PathVariable(value = "idEmpresa") Long idEmpresa) {
		service.delete(idEmpresa);
	}
}