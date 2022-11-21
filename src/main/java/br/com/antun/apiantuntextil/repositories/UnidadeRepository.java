package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> { }