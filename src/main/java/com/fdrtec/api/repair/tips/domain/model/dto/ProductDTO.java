package com.fdrtec.api.repair.tips.domain.model.dto;

import java.io.Serializable;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO implements Serializable {
    
    UUID id;    
    
    @NotBlank    
    String productName;    
    
    @NotBlank
    String productNumber;    
}

    //@NotNull
    // @NotBlank
    // @Email
    // @Pattern(regexp = "\\d{4,6}")