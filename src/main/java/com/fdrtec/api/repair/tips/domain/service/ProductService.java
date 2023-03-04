package com.fdrtec.api.repair.tips.domain.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdrtec.api.repair.tips.domain.model.dto.ProductDto;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;

@Service
public class ProductService {

    // @Autowired
    // private Converter<ProductDTO, Product> converter;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;
    
    public ProductDto getById(UUID id) {
        Product product = productRepository.findById(id).get();
        // .orElseThrow(() -> new NotFoundException("Product not found"));
        

        return modelMapper.map(product, ProductDto.class);
    }

    @Transactional
    public ProductDto save(ProductDto productDto) {
        try {
            // Product product = converter.toModel(productDTO);
            // return Product.toProductDTO(productRepository.save(product));

            Product product = modelMapper.map(productDto, Product.class);
            return modelMapper.map(productRepository.save(product), ProductDto.class);

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
