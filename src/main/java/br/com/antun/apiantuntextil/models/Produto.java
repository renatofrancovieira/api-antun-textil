package br.com.antun.apiantuntextil.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto", nullable = false, length = 255)
    private String codigoProduto;

    @Column(name = "nome_produto", nullable = false, length = 255)
    private String nomeProduto;
}