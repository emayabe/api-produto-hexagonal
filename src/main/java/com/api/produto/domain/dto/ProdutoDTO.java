package com.api.produto.domain.dto;

import java.rmi.server.UID;

public class ProdutoDTO {
    private UID codigo;
    private String titulo;
    private Double preco;

    public ProdutoDTO(String titulo, Double preco) {
        this.codigo = new UID();
        this.titulo = titulo;
        this.preco = preco;
    }

    public UID getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPreco() {
        return preco;
    }
}
