package com.webflux.webflux.infrastructure.web.handler;

import com.webflux.webflux.application.dto.ProdutoDto;
import com.webflux.webflux.application.mapper.ProdutoMapper;
import com.webflux.webflux.application.usercase.IProdutoUseCase;
import com.webflux.webflux.domain.model.ProdutoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProdutoHandler {

    private final IProdutoUseCase produtoUserCase;
    private final ProdutoMapper produtoMapper;

    public Mono<ProdutoDto> findById(Long id) {
        Mono<ProdutoModel> model = produtoUserCase.findById(id);
        return model.map(produtoMapper::modelToDto);
    }

    public Mono<ProdutoDto> save(ProdutoDto dto) {
        ProdutoModel model = produtoMapper.dtoToModel(dto);
        return produtoUserCase.save(model).map(produtoMapper::modelToDto);
    }

    public Flux<ProdutoDto> findAll() {
        return produtoUserCase.findAll().map(produtoMapper::modelToDto);
    }

    public Mono<Void> deleteById(Long id) {
        return produtoUserCase.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return produtoUserCase.deleteAll();
    }
}