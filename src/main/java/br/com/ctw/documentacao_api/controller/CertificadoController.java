package br.com.ctw.documentacao_api.controller;

import br.com.ctw.documentacao_api.dto.CertificadoResponse;
import br.com.ctw.documentacao_api.dto.ProdutoResponse;
import br.com.ctw.documentacao_api.service.CertificadoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/certificados")
@AllArgsConstructor
public class CertificadoController {

    private final CertificadoService service;
    @GetMapping
    public ResponseEntity<Page<CertificadoResponse>> listarTodos(@PageableDefault
    (size = 20, direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<CertificadoResponse> pages = service.listarTudo(pageable);
        return ResponseEntity.ok(pages);
    }
}
