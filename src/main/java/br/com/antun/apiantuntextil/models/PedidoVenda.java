package br.com.antun.apiantuntextil.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "pedido_venda")
public class PedidoVenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "id_empresa", nullable = false)
    private Long idEmpresa;

    @Column(name = "status", nullable = false, length = 1)
    private String status;
}