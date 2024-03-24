package com.api.produto.domain.adapter;

import com.api.produto.domain.dto.ProdutoDTO;
import com.api.produto.domain.ports.Produto;
import com.api.produto.domain.ports.interfaces.ProdutoServicePort;
import com.api.produto.domain.ports.repository.ProdutoRepositoryPort;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProdutoServiceImpl implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public ProdutoServiceImpl(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void cadastrarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public ProdutoDTO buscarProdutoCodigo(UUID codigo) {
        Produto produto = this.produtoRepository.buscarPeloCodigo(codigo);
        return produto.toProdutoDTO();
    }

    @Override
    public List<ProdutoDTO> buscarProdutoTitulo(String titulo) {
        List<Produto> produtos = this.produtoRepository.buscarPeloTitulo(titulo);
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
    }

    @Override
    public void atualizarPreco(UUID codigo, Double novoPreco) {
        Produto produto = this.produtoRepository.buscarPeloCodigo(codigo);

        produto.atualizarPreco(produto.getPreco());

        this.produtoRepository.salvar(produto);
    }
}
