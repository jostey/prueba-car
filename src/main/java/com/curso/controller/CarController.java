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

import com.curso.dto.CarDto;
import com.curso.exception.NotFoundException;
import com.curso.model.CarEntity;
import com.curso.model.UserEntity;
import com.curso.service.CarServiceImpl;
import com.curso.service.UserServiceImpl;
import com.curso.service.mapper.MapperCarDtoToEntity;
import com.curso.service.mapper.MapperCarEntityToDto;

@RestController
@RequestMapping("/user/{userId}/car")
public class CarController {
	@Autowired private CarServiceImpl carService;
	@Autowired private UserServiceImpl userService;
	@Autowired private MapperCarEntityToDto mapperCarEntityToDto;
	@Autowired private MapperCarDtoToEntity mapperCarDtoToEntity;
	
	private static final String NOT_FOUND_ID_CAR = "No existe el coche con id: ";
	private static final String NOT_FOUND_ID_USER = "No existe el usuario con id: ";
	
	@GetMapping
	public Page<CarDto> findAll(@PathVariable("userId") Integer userId,
								@RequestParam(value="page", defaultValue="0", required=false) Integer page,
								@RequestParam(value="size", defaultValue="10",required=false) Integer size) throws NotFoundException{
		
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		return carService.findAll(user, PageRequest.of(page,size))
				.map(mapperCarEntityToDto::map);
	}
	
	@GetMapping("/{id}")
	public CarDto findOne(@PathVariable("userId") Integer userId,
						  @PathVariable("id") Integer id) throws NotFoundException {
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		
		return carService.findById(user, id)
				.map(mapperCarEntityToDto::map)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + id));
	}
	
	@PostMapping
	public CarDto create(@PathVariable("userId") Integer userId,
						 @RequestBody CarDto car) throws NotFoundException {
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		
		CarEntity carEntity = mapperCarDtoToEntity.map(car);
		
		user.getCars().add(carEntity);
		userService.save(user);
		
		carEntity.setUser(user);
		return mapperCarEntityToDto.map(carService.save(carEntity));
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("userId") Integer userId,
					   @PathVariable("id") Integer id,
					   @RequestBody CarDto car) throws NotFoundException {
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		
		CarEntity carEntity = carService.findById(user, id)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + id));
		
		carEntity.setBrand(car.getBrand());
		carEntity.setModel(car.getModel());
		
		user.getCars().remove(carEntity);
		user.getCars().add(carEntity);
		userService.save(user);

		carService.save(carEntity);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("userId") Integer userId,
			   		   @PathVariable("id") Integer id) throws NotFoundException{
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		
		CarEntity carEntity = carService.findById(user, id)
			.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + id));
		
		carService.removeById(id);
		user.getCars().remove(carEntity);
	}
	
	
	
}
