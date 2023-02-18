package com.fdrtec.api.repair.tips.domain.model.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private UUID id;   
    
    @NotBlank
    @Size(max = 200)
    private String productName;
    
    @NotBlank
    private String productNumber;
    
}
