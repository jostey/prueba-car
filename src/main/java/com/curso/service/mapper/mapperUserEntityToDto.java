package com.curso.service.mapper;

import com.curso.dto.UserDto;
import com.curso.model.UserEntity;

public class mapperUserEntityToDto implements MapperService<UserEntity, UserDto>{

	@Override
	public UserDto map(UserEntity i) {
		return new UserDto(i.getId(),i.getName());
	}

}
