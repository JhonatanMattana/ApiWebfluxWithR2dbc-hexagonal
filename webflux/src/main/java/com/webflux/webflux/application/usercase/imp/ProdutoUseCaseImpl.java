package com.webflux.webflux.application.usercase.imp;

import com.webflux.webflux.application.usercase.IProdutoUseCase;
import com.webflux.webflux.domain.model.ProdutoModel;
import com.webflux.webflux.domain.repository.IProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProdutoUseCaseImpl implements IProdutoUseCase {

    private final IProdutoRepository produtoRepository;

    @Override
    public Mono<ProdutoModel> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Flux<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Mono<ProdutoModel> save(ProdutoModel model) {
        return produtoRepository.save(model);
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