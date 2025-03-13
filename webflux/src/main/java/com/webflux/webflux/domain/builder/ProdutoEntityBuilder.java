package com.webflux.webflux.domain.builder;

import com.webflux.webflux.infrastructure.persistence.entity.ProdutoEntity;

public class ProdutoEntityBuilder {

    private ProdutoEntity produtoEntity;

    public ProdutoEntityBuilder() {
        this.produtoEntity = new ProdutoEntity();
    }

    public static ProdutoEntityBuilder builder() {
        return new ProdutoEntityBuilder();
    }

    public ProdutoEntityBuilder setId(Long id) {
        produtoEntity.setId(id);
        return this;
    }

    public ProdutoEntityBuilder setNome(String nome) {
        produtoEntity.setNome(nome);
        return this;
    }

    public ProdutoEntityBuilder setQuantidade(Integer quantidade) {
        produtoEntity.setQuantidade(quantidade);
        return this;
    }

    public ProdutoEntity build() {
        return produtoEntity;
    }
}