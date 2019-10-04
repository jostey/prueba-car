package com.curso.service.mapper;

import com.curso.dto.CarDto;
import com.curso.model.CarEntity;
import com.curso.model.UserEntity;

public class mapperCarDtoToEntity implements MapperService<CarDto, CarEntity>{

	@Override
	public CarEntity map(CarDto i) {
		return new CarEntity(i.getId(), i.getModel(), i.getBrand(), new UserEntity(i.getUser().getId(), i.getUser().getName()));
	}

}
