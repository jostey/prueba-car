package com.curso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.model.CarEntity;
import com.curso.model.UserEntity;
import com.curso.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired private CarRepository carRepository;

	@Override
	public Optional<CarEntity> findById(UserEntity user, Integer id) {
		Optional<CarEntity> car = carRepository.findById(id);

		return (car.isPresent() && car.get().getUser().equals(user))
				? car
				: Optional.empty();
	}

	@Override
	public Page<CarEntity> findAll(UserEntity user, Pageable page) {
		return carRepository.findByUser(user, page);
	}

	@Override
	public CarEntity save(CarEntity car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
