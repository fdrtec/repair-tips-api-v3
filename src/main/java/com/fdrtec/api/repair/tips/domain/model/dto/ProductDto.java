package com.fdrtec.api.repair.tips.domain.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
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
    String productName;    
    
    @NotBlank
    String productNumber; 
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime createDate;
}

    //@NotNull
    // @NotBlank
    // @Email
    // @Pattern(regexp = "\\d{4,6}")