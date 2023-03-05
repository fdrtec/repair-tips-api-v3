package com.fdrtec.api.repair.tips.domain.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class Product implements Serializable{
	
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;   
    
    private String productName;
    private String productNumber;

    // @Enumerated(EnumType.STRING)
    // private Enum exemploEnum;

    // @Embeddable
    // private Object objectEmbutido
    
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @CreationTimestamp
    private LocalDateTime createDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @UpdateTimestamp
    private LocalDateTime updateDate;
    
}
