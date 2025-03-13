package com.webflux.webflux.infrastructure.persistence.repository;

import com.webflux.webflux.infrastructure.persistence.entity.ProdutoEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoR2Repository extends R2dbcRepository<ProdutoEntity, Long> {

}
