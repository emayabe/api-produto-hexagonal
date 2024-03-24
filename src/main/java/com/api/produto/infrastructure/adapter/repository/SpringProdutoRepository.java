package com.api.produto.infrastructure.adapter.repository;

import com.api.produto.infrastructure.adapter.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
    Optional<ProdutoEntity> findById(UUID codigo);

    List<ProdutoEntity> findByTitulo(String titulo);
}
