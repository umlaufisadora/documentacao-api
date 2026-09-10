package br.com.ctw.documentacao_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Resposta retornada pela aplicação após gerar um erro
 * @param timestamp Data e hora em que o erro aconteceu
 * @param status HTTP Status dado pelo erro
 * @param erro Mensagem de erro simples
 * @param mensagem Mensagem de erro detalhada
 * @param caminho Caminho que gerou o erro
 */

@Schema(description = "Resposta retornada pela aplicação após gerar um erro")
public record ErroResponse(

        @Schema(
                description = "Data e hora em que o erro aconteceu",
                example = "2026-09-09 18:35"
        )
        LocalDateTime timestamp,

        @Schema(
                description = "HTTP Status dado pelo erro",
                example = "404"
        )
        Integer status,

        @Schema(
                description = "Mensagem de erro simples",
                example = "Não foi possível encontrar o recurso"
        )
        String erro,

        @Schema(
                description = "Mensagem de erro detalhada",
                example = "Não foi possível encontrar o recurso pelo ID passsado"
        )
        String mensagem,

        @Schema(
                description = "Caminho que gerou o erro",
                example = "/api/v1/certificados"
        )
        String caminho
) {

    public ErroResponse(@Schema(
            description = "HTTP Status dado pelo erro",
            example = "404"
    )
                        Integer status, @Schema(
            description = "Mensagem de erro simples",
            example = "Não foi possível encontrar o recurso"
    )
                        String erro, @Schema(
            description = "Mensagem de erro detalhada",
            example = "Não foi possível encontrar o recurso pelo ID passsado"
    )
                        String mensagem, @Schema(
            description = "Caminho que gerou o erro",
            example = "/api/v1/certificados"
    )
                        String caminho) {
        LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.caminho = caminho;
    }
}
