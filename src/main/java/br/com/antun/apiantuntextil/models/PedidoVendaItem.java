package br.com.antun.apiantuntextil.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_venda_item")
@Data
public class PedidoVendaItem {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_venda", nullable = false)
    private Long idPedidoVenda;

    @Column(name = "id_produto", nullable = false)
    private Long idProduto;
}