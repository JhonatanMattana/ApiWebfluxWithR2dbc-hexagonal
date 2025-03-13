package com.webflux.webflux.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = { "id" })
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    private Long id;
    private  String nome;
    private Integer quantidade;

}
