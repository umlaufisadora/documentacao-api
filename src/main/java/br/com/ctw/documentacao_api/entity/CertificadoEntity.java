package br.com.ctw.documentacao_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.security.cert.CertPathBuilder;
import java.util.Date;

@Entity
@Table(name = "certificado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificadoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_emissao", nullable = false, unique = true, length = 150
    )
    private String numeroEmissao;

    @Column(name = "orgao_emissor", nullable = false, length = 150)
    private String orgaoEmisssor;

    @Column(name = "data_emissao", nullable = false)
    private Date dataEmissao;

    @Column(name = "data_validade", nullable = false)
    private Date dataValidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    @JsonBackReference
    private ProdutoEntity produto;


}
