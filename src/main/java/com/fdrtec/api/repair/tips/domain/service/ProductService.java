package com.fdrtec.api.repair.tips.domain.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdrtec.api.repair.tips.domain.model.converter.ProductConverter;
import com.fdrtec.api.repair.tips.domain.model.dto.ProductDTO;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductConverter converter;

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> getById(UUID id) {
        return productRepository.findById(id);
    }

    @Transactional
    public ProductDTO save(ProductDTO productDTO) {
        try {
            Product product = converter.toModel(productDTO); 
            return Product.toProductDTO(productRepository.save(product));

        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Transactional
    public void update(Product product){
        productRepository.save(product);
    }

}
