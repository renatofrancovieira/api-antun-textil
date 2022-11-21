package br.com.antun.apiantuntextil.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "movimento_estoque")
public class MovimentoEstoque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_estoque", nullable = false)
    private Long idEstoque;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "entrada", nullable = false)
    private BigDecimal entrada;

    @Column(name = "saida", nullable = false)
    private BigDecimal saida;
}