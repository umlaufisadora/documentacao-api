package br.com.ctw.documentacao_api.Repository;

import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import br.com.ctw.documentacao_api.entity.DocumentoTecnicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DocumentoTecnicoRepository extends JpaRepository<DocumentoTecnicoEntity, Long> {
    Set<DocumentoTecnicoEntity> findAllByProdutoId(Long id);
}
