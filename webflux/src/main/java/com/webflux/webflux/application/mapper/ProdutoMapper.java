package com.webflux.webflux.application.mapper;

import com.webflux.webflux.domain.builder.ProdutoEntityBuilder;
import com.webflux.webflux.domain.builder.ProdutoModelBuilder;
import com.webflux.webflux.domain.model.ProdutoModel;
import com.webflux.webflux.application.dto.ProdutoDto;
import com.webflux.webflux.infrastructure.persistence.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDto modelToDto(ProdutoModel model) {
        ProdutoDto dto = new ProdutoDto();

        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setQuantidade(model.getQuantidade());

        return dto;
    }

    public ProdutoEntity modelToEntity(ProdutoModel model) {
        return ProdutoEntityBuilder.builder()
                .setId(model.getId())
                .setNome(model.getNome())
                .setQuantidade(model.getQuantidade())
                .build();
    }

    public ProdutoModel dtoToModel(ProdutoDto dto) {
        return ProdutoModelBuilder.builder()
                .setId(dto.getId())
                .setNome(dto.getNome())
                .setQuantidade(dto.getQuantidade())
                .build();
    }

    public ProdutoModel entityToModel(ProdutoEntity entity) {
        return ProdutoModelBuilder.builder()
                .setId(entity.getId())
                .setNome(entity.getNome())
                .setQuantidade(entity.getQuantidade())
                .build();
    }
}