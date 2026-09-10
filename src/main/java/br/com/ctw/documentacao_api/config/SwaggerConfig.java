package br.com.ctw.documentacao_api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Configuration;

/**
 * Configurações Globais de Swagger/OpenApi para documentação da API
 */

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Gestão de Documentação Técnica e Certificados",
                version = "1.0",
                description = "Serviço centralizado para consulta de manuais e certificados por número de série."
        )
        )
public class SwaggerConfig { }
