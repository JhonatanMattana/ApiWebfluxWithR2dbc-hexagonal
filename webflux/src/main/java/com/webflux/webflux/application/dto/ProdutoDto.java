package com.webflux.webflux.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProdutoDto {

    private Long id;
    private String nome;
    private Integer quantidade;

    public ProdutoDto() {
    }
}