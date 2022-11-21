package br.com.antun.apiantuntextil.repositories;

import br.com.antun.apiantuntextil.models.PedidoVendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoVendaItemRepository extends JpaRepository<PedidoVendaItem, Long> { }