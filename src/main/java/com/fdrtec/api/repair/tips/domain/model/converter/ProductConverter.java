package com.fdrtec.api.repair.tips.domain.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fdrtec.api.repair.tips.domain.model.dto.ProductDTO;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;

@Component
public class ProductConverter {

    @Autowired
    private ModelMapper mapper;

    public Product toModel(ProductDTO productDTO ) {
        return mapper.map(productDTO, Product.class);
    }

    public ProductDTO toDTO(Product product ) {
        return mapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> toCollectionDTO(List<Product> products) {
        return products.stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
    }
    
}
