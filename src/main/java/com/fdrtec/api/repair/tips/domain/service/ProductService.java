package com.fdrtec.api.repair.tips.domain.service;

import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdrtec.api.repair.tips.domain.model.converter.Converter;
import com.fdrtec.api.repair.tips.domain.model.dto.ProductDto;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
public class ProductService implements Converter<ProductDto, Product> {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Optional<Product> getById(UUID id) {
        return productRepository.findById(id);        
    }

    @Transactional
    public ProductDto save(ProductDto productDto) {
        try {
            Product product = this.toEntity(productDto, Product.class);
            return this.toDto(productRepository.save(product), ProductDto.class);            

        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Transactional
    public void update(Product product) {
        productRepository.save(product);
    }

}
