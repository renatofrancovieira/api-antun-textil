package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> { }