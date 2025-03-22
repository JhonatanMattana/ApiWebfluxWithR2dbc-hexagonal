package com.webflux.webflux.application.usercase;

import com.webflux.webflux.domain.model.ProdutoModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProdutoUseCase {
    Mono<ProdutoModel> findById(Long id);
    Flux<ProdutoModel> findAll();
    Mono<ProdutoModel> save(ProdutoModel model);
    Mono<Void> deleteById(Long id);
    Mono<Void> deleteAll();
}