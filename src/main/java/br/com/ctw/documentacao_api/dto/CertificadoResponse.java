package br.com.ctw.documentacao_api.dto;

import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

/**
 * Resposta dada pelo banco de dados ao pedir fazer uma requisição de Certificado
 * @param id Identificador único de Certificado
 * @param numeroEmissao Número de emissão único do certificado
 * @param orgaoEmissor Orgão emissor responsável pela emissão do certificado
 * @param dataEmissao Data de emissão do certificado
 * @param dataValidade Data de validade do certificado
 * @param produto Referência da entidade Produto, sendo retornado um json
 */

@Schema(description = "Resposta dada pelo banco de dados ao pedir fazer uma requisição de Certificado")
public record CertificadoResponse(
        @Schema(
                description = "Identificador único de Certificado",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long id,

       @Schema(
               description = "Número de emissão único do certificado",
               example = "1234",
               requiredMode = Schema.RequiredMode.REQUIRED
       )
       String numeroEmissao,

       @Schema(
               description = "Orgão emissor responsável pela emissão do certificado",
               example = "Anatel"
       )
       String orgaoEmissor,

        @Schema(
                description = "Data de emissão do certificado",
                example = "2026-12-30"
        )
        Date dataEmissao,

        @Schema(
                description = "Data de validade do certificado",
                example = "2027-12-30"
        )
        Date dataValidade,

        @Schema(
                description = "Referência da entidade Produto, sendo juntada à tabela por seu ID",
                example = "JSON de Produto"
        )
        ProdutoEntity produto
)
{

}
