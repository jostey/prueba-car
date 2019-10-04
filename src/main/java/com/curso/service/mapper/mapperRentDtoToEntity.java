package com.curso.service.mapper;


import com.curso.dto.RentDto;
import com.curso.model.RentEntity;

public class mapperRentDtoToEntity implements MapperService<RentDto, RentEntity>{

	@Override
	public RentEntity map(RentDto i) {
		
		//ZonedDateTime initDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(i.getInitDate()), ZoneId.of ("Europe/Madrid"));
		//ZonedDateTime finalDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(i.getFinalDate()), ZoneId.of ("Europe/Madrid"));
		
				
		return null;
	}
	
}


