package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.dto.CarDto;
import com.curso.service.CarServiceImpl;
import com.curso.service.mapper.MapperCarEntityToDto;

@RestController
@RequestMapping("/user/{userId}/car")
public class CarController {
	@Autowired private CarServiceImpl carService;
	@Autowired private MapperCarEntityToDto mapperCarEntityToDto;
	
	@GetMapping
	public Page<CarDto> findAll(@RequestParam(value="page", defaultValue="0", required=false) Integer page,
								@RequestParam(value="size", defaultValue="10",required=false) Integer size){
		
		Pageable pageable = PageRequest.of(page,size);
		
		return carService.findAll(pageable)
				.map(mapperCarEntityToDto::map);
	}
	
	
	
}
