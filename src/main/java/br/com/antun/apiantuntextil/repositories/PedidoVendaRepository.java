package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.PedidoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> { }