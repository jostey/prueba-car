package com.curso.service.mapper;


import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.curso.dto.RentDto;
import com.curso.model.RentEntity;

@Service
public class MapperRentDtoToEntity implements MapperService<RentDto, RentEntity>{

	@Override
	public RentEntity map(RentDto i) {
		
		//UserEntity user = new UserEntity(i.getUser().getId(), i.getUser().getName(), new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
				
		return new RentEntity(i.getId(), 
				null, 
				null,
				LongToLocalDate(i.getInitDate()), LongToLocalDate(i.getFinalDate()), i.getPrice());
	}
	
	public LocalDate LongToLocalDate(long l) {
		return LocalDate.ofEpochDay(l);
	}
	
}


