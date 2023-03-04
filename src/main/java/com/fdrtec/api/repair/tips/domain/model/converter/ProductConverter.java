package com.fdrtec.api.repair.tips.domain.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fdrtec.api.repair.tips.domain.model.dto.ProductDto;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;

@Component
public class ProductConverter {

    @Autowired
    private ModelMapper mapper;

    public Product toModel(ProductDto productDTO ) {
        return mapper.map(productDTO, Product.class);
    }

    public ProductDto toDTO(Product product ) {
        return mapper.map(product, ProductDto.class);
    }

    public List<ProductDto> toCollectionDTO(List<Product> products) {
        return products.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
    }
    
}
