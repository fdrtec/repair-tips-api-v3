package com.fdrtec.api.repair.tips.domain.assembler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudAssembler<T,S> {	
	
	@Autowired
	ModelMapper mapper;
	
	public abstract Optional<S> getById(UUID id); 
	public abstract T save(T t);
	
	
	public S toEntity(T dto) {		
	    Type entityType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];		
		return mapper.map(dto, entityType);
	}
	
	public T toDto(S model) {
	    Type dtoType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		 return mapper.map(model, dtoType);
	}

   public List<T> toCollectionDTO(List<S> models) {
       return models.stream()
       .map((S model) -> this.toDto(model))
       .collect(Collectors.toList());
   }

}
