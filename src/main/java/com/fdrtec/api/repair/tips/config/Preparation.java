package com.fdrtec.api.repair.tips.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fdrtec.api.repair.tips.domain.model.entity.Category;
import com.fdrtec.api.repair.tips.domain.model.entity.Product;
import com.fdrtec.api.repair.tips.domain.model.entity.Type;
import com.fdrtec.api.repair.tips.domain.repository.CategoryRepository;
import com.fdrtec.api.repair.tips.domain.repository.ProductRepository;
import com.fdrtec.api.repair.tips.domain.repository.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
@Profile(value = "dev")
public class Preparation implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	TypeRepository typeRepository;

	@Override
    public void run(String ...arg) throws Exception {
        System.out.println("Teste com classe de preparação");
        
//        Category category = new Category();
//        category.setName("Impressoras");
//        categoryRepository.save(category);
        
        Category category = Category.builder()
        		.name("impressoras")
        		.build();
        categoryRepository.save(category);
        
        Type type = Type.builder()
        		.name("Laser")
        		.build();
        typeRepository.save(type);        
        
        Product product = Product.builder()
        		.productName("LaserJet 5L")
        		.productNumber("C3941A")
        		.category(category)
        		.type(type)
        		.build();        
        productRepository.save(product);

        
//        Product product2 = new Product();
//        product2.setProductName("Laserjet 1100");
//        product2.setProductNumber("C4224A");
//        productRepository.save(product2);     
        
    }

}
