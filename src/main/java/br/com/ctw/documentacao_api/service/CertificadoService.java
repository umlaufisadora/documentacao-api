package br.com.ctw.documentacao_api.service;

import br.com.ctw.documentacao_api.Mapper.CertificadoMapper;
import br.com.ctw.documentacao_api.Repository.CertificadoRepository;
import br.com.ctw.documentacao_api.Repository.ProdutoRepository;
import br.com.ctw.documentacao_api.dto.CertificadoRequest;
import br.com.ctw.documentacao_api.dto.CertificadoResponse;
import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import br.com.ctw.documentacao_api.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service que centraliza as regras de negócios pertinentes ao gerenciamento da entidade Certificado
 */

@Service
@AllArgsConstructor
public class CertificadoService
{
    private final CertificadoRepository certificadoRepository;
    private final ProdutoRepository produtoRepository;
    private final CertificadoMapper certificadoMapper;

    /**
     * Função de listagem de todos os certificados
     * @param pageable parâmetro de filtragem de retorno
     * @return Página de DTO {@link CertificadoResponse} com a entidade Certificado persistida
     */
    @Transactional(readOnly = true)
    public Page<CertificadoResponse> listarTudo(Pageable pageable)
    {
        return certificadoRepository.findAll(pageable)
                .map(certificadoMapper::toResponse);
    }

    /**
     * Função de buscar certificado pelo ID informado
     * @param id parâmetro de busca
     * @return DTO {@link CertificadoResponse} com a entidade Certificado persistida
     * @throws NotFoundException Se o certificado não puder ser encontrado pelo ID
     */
    @Transactional(readOnly = true)
    public CertificadoResponse buscarPorId(Long id)
    {
        return certificadoRepository.findById(id)
                .map(certificadoMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar certificado por ID: " + id));
    }

    /**
     * Função de cadastro de certificados a partir da requisição estabelecida
     * @param request Requisição contendo os dados necessários para criação de certificado
     * @return DTO {@link CertificadoResponse} com a entidade Certificado persistida
     * @throws NotFoundException Se o produto não puder ser encontrado pelo ID
     */
    @Transactional
    public CertificadoResponse cadastrarCertificado(CertificadoRequest request)
    {
        ProdutoEntity produto = produtoRepository.findById(request.produto_id())
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar produto pelo ID: " + request.produto_id()));

        CertificadoEntity certificado = certificadoMapper.toEntity(request, produto);
        certificadoRepository.save(certificado);

        return certificadoMapper.toResponse(certificado);
    }

    /**
     * Função de atualização de certificados a partir da requisição estabelecida buscado pelo ID
     * @param request Requisição contendo os dados necessários para atualização de certificado
     * @return DTO {@link CertificadoResponse} com a entidade Certificado persistida
     * @throws NotFoundException Se o certificado ou produto não puder ser encontrado pelo ID
     */
    @Transactional
    public CertificadoResponse atualizarCertificado(Long id, CertificadoRequest request)
    {
        certificadoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar certificado por ID:" + id));

        ProdutoEntity produto = produtoRepository.findById(request.produto_id())
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar produto pelo ID: " + request.produto_id()));

        CertificadoEntity certificado = certificadoMapper.toEntity(request, produto);
        certificadoRepository.save(certificado);

        return certificadoMapper.toResponse(certificado);
    }

    /**
     * Deleção de certificados a partir de ID
     * @param id parâmetro de busca
     */
    @Transactional
    public void deletarCertificado(Long id)
    {
        CertificadoEntity certificado = certificadoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar certificado por ID:" + id));

        certificadoRepository.delete(certificado);
    }
}
