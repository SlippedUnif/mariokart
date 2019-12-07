package com.stefanini.hackaton.parsers;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser<DTO, ENTITY> {

	public abstract DTO toDTO(ENTITY entity);
	public abstract ENTITY toEntity(DTO dto);

	public List<DTO> toDTO(List<ENTITY> entities) {
		List<DTO> dtos = new ArrayList<>();

		for (ENTITY entity : entities) {
			dtos.add(toDTO(entity));
		}

		return dtos;
	}

	public List<ENTITY> toEntity(List<DTO> dtos) {
		List<ENTITY> entities = new ArrayList<>();

		for (DTO dto : dtos) {
			entities.add(toEntity(dto));
		}

		return entities;
	}

}
