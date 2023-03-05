package com.fdrtec.api.repair.tips.domain.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

	UUID id;    
    
    @NotBlank 
    @Size(max = 100)   
    String productName;    
    
    @NotBlank
    @Size(max = 100) 
    String productNumber; 
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime createDate;
}

    // @NotBlank
    // @NotNull
    // @NotEmpty
    // @Email
    // @Size(min = 5, max =100)
    // @Pattern(regexp = "\\d{4,6}")