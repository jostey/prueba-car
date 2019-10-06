package com.curso.service.mapper;

import org.springframework.stereotype.Service;

import com.curso.dto.CarDto;
import com.curso.dto.UserDto;
import com.curso.model.CarEntity;

@Service
public class MapperCarEntityToDto implements MapperService<CarEntity, CarDto>{

	@Override
	public CarDto map(CarEntity i) {
		return new CarDto(i.getId(),i.getModel(),i.getBrand(), new UserDto(i.getUser().getId(),i.getUser().getName()));
	}
	
}
