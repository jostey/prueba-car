package com.curso.service.mapper;

import org.springframework.stereotype.Service;

import com.curso.dto.UserDto;
import com.curso.model.UserEntity;

@Service
public class MapperUserDtoToEntity implements MapperService<UserDto, UserEntity>{

	@Override
	public UserEntity map(UserDto i) {
		return new UserEntity(i.getId(), i.getName(), null, null);
	}
	
}
