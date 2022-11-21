package br.com.antun.apiantuntextil.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pedido_venda_item")
public class PedidoVendaItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pedido_venda", nullable = false)
    private Long idPedidoVenda;

    @Column(name = "id_produto", nullable = false)
    private Long idProduto;

    @Column(name = "quantidade", nullable = false)
    private BigDecimal quantidade;
}