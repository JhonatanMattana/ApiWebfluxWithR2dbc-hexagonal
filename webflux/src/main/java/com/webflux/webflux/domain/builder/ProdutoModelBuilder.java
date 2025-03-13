package com.webflux.webflux.domain.builder;

import com.webflux.webflux.domain.model.ProdutoModel;

public class ProdutoModelBuilder {

    private ProdutoModel produtoModel;

    public ProdutoModelBuilder() {
        this.produtoModel = new ProdutoModel();
    }

    public static ProdutoModelBuilder builder() {
        return new ProdutoModelBuilder();
    }

    public ProdutoModelBuilder setId(Long id) {
        produtoModel.setId(id);
        return this;
    }

    public ProdutoModelBuilder setNome(String nome) {
        produtoModel.setNome(nome);
        return this;
    }

    public ProdutoModelBuilder setQuantidade(Integer quantidade) {
        produtoModel.setQuantidade(quantidade);
        return this;
    }

    public ProdutoModel build() {
        return this.produtoModel;
    }
}