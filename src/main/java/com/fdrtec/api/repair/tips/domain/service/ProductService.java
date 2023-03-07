package com.fdrtec.api.repair.tips.domain.service;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdrtec.api.repair.tips.domain.assembler.CrudAssembler;
import com.fdrtec.api.repair.tips.domain.model.dto.ProductDto;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;

@Service
public class ProductService extends CrudAssembler<ProductDto, Product> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Optional<Product> getById(UUID id) {
        return productRepository.findById(id);        
    }

    
    @Transactional
    @Override
    public ProductDto save(ProductDto productDto) {
        try {
            Product product = this.toEntity(productDto);
            return this.toDto(productRepository.save(product));            

        } catch (Exception e) {
        	LOGGER.error( "ProductService : ", e);        	
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
