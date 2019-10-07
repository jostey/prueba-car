package com.curso.service.mapper;


import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.curso.dto.RentDto;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;
import com.curso.model.UserEntity;

@Service
public class MapperRentDtoToEntity implements MapperService<RentDto, RentEntity>{

	@Override
	public RentEntity map(RentDto i) {
		
		UserEntity user = new UserEntity(i.getUser().getId(), i.getUser().getName(), null, null);
				
		return new RentEntity(i.getId(), 
				user, 
				new CarEntity(i.getCar().getId(), i.getCar().getModel(), i.getCar().getBrand(), user, null), 
				LongToLocalDate(i.getInitDate()), LongToLocalDate(i.getFinalDate()), i.getPrice());
	}
	
	public LocalDate LongToLocalDate(long l) {
		return LocalDate.ofEpochDay(l);
	}
	
}


