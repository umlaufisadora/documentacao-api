package br.com.ctw.documentacao_api.Repository;

import br.com.ctw.documentacao_api.entity.CertificadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CertificadoRepository extends JpaRepository<CertificadoEntity, Long> {

    Set<CertificadoEntity> findAllByProdutoId(Long id);
}
