package com.curso.service.mapper;


import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.curso.dto.RentDto;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;
import com.curso.model.UserEntity;

@Service
public class mapperRentDtoToEntity implements MapperService<RentDto, RentEntity>{

	@Override
	public RentEntity map(RentDto i) {
		
		UserEntity user = new UserEntity(i.getUser().getId(), i.getUser().getName());
				
		return new RentEntity(i.getId(), 
				user, 
				new CarEntity(i.getCar().getId(), i.getCar().getModel(), i.getCar().getBrand(), user), 
				LocalDate.ofEpochDay(i.getInitDate()), LocalDate.ofEpochDay(i.getFinalDate()), i.getPrice());
	}
	
}


