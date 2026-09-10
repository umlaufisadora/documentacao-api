package br.com.ctw.documentacao_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.security.cert.CertPathBuilder;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa um Produto persistido pela aplicação
 * <p>Esta entidade contém os dados internos utilizados para camada de persistência</p>
 */

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_serie", nullable = false, unique = true, length = 50)
    private String numeroSerie;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "linha_producao", nullable = false, length = 100)
    private String linhaProducao;

    @Column(name = "data_fabricacao", nullable = false)
    private Date dataFabricacao;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CertificadoEntity> certificado = new HashSet<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DocumentoTecnicoEntity> documentoTecnico = new HashSet<>();


}
