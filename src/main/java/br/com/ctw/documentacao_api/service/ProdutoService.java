package br.com.ctw.documentacao_api.service;


import br.com.ctw.documentacao_api.Mapper.ProdutoMapper;
import br.com.ctw.documentacao_api.Repository.CertificadoRepository;
import br.com.ctw.documentacao_api.Repository.DocumentoTecnicoRepository;
import br.com.ctw.documentacao_api.Repository.ProdutoRepository;
import br.com.ctw.documentacao_api.dto.CertificadoResponse;
import br.com.ctw.documentacao_api.dto.ProdutoRequest;
import br.com.ctw.documentacao_api.dto.ProdutoResponse;
import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import br.com.ctw.documentacao_api.entity.DocumentoTecnicoEntity;
import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import br.com.ctw.documentacao_api.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Service que centraliza as regras de negócios pertinentes ao gerenciamento da entidade Produto
 */

@Service
@AllArgsConstructor
public class ProdutoService
{
    private final CertificadoRepository certificadoRepository;
    private final DocumentoTecnicoRepository documentoTecnicoRepository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    /**
     * Função de listagem de todos os produtos
     * @param pageable parâmetro de filtragem de retorno
     * @return Página de DTO {@link ProdutoResponse} com a entidade Produto persistida
     */
    @Transactional(readOnly = true)
    public Page<ProdutoResponse> listarTudo(Pageable pageable)
    {
        return produtoRepository.findAll(pageable)
                .map(produtoMapper::toResponse);
    }

    /**
     * Função de buscar produto pelo ID informado
     * @param id parâmetro de busca
     * @return DTO {@link ProdutoResponse} com a entidade Produto persistida
     * @throws NotFoundException Se o produto não puder ser encontrado pelo ID
     */
    @Transactional(readOnly = true)
    public ProdutoResponse buscarPorId(Long id)
    {
        return produtoRepository.findById(id)
                .map(produtoMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar produto por ID: " + id));
    }

    /**
     * Função de cadastro de produtos a partir da requisição estabelecida
     * @param request Requisição contendo os dados necessários para criação de produto
     * @return DTO {@link ProdutoResponse} com a entidade Produto persistida
     */
    @Transactional
    public ProdutoResponse cadastrarProduto(ProdutoRequest request)
    {
        Set<CertificadoEntity> certificados = new HashSet<>();
        Set<DocumentoTecnicoEntity> documentosTecnico = new HashSet<>();

        ProdutoEntity produto = produtoMapper.toEntity(request, certificados, documentosTecnico);
        produtoRepository.save(produto);

        return produtoMapper.toResponse(produto);
    }

    /**
     * Função de atualização de produto a partir da requisição estabelecida buscado pelo ID
     * @param request Requisição contendo os dados necessários para atualização de produto
     * @return DTO {@link ProdutoResponse} com a entidade Produto persistida
     */
    @Transactional
    public ProdutoResponse atualizarProdutos(Long id, ProdutoRequest request)
    {
        Set<CertificadoEntity> certificados = certificadoRepository.findAllByProdutoId(id);
        Set<DocumentoTecnicoEntity> documentosTecnico = documentoTecnicoRepository.findAllByProdutoId(id);

        ProdutoEntity produto = produtoMapper.toEntity(request, certificados, documentosTecnico);
        produtoRepository.save(produto);

        return produtoMapper.toResponse(produto);
    }

    /**
     * Deleção de produtos a partir de ID
     * @param id parâmetro de busca
     */
    @Transactional
    public void deletarCertificado(Long id)
    {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar produto por ID: " +id));

        produtoRepository.delete(produto);
    }
}
