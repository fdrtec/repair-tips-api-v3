package com.fdrtec.api.repair.tips.config;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
@Profile(value = "dev")
public class Preparation implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;

    @Override
    public void run(String ...arg) throws Exception {
        System.out.println("Teste com classe de preparação");
        
        Product product = new Product();
        product.setProductName("LaserJet 5L");
        product.setProductNumber("C3941A");
        productRepository.save(product);
        
        Product product2 = new Product();
        product2.setProductName("Laserjet 1100");
        product2.setProductNumber("C4224A");
        productRepository.save(product2);     
        
    }     
    
}
