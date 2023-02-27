package com.fdrtec.api.repair.tips.domain.model.entity;

import java.util.UUID;

import com.fdrtec.api.repair.tips.domain.model.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;   
    
    private String productName;
    private String productNumber;

    // @Enumerated(EnumType.STRING)
    // private Enum exemploEnum;

    // @Embeddable
    // private Object objectEmbutido

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getProductName(),
            product.getProductNumber()
        );              
    }    
}
