package com.curso.service.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.curso.dto.UserDto;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;
import com.curso.model.UserEntity;

@Service
public class MapperUserDtoToEntity implements MapperService<UserDto, UserEntity>{

	@Override
	public UserEntity map(UserDto i) {
		return new UserEntity(i.getId(), i.getName(), new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
	}
	
}
