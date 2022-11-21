package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> { }