package br.com.ctw.documentacao_api.service;

import br.com.ctw.documentacao_api.mapper.DocumentoTecnicoMapper;
import br.com.ctw.documentacao_api.repository.DocumentoTecnicoRepository;
import br.com.ctw.documentacao_api.repository.ProdutoRepository;
import br.com.ctw.documentacao_api.dto.DocumentoTecnicoRequest;
import br.com.ctw.documentacao_api.dto.DocumentoTecnicoResponse;
import br.com.ctw.documentacao_api.entity.DocumentoTecnicoEntity;
import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import br.com.ctw.documentacao_api.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service que centraliza as regras de negócios pertinentes ao gerenciamento da entidade DocumentoTecnico
 */

@Service
@AllArgsConstructor
public class DocumentoTecnicoService
{
    private final DocumentoTecnicoRepository documentoTecnicoRepository;
    private final ProdutoRepository produtoRepository;
    private final DocumentoTecnicoMapper documentoTecnicoMapper;

    /**
     * Função de listagem de todos os documentos técnicos
     * @param pageable parâmetro de filtragem de retorno
     * @return Página de DTO {@link DocumentoTecnicoResponse} com a entidade DocumentoTecnico persistida
     */
    @Transactional(readOnly = true)
    public Page<DocumentoTecnicoResponse> listarTudo(Pageable pageable)
    {
        return documentoTecnicoRepository.findAll(pageable)
                .map(documentoTecnicoMapper::toResponse);
    }

    /**
     * Função de buscar documento técnico pelo ID informado
     * @param id parâmetro de busca
     * @return DTO {@link DocumentoTecnicoResponse} com a entidade DocumentoTecnico persistida
     * @throws NotFoundException Se o documento técnico não puder ser encontrado pelo ID
     */
    @Transactional(readOnly = true)
    public DocumentoTecnicoResponse buscarPorId(Long id)
    {
        return documentoTecnicoRepository.findById(id)
                .map(documentoTecnicoMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o documento técnico por ID: " + id));
    }

    /**
     * Função de cadastro de documentos a partir da requisição estabelecida
     * @param request Requisição contendo os dados necessários para criação de documentoTecnico
     * @return DTO {@link DocumentoTecnicoResponse} com a entidade DocumentoTecnico persistida
     * @throws NotFoundException Se o produto não puder ser encontrado pelo ID
     */
    @Transactional
    public DocumentoTecnicoResponse cadastrarDocumento(DocumentoTecnicoRequest request)
    {
        ProdutoEntity produto = produtoRepository.findById(request.produto_id())
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o produto por ID: " +request.produto_id()));

        DocumentoTecnicoEntity documentoTecnico = documentoTecnicoMapper.toEntity(request, produto);
        documentoTecnicoRepository.save(documentoTecnico);

        return documentoTecnicoMapper.toResponse(documentoTecnico);
    }

    /**
     * Função de atualização de documentos a partir da requisição estabelecida buscado pelo ID
     * @param request Requisição contendo os dados necessários para atualização de documentoTecnico
     * @return DTO {@link DocumentoTecnicoResponse} com a entidade DocumentoTecnico persistida
     * @throws NotFoundException Se o documento técnico ou produto não puder ser encontrado pelo ID
     */
    @Transactional
    public DocumentoTecnicoResponse atualizaDocumento(Long id, DocumentoTecnicoRequest request)
    {
        documentoTecnicoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o documento por ID: " + id));
        ProdutoEntity produto = produtoRepository.findById(request.produto_id())
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o produto por ID: " +request.produto_id()));

        DocumentoTecnicoEntity documentoTecnico = documentoTecnicoMapper.toEntity(request, produto);
        documentoTecnicoRepository.save(documentoTecnico);

        return documentoTecnicoMapper.toResponse(documentoTecnico);
    }

    /**
     * Deleção de documentos técnicos a partir de ID
     * @param id parâmetro de busca
     */
    @Transactional
    public void deletarDocumento(Long id)
    {
        DocumentoTecnicoEntity documentoTecnico = documentoTecnicoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi possível encontrar o documento por ID: " + id));

        documentoTecnicoRepository.delete(documentoTecnico);
    }
}
