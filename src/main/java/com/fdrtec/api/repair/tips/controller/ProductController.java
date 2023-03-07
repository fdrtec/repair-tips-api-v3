package com.fdrtec.api.repair.tips.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fdrtec.api.repair.tips.domain.model.dto.ProductDto;
import com.fdrtec.api.repair.tips.domain.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto getById(@PathVariable UUID id) {
		return productService.getById(id)
				.map(product -> productService.toDto(product))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDto save(@RequestBody @Valid ProductDto productDto) {
		return productService.save(productDto);
	}

//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable UUID id) throws ResponseStatusException {
//        productService.getById(id).
//                .map(product -> {
//                    productService.delete(product);
//                    return Void.TYPE;
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Cliente não encontrado"));
//    }
//
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable UUID id, @RequestBody Product product) {
//        productService.getById(id)
//                .map(p -> {
//                    product.setId(p.getId());
//                    productService.update(product);
//                    return product;
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Cliente não encontrado"));
//    }

}
