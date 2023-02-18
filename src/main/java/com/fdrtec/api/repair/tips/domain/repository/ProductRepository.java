package com.fdrtec.api.repair.tips.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdrtec.api.repair.tips.domain.model.entity.Product;


public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}
