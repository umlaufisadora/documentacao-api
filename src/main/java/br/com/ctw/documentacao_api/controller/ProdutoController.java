package br.com.ctw.documentacao_api.controller;

import br.com.ctw.documentacao_api.dto.ProdutoRequest;
import br.com.ctw.documentacao_api.dto.ProdutoResponse;
import br.com.ctw.documentacao_api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Controller REST responsável pelos endpoints relacionados ao recurso produto
 */
@Tag(
        name = "Produtos",
        description = "Operações relacionadas ao gerenciamento de produtos"
)

@RestController
@RequestMapping("api/v1/produtos")
@AllArgsConstructor
public class ProdutoController
{
    private final ProdutoService service;


    @Operation(
            summary = "Listar todos os produtos",
            description = "Listar todos os produtos listados no banco de dados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Requisição recebida com sucesso"
    )
    /**
     * Lista todos os produtos cadastrados
     * @param pageable página com parâmetros de retorno informados (ex: size=20)
     * @return Resposta de êxito com JSON informado
     */
    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listarTodos(@PageableDefault
    (size = 20, direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<ProdutoResponse> pages = service.listarTudo(pageable);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@Valid @RequestBody ProdutoRequest request)
    {
        ProdutoResponse produto = service.cadastrarProduto(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(produto.id())
                .toUri();

        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping("/id")
    public ResponseEntity<ProdutoResponse> atualizarProduto(
            @Parameter(
                    description = "Identificador único de produto",
                    example = "1"
            )@PathVariable Long id,
            @Valid @RequestBody ProdutoRequest request
    )
    {
        return ResponseEntity.ok(service.atualizarProdutos(id, request));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletarProduto(
            @Parameter(
                    description = "Identificador único de produto",
                    example = "1"
            )@PathVariable Long id
    )
    {
        return ResponseEntity.noContent().build();
    }
}
