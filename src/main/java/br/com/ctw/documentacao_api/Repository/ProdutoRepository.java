package br.com.ctw.documentacao_api.Repository;

import br.com.ctw.documentacao_api.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
