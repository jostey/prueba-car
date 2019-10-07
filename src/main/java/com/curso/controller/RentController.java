package com.curso.controller;

import java.util.List;

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

import com.curso.dto.RentDto;
import com.curso.dto.ResultRentDto;
import com.curso.exception.NotFoundException;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;
import com.curso.model.UserEntity;
import com.curso.service.CarServiceImpl;
import com.curso.service.RentServiceImpl;
import com.curso.service.UserServiceImpl;
import com.curso.service.mapper.MapperRentDtoToEntity;
import com.curso.service.mapper.MapperRentEntityToDto;

@RestController
@RequestMapping("/rent")
public class RentController {
	@Autowired private RentServiceImpl rentService;
	@Autowired private CarServiceImpl carService;
	@Autowired private UserServiceImpl userService;
	@Autowired private MapperRentEntityToDto mapperRentEntityToDto;
	@Autowired private MapperRentDtoToEntity mapperRentDtoToEntity;
	
	private static final String NOT_FOUND_ID_CAR = "No existe el coche con id: ";
	private static final String NOT_FOUND_ID_USER = "No existe el usuario con id: ";
	private static final String NOT_FOUND_ID_RENT = "No existe el alquiler con id: ";
	
	@GetMapping
	public Page<RentDto> findAll(@RequestParam(value="page", defaultValue="0", required=false) Integer page,
								 @RequestParam(value="size", defaultValue="10",required=false) Integer size,
								 @RequestParam(value="user", required=false) Integer userId) throws NotFoundException{
		
		return (userId != null)
				? rentService.findAll(PageRequest.of(page, size))
							.map(mapperRentEntityToDto::map)
				: rentService.findByUserId(userId, PageRequest.of(page, size))
							.map(mapperRentEntityToDto::map);
	}
	
	@GetMapping("/{id}")
	public RentDto findOne(@PathVariable("id") Integer id) throws NotFoundException {
		return rentService.findById(id)
			.map(mapperRentEntityToDto::map)
			.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_RENT + id));
	}
	
	@PostMapping
	public RentDto create(@RequestParam(value="user_id", required=true) Integer userId,
						  @RequestParam(value="car_id", required=true) Integer carId,
						  @RequestBody RentDto rent) throws NotFoundException {
		
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		
		CarEntity car = carService.findById(user, carId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + carId));
		
		RentEntity rentEntity = mapperRentDtoToEntity.map(rent);
		
		user.getRents().add(rentEntity);
		userService.save(user);
		car.getRents().add(rentEntity);
		carService.save(car);
		
		rentEntity.setCar(car);
		rentEntity.setUser(user);
		return mapperRentEntityToDto.map(rentService.save(rentEntity));
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id,
					   @RequestParam(value="user_id", required=true) Integer userId,
			  		   @RequestParam(value="car_id", required=true) Integer carId,
			  		   @RequestBody RentDto rent) throws NotFoundException {
		
		UserEntity user = userService.findById(userId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + userId));
		
		CarEntity car = carService.findById(user, carId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + carId));
		
		RentEntity rentEntity = rentService.findById(id)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_RENT + id));
		
		rentEntity.setCar(car);
		rentEntity.setUser(user);
		rentEntity.setPrice(rent.getPrice());
		rentEntity.setInitDate(mapperRentDtoToEntity.LongToLocalDate(rent.getInitDate()));
		rentEntity.setFinalDate(mapperRentDtoToEntity.LongToLocalDate(rent.getFinalDate()));
		
		user.getRents().remove(rentEntity);
		user.getRents().add(rentEntity);
		userService.save(user);
		
		car.getRents().remove(rentEntity);
		car.getRents().add(rentEntity);
		carService.save(car);
		
		rentService.save(rentEntity);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws NotFoundException {
		RentEntity rentEntity = rentService.findById(id)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_RENT + id));
		
		UserEntity user = userService.findById(rentEntity.getUser().getId())
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_USER + rentEntity.getUser().getId()));
		
		CarEntity car = carService.findById(user, rentEntity.getCar().getId())
			.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + rentEntity.getCar().getId()));
		
		user.getRents().remove(rentEntity);
		userService.save(user);
		car.getRents().remove(rentEntity);
		carService.save(car);
		
		rentService.removeById(id);
	}	
	
	@GetMapping("/profit")
	public ResultRentDto carProfit(@RequestParam(value="car_id", required=true) Integer carId,
								   @RequestParam(value="init", required=true) Long initDate,
								   @RequestParam(value="final", required=true) Long finalDate) throws NotFoundException{
		
		CarEntity car = carService.findById(carId)
				.orElseThrow(() -> new NotFoundException(NOT_FOUND_ID_CAR + carId));
		
		List<RentEntity> rents = rentService.findByCar(car, 
				mapperRentDtoToEntity.LongToLocalDate(initDate), 
				mapperRentDtoToEntity.LongToLocalDate(finalDate));
		
		Double profit = 0.0;
		for(RentEntity r : rents) {
			profit += r.getPrice();
		}
		
		return new ResultRentDto(car.getBrand()+" "+car.getModel(), 
								initDate,
								finalDate,
								profit);
	}
	
}
