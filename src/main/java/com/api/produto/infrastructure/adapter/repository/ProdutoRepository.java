package com.api.produto.infrastructure.adapter.repository;

import com.api.produto.domain.ports.Produto;
import com.api.produto.domain.ports.repository.ProdutoRepositoryPort;
import com.api.produto.infrastructure.adapter.entity.ProdutoEntity;
import com.api.produto.infrastructure.adapter.repository.SpringProdutoRepository;
import org.springframework.stereotype.Component;

import java.rmi.server.UID;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final SpringProdutoRepository springProdutoRepository;

    public ProdutoRepository(SpringProdutoRepository springProdutoRepository) {
        this.springProdutoRepository = springProdutoRepository;
    }

    @Override
    public void salvar(Produto produto) {
        ProdutoEntity produtoEntity;
        if (Objects.isNull(produto.getCodigo()))
            produtoEntity = new ProdutoEntity(produto);
        else {
            produtoEntity = this.springProdutoRepository.findById(produto.getCodigo()).get();
            produtoEntity.atualizar(produto);
        }

        this.springProdutoRepository.saveAndFlush(produtoEntity);
    }

    @Override
    public Produto buscarPeloCodigo(UUID codigo) {
        Optional<ProdutoEntity> produtoEntity = this.springProdutoRepository.findById(codigo);

        if (produtoEntity.isPresent())
            return produtoEntity.get().toProduto();

        throw new RuntimeException("Produto não existe");
    }

    @Override
    public List<Produto> buscarPeloTitulo(String titulo) {
        List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findByTitulo(titulo);
        return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
    }
}
