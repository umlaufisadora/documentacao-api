package br.com.ctw.documentacao_api.dto;

import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

/**
 * Requisição passada para o banco de dados com um corpo de Certificado
 * @param numeroEmissao Número de emissão único do certificado
 * @param orgaoEmissor Orgão emissor responsável pela emissão do certificado
 * @param dataEmissao Data de emissão do certificado
 * @param dataValidade Data de validade do certificado
 * @param produto_id Identificador único de Produto
 */

@Schema(description = "Requisição passada para o banco de dados com um corpo de Certificado")
public record CertificadoRequest(
        @Schema(
                description = "Número de emissão único do certificado",
                example = "1234",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "O número de emissão é obrigatório")
        @Size(max = 150, message = "O número de emissão não pode passar de 150 caracteres")
        String numeroEmissao,

        @Schema(
                description = "Orgão emissor responsável pela emissão do certificado",
                example = "Anatel"
        )
        @NotNull(message = "O órgão emissor é obrigatório")
        @Size(max = 150, message = "O valor de órgão emissor não pode passar de 150 caracteres")
        String orgaoEmissor,

        @Schema(
                description = "Data de emissão do certificado",
                example = "2026-12-30"
        )
        @NotNull(message = "A data de emissão é obrigatório")
        Date dataEmissao,

        @Schema(
                description = "Data de validade do certificado",
                example = "2027-12-30"
        )
        @NotNull(message = "A data de validade é obrigatório")
        Date dataValidade,

        @Schema(
                description = "Referência da entidade Produto, sendo juntada à tabela por seu ID",
                example = "1"
        )
        @NotNull(message = "O ID de produto é obrigatório")
        Long produto_id
) {
}
