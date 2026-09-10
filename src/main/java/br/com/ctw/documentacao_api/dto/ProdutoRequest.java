package br.com.ctw.documentacao_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

/**
 * Requisição passada para o banco de dados com um corpo de Produto
 * @param numeroSerie Número de série único do produto
 * @param modelo Modelo do produto
 * @param linhaProducao Linha de produção que o produto foi feito
 * @param dataFabricacao Data de fabricação do produto
 */

@Schema(description = "Requisição passada para o banco de dados com um corpo de Produto")
public record ProdutoRequest(
        @Schema(
                description = "Número de série único do produto",
                example = "123-Ae3",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "O valor de número de série é obrigatório")
        @Size(max = 50, message = "Número de série não pode passar de 50 caracteres")
        String numeroSerie,

        @Schema(
                description = "Modelo do produto",
                example = "Ferramenta de ancoragem"
        )
        @NotNull(message = "O valor de modelo é obrigatório")
        @Size(max = 100, message = "O valor do modelo não pode passar de 100 caracteres")
        String modelo,

        @Schema(
                description = "Linha de produção que o produto foi feito",
                example = "123-Ae3-Ab4"
        )
        @NotNull(message = "O valor de linha de produção é obrigatório")
        @Size(max = 100, message = "O valor da linha de produção não pode passar de 100 caracteres")
        String linhaProducao,

        @Schema(
                description = "Data de fabricação do produto",
                example = "2026-12-23"
        )
        @NotNull(message = "O valor de data de fabricação é obrigatório")
        Date dataFabricacao
) {
}
