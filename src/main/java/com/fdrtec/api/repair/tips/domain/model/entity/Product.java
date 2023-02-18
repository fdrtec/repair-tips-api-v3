package com.fdrtec.api.repair.tips.domain.model.entity;

import java.util.UUID;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(schema = "support")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;    
    String productName;
    String productNumber;
    
}
