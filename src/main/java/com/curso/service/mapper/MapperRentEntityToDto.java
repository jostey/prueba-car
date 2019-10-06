package com.curso.service.mapper;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import com.curso.dto.CarDto;
import com.curso.dto.RentDto;
import com.curso.dto.UserDto;
import com.curso.model.RentEntity;

@Service
public class MapperRentEntityToDto implements MapperService<RentEntity, RentDto>{

	@Override
	public RentDto map(RentEntity i) {
		UserDto user = new UserDto(i.getUser().getId(), i.getUser().getName());		

		return new RentDto(i.getId(), user,
				new CarDto(i.getCar().getId(), i.getCar().getModel(), i.getCar().getBrand(), user), 
				LocalDateToLong(i.getInitDate()), LocalDateToLong(i.getFinalDate()), i.getPrice());
	}
	
	private Long LocalDateToLong(LocalDate ld) {
		ZoneId zoneId = ZoneId.systemDefault();
		return ld.atStartOfDay(zoneId).toEpochSecond();
	}

}
