package com.curso.service.mapper;

import com.curso.dto.CarDto;
import com.curso.dto.UserDto;
import com.curso.model.CarEntity;

public class mapperCarEntityToDto implements MapperService<CarEntity, CarDto>{

	@Override
	public CarDto map(CarEntity i) {
		return new CarDto(i.getId(),i.getModel(),i.getBrand(), new UserDto(i.getUser().getId(),i.getUser().getName()));
	}
	
}
