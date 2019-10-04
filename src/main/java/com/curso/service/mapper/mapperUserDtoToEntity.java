package com.curso.service.mapper;

import com.curso.dto.UserDto;
import com.curso.model.UserEntity;

public class mapperUserDtoToEntity implements MapperService<UserDto, UserEntity>{

	@Override
	public UserEntity map(UserDto i) {
		return new UserEntity(i.getId(), i.getName());
	}
	
}
