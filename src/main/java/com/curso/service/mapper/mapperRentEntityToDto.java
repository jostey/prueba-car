package com.curso.service.mapper;

import org.springframework.stereotype.Service;

import com.curso.dto.RentDto;
import com.curso.model.RentEntity;

@Service
public class mapperRentEntityToDto implements MapperService<RentEntity, RentDto>{

	@Override
	public RentDto map(RentEntity i) {
		//return new RentDto(i.getId(), i.getUser(), i.getCar(), Integer.valueOf(i.getInitDate().toEpochDay()), finalDate, price)
		
		return null;
	}

}
