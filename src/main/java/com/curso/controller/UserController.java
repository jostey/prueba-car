package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.dto.UserDto;
import com.curso.exception.NotFoundException;
import com.curso.model.UserEntity;
import com.curso.service.UserServiceImpl;
import com.curso.service.mapper.MapperUserDtoToEntity;
import com.curso.service.mapper.MapperUserEntityToDto;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired private UserServiceImpl userService;
	@Autowired private MapperUserEntityToDto mapperUserEntityToDto;
	@Autowired private MapperUserDtoToEntity mapperUserDtoToEntity;
	
	private static final String NOT_FOUND_ID_USER = "No existe el usuario con id: ";
	
	@GetMapping
	public Page<UserDto> findAll(@PathVariable("userId") Integer userId,
			@RequestParam(value="page", defaultValue="0", required=false) Integer page,
			@RequestParam(value="size", defaultValue="10",required=false) Integer size) throws NotFoundException{
		
		return userService.findAll(PageRequest.of(page,size))
				.map(mapperUserEntityToDto::map);
	}
	
	@GetMapping("/{id}")
	public UserDto findByOne(@PathVariable("id") Integer id) throws NotFoundException {
		return userService.findById(id)
				.map(mapperUserEntityToDto::map)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + id));
	}
	
	@PostMapping
	public UserDto create(@RequestBody UserDto userDto) {
		return mapperUserEntityToDto.map(userService.save(mapperUserDtoToEntity.map(userDto)));
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id,
					   @RequestBody UserDto userDto) throws NotFoundException {
		UserEntity user = userService.findById(id)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + id));
		
		user.setName(userDto.getName());
		userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.removeById(id);
	}
}
