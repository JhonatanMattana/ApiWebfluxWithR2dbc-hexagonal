package com.webflux.webflux.infrastructure.web.controller;

import com.webflux.webflux.application.dto.ProdutoDto;
import com.webflux.webflux.infrastructure.web.handler.ProdutoHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ProdutoControllerTest {

    @Mock
    private ProdutoHandler produtoHandler;

    @InjectMocks
    private ProdutoController produtoController;

    public ProdutoDto produtoDto;

    @BeforeEach
    void setUp() {
        produtoDto = new ProdutoDto(1L, "Produto Teste", 10);
    }

    @Test
    void findByIdProduto_DeveRetornarProduto() {
        when(produtoHandler.findById(1L)).thenReturn(Mono.just(produtoDto));

        Mono<ProdutoDto> result = produtoController.findByIdProduto(1L);

        assertEquals(produtoDto, result.block());
        verify(produtoHandler, times(1)).findById(1l);
    }

    @Test
    void findAll_DeveRetornarListaProdutos() {
        when(produtoHandler.findAll()).thenReturn(Flux.fromIterable(List.of(produtoDto)));

        Flux<ProdutoDto> result = produtoController.findAll();

        assertEquals(1, result.collectList().block().size());
        verify(produtoHandler, times(1)).findAll();
    }

    @Test
    void save_DeveSalvarProduto() {
        when(produtoHandler.save(produtoDto)).thenReturn(Mono.just(produtoDto));

        Mono<ProdutoDto> result = produtoController.save(produtoDto);

        assertEquals(produtoDto, result.block());
        verify(produtoHandler, times(1)).save(produtoDto);
    }

    @Test
    void deleteById_DeveDeletarProduto() {
        when(produtoHandler.deleteById(1L)).thenReturn(Mono.empty());

        Mono<ResponseEntity<Void>> result = produtoController.deleteById(1L);

        assertEquals(ResponseEntity.noContent().build(), result.block());
        verify(produtoHandler, times(1)).deleteById(1L);
    }

    @Test
    void deleteAll_DeveDeletarTodosProdutos() {
        when(produtoHandler.deleteAll()).thenReturn(Mono.empty());

        Mono<ResponseEntity<Void>> result = produtoController.deleteAll();

        assertEquals(ResponseEntity.noContent().build(), result.block());
        verify(produtoHandler, times(1)).deleteAll();
    }
}