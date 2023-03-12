package com.fdrtec.api.repair.tips.domain.model.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	UUID id;	
	String name;
}
 