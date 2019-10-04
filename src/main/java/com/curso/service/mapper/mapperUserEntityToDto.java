package com.curso.service.mapper;

import org.springframework.stereotype.Service;

import com.curso.dto.UserDto;
import com.curso.model.UserEntity;

@Service
public class mapperUserEntityToDto implements MapperService<UserEntity, UserDto>{

	@Override
	public UserDto map(UserEntity i) {
		return new UserDto(i.getId(),i.getName());
	}

}
