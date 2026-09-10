package br.com.ctw.documentacao_api.Mapper;

import br.com.ctw.documentacao_api.dto.CertificadoRequest;
import br.com.ctw.documentacao_api.dto.CertificadoResponse;
import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class CertificadoMapper
{
    /**
     * Transformar uma Request em uma Entidade Certificado
     * @param request entidade certificado a ser convertida
     * @param produto entidade produto buscada pela service para criar certificado
     * @return CertificadoEntity retornado a partir da conversão
     */
    public CertificadoEntity toEntity(CertificadoRequest request, ProdutoEntity produto)
    {
        return CertificadoEntity.builder()
                .numeroEmissao(request.numeroEmissao())
                .orgaoEmisssor(request.orgaoEmissor())
                .dataEmissao(request.dataEmissao())
                .dataValidade(request.dataValidade())
                .produto(produto)
                .build();
    }

    /**
     * Transformar uma Entidade Certificado em uma Response Certificado
     * @param certificado entidade certificado a ser convertida
     * @return CertificadoResponse retornado a partir da conversão
     */
    public CertificadoResponse toResponse(CertificadoEntity certificado)
    {
        return new CertificadoResponse(
                certificado.getId(),
                certificado.getNumeroEmissao(),
                certificado.getOrgaoEmisssor(),
                certificado.getDataEmissao(),
                certificado.getDataValidade(),
                certificado.getProduto()
        );
    }
}
