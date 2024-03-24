package com.api.produto.domain.ports;

import com.api.produto.domain.dto.ProdutoDTO;

import java.util.UUID;

public class Produto {

    private UUID codigo;
    private String titulo;
    private Double preco;

    public Produto() {
    }

    public Produto(UUID codigo, String titulo, Double preco) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.preco = preco;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.titulo = produtoDTO.getTitulo();
        this.preco = produtoDTO.getPreco();
    }

    public void atualizarPreco(double preco) {
        this.preco = preco;
    }

    public ProdutoDTO toProdutoDTO() {
        return new ProdutoDTO(this.titulo, this.preco);
    }
}