package com.api.produto.infrastructure.adapter.entity;

import com.api.produto.domain.ports.Produto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codigo;

    private String titulo;
    private Double preco;

    public ProdutoEntity() {
    }

    public ProdutoEntity(Produto produto) {
        this.titulo = produto.getTitulo();
        this.preco = produto.getPreco();
    }

    public void atualizar(Produto produto) {
        this.titulo = produto.getTitulo();
        this.preco = produto.getPreco();
    }

    public Produto toProduto() {
        return new Produto(this.codigo, this.titulo, this.preco);
    }
}