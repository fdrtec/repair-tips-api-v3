package com.fdrtec.api.repair.tips.domain.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Configuration
public class Converter<T,S> {   
    
    @Autowired
    private ModelMapper mapper;
    
//    @Bean
//    @SuppressWarnings("unchecked")
//    public S toModel(T dto) {        
//        return mapper.map(dto, (Class<S>)getClass());
//    }    
//
//    @Bean
//    @SuppressWarnings("unchecked")
//    public T toDTO(S model ) {
//        return mapper.map(model, (Class<T>) getClass());
//    }

//    @Bean
//    public List<T> toCollectionDTO(List<S> models) {
//        return models.stream()
//        .map(this::toDTO)
//        .collect(Collectors.toList());
//    }
    
}
