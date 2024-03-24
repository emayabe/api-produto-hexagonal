package com.api.produto.application;

import com.api.produto.domain.dto.ProdutoDTO;
import com.api.produto.domain.ports.interfaces.ProdutoServicePort;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {

        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    void cadastrarProdutos(@RequestBody ProdutoDTO produtoDTO) {

        produtoServicePort.cadastrarProduto(produtoDTO);
    }

    @GetMapping(value = "/codigo={codigo}")
    ProdutoDTO getProdutoCodigo(@PathVariable UUID codigo) {

        return produtoServicePort.buscarProdutoCodigo(codigo);
    }

    @GetMapping(value = "/titulo={titulo}")
    List<ProdutoDTO> getProdutoTitulo(@PathVariable String titulo) {

        return produtoServicePort.buscarProdutoTitulo(titulo);
    }

    @PutMapping(value = "/{codigo}")
    void atualizarPreco(@PathVariable UUID codigo, @RequestParam double novoPreco) {
        produtoServicePort.atualizarPreco(codigo, novoPreco);
    }
}