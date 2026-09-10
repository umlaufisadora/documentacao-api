package br.com.ctw.documentacao_api.mapper;

import br.com.ctw.documentacao_api.dto.ProdutoRequest;
import br.com.ctw.documentacao_api.dto.ProdutoResponse;
import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import br.com.ctw.documentacao_api.entity.DocumentoTecnicoEntity;
import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProdutoMapper
{
    /**
     * Transformar uma Request em uma Entidade Produto
     * @param request entidade produto a ser convertida
     * @return ProdutoEntity retornado a partir da conversão
     */
    public ProdutoEntity toEntity(ProdutoRequest request, Set<CertificadoEntity> certificado, Set<DocumentoTecnicoEntity> documentoTecnico)
    {
         return ProdutoEntity.builder()
                 .numeroSerie(request.numeroSerie())
                 .modelo(request.modelo())
                 .linhaProducao(request.linhaProducao())
                 .dataFabricacao(request.dataFabricacao())
                 .certificado(certificado)
                 .documentoTecnico(documentoTecnico)
                 .build();
    }

    /**
     * Transformar uma Entidade Produto em uma Response Produto
     * @param produto entidade produto a ser convertida
     * @return ProdutoResponse retornado a partir da conversão
     */
    public ProdutoResponse toResponse(ProdutoEntity produto)
    {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNumeroSerie(),
                produto.getModelo(),
                produto.getLinhaProducao(),
                produto.getDataFabricacao(),
                produto.getCertificado(),
                produto.getDocumentoTecnico()
        );
    }
}
