package br.com.ctw.documentacao_api.dto;

import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Resposta dada pelo banco de dados ao pedir fazer uma requisição de DocumentoTecnico
 * @param id Identificador único de Documentação Técnica
 * @param tipo Tipo de documentação
 * @param titulo Título do documento técnico
 * @param urlArquivo URL de redirecionamento para o arquivo
 * @param versao Versão do arquivo do documento
 * @param produto Referência da entidade Produto, sendo retornado um json
 */

@Schema(description = "Resposta dada pelo banco de dados ao pedir fazer uma requisição de DocumentoTecnico")
public record DocumentoTecnicoResponse(
        @Schema(
                description = "Identificador único de Documentação Técnica",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long id,

        @Schema(
                description = "Tipo de documentação",
                example = "MANUAL, DATASHEET, DIAGRAMA_ELETRICO"
        )
        String tipo,

        @Schema(
                description = "Título do documento técnico",
                example = "Manual Montagem de Motores WEG"
        )
        String titulo,

        @Schema(
                description = "URL de redirecionamento para o arquivo",
                example = "https://montagem.weg.com.br"
        )
        String urlArquivo,

        @Schema(
                description = "Versão do arquivo do documento",
                example = "v1.0"
        )
        String versao,

        @Schema(
                description = "Referência da entidade Produto, sendo juntada à tabela por seu ID",
                example = "JSON de Produto"
        )
        ProdutoEntity produto
)
{
}
