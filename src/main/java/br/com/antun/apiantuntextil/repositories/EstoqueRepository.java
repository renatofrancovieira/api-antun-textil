package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> { }