package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { }