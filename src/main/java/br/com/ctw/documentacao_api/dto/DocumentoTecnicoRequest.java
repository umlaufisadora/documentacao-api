package br.com.ctw.documentacao_api.dto;

import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Requisição passada para o banco de dados com um corpo de DocumentoTecnico
 * @param tipo Tipo de documentação
 * @param titulo Título do documento técnico
 * @param urlArquivo URL de redirecionamento para o arquivo
 * @param versao Versão do arquivo do documento
 * @param produto_id Identificador único de DocumentoTecnico
 */

@Schema(description = "Requisição passada para o banco de dados com um corpo de DocumentoTecnico")
public record DocumentoTecnicoRequest(
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
                example = "1"
        )
        Long produto_id
)
{
}
