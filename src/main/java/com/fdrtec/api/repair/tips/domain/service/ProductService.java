package com.fdrtec.api.repair.tips.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdrtec.api.repair.tips.domain.assembler.CrudAssembler;
import com.fdrtec.api.repair.tips.domain.model.dto.ProductDto;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;
import com.fdrtec.api.repair.tips.exception.BusinessRuleException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService extends CrudAssembler<ProductDto, Product> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	private final ProductRepository productRepository;
	
	public List<ProductDto> getAll(Example example) {
		List<Product> products = productRepository.findAll(example);
		return this.toCollectionDTO(products);
	}
	
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
			LOGGER.error("(ProductService.save catch) " + e.getClass() + ": " + e.getLocalizedMessage());
			throw new BusinessRuleException(e);
		}
	}
	
	@Transactional
	public void update(ProductDto productDto) {
		try {
			Product product = this.toEntity(productDto);
			productRepository.save(product);
		} catch (Exception e) {
			LOGGER.error("(ProductService.update catch) " + e.getClass() + ": " + e.getLocalizedMessage());
			throw new BusinessRuleException(e);
		}
	}

	@Transactional
	public void delete(Product product) {
		productRepository.delete(product);
	}

	
	

}
