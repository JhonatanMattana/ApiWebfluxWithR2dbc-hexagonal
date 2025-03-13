package com.webflux.webflux.infrastructure.persistence.repository.impl;

import com.webflux.webflux.application.mapper.ProdutoMapper;
import com.webflux.webflux.domain.model.ProdutoModel;
import com.webflux.webflux.domain.repository.IProdutoRepository;
import com.webflux.webflux.infrastructure.persistence.entity.ProdutoEntity;
import com.webflux.webflux.infrastructure.persistence.repository.IProdutoR2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements IProdutoRepository {

    private final IProdutoR2Repository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Override
    public Mono<ProdutoModel> findById(Long id) {
        return produtoRepository.findById(id).map(produtoMapper::entityToModel);
    }

    @Override
    public Flux<ProdutoModel> findAll() {
        return produtoRepository.findAll().map(produtoMapper::entityToModel);
    }

    @Override
    public Mono<ProdutoModel> save(ProdutoModel model) {
        ProdutoEntity entity = produtoMapper.modelToEntity(model);
        return produtoRepository.save(entity).map(produtoMapper::entityToModel);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return produtoRepository.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return produtoRepository.deleteAll();
    }
}