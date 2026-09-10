package br.com.ctw.documentacao_api.Mapper;

import br.com.ctw.documentacao_api.dto.DocumentoTecnicoRequest;
import br.com.ctw.documentacao_api.dto.DocumentoTecnicoResponse;
import br.com.ctw.documentacao_api.entity.DocumentoTecnicoEntity;
import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class DocumentoTecnicoMapper
{
    /**
     * Transformar uma Request em uma Entidade DocumentoTecnico
     * @param request entidade documento tecnico a ser convertida
     * @param produto entidade produto buscada pela service para criar documentoTecnico
     * @return DocumentoTecnicoEntity retornado a partir da conversão
     */
    public DocumentoTecnicoEntity toEntity(DocumentoTecnicoRequest request, ProdutoEntity produto)
    {
        return DocumentoTecnicoEntity.builder()
                .tipo(request.tipo())
                .titulo(request.titulo())
                .urlArquivo(request.urlArquivo())
                .versao(request.versao())
                .produto(produto)
                .build();
    }

    /**
     * Transformar uma Entidade DocumentoTecnico em uma Response DocumentoTecnico
     * @param documentoTecnico entidade documento tecnico a ser convertida
     * @return DocumentoTecnicoResponse retornado a partir da conversão
     */
    public DocumentoTecnicoResponse toResponse(DocumentoTecnicoEntity documentoTecnico)
    {
        return new DocumentoTecnicoResponse(
                documentoTecnico.getId(),
                documentoTecnico.getTipo(),
                documentoTecnico.getTitulo(),
                documentoTecnico.getUrlArquivo(),
                documentoTecnico.getVersao(),
                documentoTecnico.getProduto()
        );
    }
}
