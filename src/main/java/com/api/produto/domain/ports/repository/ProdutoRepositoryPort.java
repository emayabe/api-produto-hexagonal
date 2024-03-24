package com.api.produto.domain.ports.repository;

import com.api.produto.domain.ports.Produto;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryPort {
    void salvar(Produto produto);

    Produto buscarPeloCodigo(UUID codigo);

    List<Produto> buscarPeloTitulo(String titulo);
}