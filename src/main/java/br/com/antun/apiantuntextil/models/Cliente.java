package br.com.antun.apiantuntextil.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false, length = 255)
    private String codigo;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "documento", nullable = false, length = 255)
    private String documento;

    @Column(name = "tipo_documento", nullable = false, length = 1)
    private String tipoDocumento;
}