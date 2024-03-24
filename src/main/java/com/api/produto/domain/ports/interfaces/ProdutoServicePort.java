package com.api.produto.domain.ports.interfaces;

import com.api.produto.domain.dto.ProdutoDTO;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

public interface ProdutoServicePort {

    void cadastrarProduto(ProdutoDTO produtoDTO);

    ProdutoDTO buscarProdutoCodigo(UUID codigo);

    List<ProdutoDTO> buscarProdutoTitulo(String titulo);

    void atualizarPreco(UUID codigo, Double novoPreco);
}
