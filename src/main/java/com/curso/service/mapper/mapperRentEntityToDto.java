package com.curso.service.mapper;

import org.springframework.stereotype.Service;

import com.curso.dto.RentDto;
import com.curso.dto.UserDto;
import com.curso.model.RentEntity;
import com.curso.model.UserEntity;

@Service
public class mapperRentEntityToDto implements MapperService<RentEntity, RentDto>{

	@Override
	public RentDto map(RentEntity i) {
		//return new RentDto(i.getId(), i.getUser(), i.getCar(), Integer.valueOf(i.getInitDate().toEpochDay()), finalDate, price)
		UserDto user = new UserDto(i.getUser().getId(), i.getUser().getName());
		
//		new RentDto(id, user, car, initDate, finalDate, price)
//		return new RentDto(i.getId(), user, new CarDto(), );
		
		return null;
	}

}
