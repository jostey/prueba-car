package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.model.CarEntity;

@Service
public class CarServiceImpl implements CarService {

	@Override
	public Optional<CarEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CarEntity> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
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
