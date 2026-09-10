package br.com.ctw.documentacao_api.dto;

import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import br.com.ctw.documentacao_api.entity.DocumentoTecnicoEntity;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.Set;

/**
 * Resposta dada pelo banco de dados ao pedir fazer uma requisição de Produtos
 * @param id Identificador único de Produto
 * @param numeroSerie Número de série único do produto
 * @param modelo Modelo do produto
 * @param linhaProducao Linha de produção que o produto foi feito
 * @param dataFabricacao Data de fabricação do produto
 * @param certificado Lista de Certificados referentes a produto
 * @param documentoTecnico Lista de Documentos Técnicos referentes a produto
 */

@Schema(description = "Resposta dada pelo banco de dados ao pedir fazer uma requisição de Produtos")
public record ProdutoResponse(
        @Schema(
                description = "Identificador único de Produto",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long id,

        @Schema(
                description = "Número de série único do produto",
                example = "123-Ae3",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String numeroSerie,

        @Schema(
                description = "Modelo do produto",
                example = "Ferramenta de ancoragem"
        )
        String modelo,

        @Schema(
                description = "Linha de produção que o produto foi feito",
                example = "123-Ae3-Ab4"
        )
        String linhaProducao,

        @Schema(
                description = "Data de fabricação do produto",
                example = "2026-12-23"
        )
        Date dataFabricacao,

        @Schema(
                description = "Lista de Certificados referentes a produto",
                example = "Lista em formato de JSON de certificados"
        )
        Set<CertificadoEntity> certificado,

        @Schema(
                description = "Lista de Documentos Técnicos referentes a produto",
                example = "Lista em formato JSON de documentos técnicos"
        )
        Set<DocumentoTecnicoEntity> documentoTecnico
) {
}
