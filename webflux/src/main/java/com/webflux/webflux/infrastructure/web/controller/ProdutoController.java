package com.webflux.webflux.infrastructure.web.controller;

import com.webflux.webflux.application.dto.ProdutoDto;
import com.webflux.webflux.infrastructure.web.handler.ProdutoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoHandler produtoHandler;

    @GetMapping(path = "/findById/{id}")
    public Mono<ProdutoDto> findByIdProduto(@PathVariable("id") Long id) {
        return produtoHandler.findById(id);
    }

    @GetMapping(path = "/findAll")
    public Flux<ProdutoDto> findAll() {
        return produtoHandler.findAll();
    }

    @PostMapping(path = "/save")
    public Mono<ProdutoDto> save(@RequestBody ProdutoDto dto) {
        return produtoHandler.save(dto);
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable("id") Long id) {
        return produtoHandler.deleteById(id).then(Mono.just(ResponseEntity.noContent().build()));
    }

    @DeleteMapping(path = "/deleteAll")
    public Mono<ResponseEntity<Void>> deleteAll() {
        return produtoHandler.deleteAll().then(Mono.just(ResponseEntity.noContent().build()));
    }
}
