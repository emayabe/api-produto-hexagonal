package com.api.produto.infrastructure.config;

import com.api.produto.domain.adapter.ProdutoServiceImpl;
import com.api.produto.domain.ports.interfaces.ProdutoServicePort;
import com.api.produto.domain.ports.repository.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoServiceImpl(produtoRepositoryPort);
    }
}
