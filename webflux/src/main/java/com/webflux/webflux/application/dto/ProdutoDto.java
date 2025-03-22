package com.webflux.webflux.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private Long id;
    private String nome;
    private Integer quantidade;
}