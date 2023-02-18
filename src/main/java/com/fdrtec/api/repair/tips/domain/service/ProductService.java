package com.fdrtec.api.repair.tips.domain.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired 
    private ProductRepository productRepository;

    public Optional<Product> getById(UUID id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);        
    }
    
}
