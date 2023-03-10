package com.fdrtec.api.repair.tips.domain.model.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface Converter<T,S> {
	
	ModelMapper mapper = new ModelMapper();

//	@SuppressWarnings("unchecked")
//	default S toEntity(T dto) {
//		return mapper.map(dto, (Class<S>) getClass());
//	}



	default S toEntity(T dto, Class<S> entityType) {
		return mapper.map(dto, entityType);
	}
	
//	@SuppressWarnings("unchecked")
//	default T toDto(S model) {
//		 return mapper.map(model, (Class<T>) getClass());
//	}

	default T toDto(S entity, Class<T> dtoType) {
		return mapper.map(entity, dtoType);
	}

//   default List<T> toCollectionDTO(List<S> models) {
//       return models.stream()
//       .map((S model) -> this.toDto(model, Class<S>)
//       .collect(Collectors.toList());
//   }

}
