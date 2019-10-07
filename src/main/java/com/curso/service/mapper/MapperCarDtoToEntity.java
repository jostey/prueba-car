package com.curso.service.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.curso.dto.CarDto;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;

@Service
public class MapperCarDtoToEntity implements MapperService<CarDto, CarEntity>{

	@Override
	public CarEntity map(CarDto i) {
		return new CarEntity(i.getId(), i.getModel(), i.getBrand(), 
				null
				, new ArrayList<RentEntity>());
	}

}
