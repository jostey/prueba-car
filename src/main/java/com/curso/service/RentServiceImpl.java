package com.curso.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.model.CarEntity;
import com.curso.model.RentEntity;
import com.curso.repository.RentRepository;

@Service
public class RentServiceImpl implements RentService{
	
	@Autowired private RentRepository rentRepository;

	@Override
	public Optional<RentEntity> findById(Integer id) {
		return rentRepository.findById(id);
	}

	@Override
	public Page<RentEntity> findAll(Pageable page) {
		return rentRepository.findAll(page);
	}

	@Override
	public RentEntity save(RentEntity rent) {
		return rentRepository.save(rent);
	}

	@Override
	public void removeById(Integer id) {
		rentRepository.deleteById(id);
	}

	@Override
	public List<RentEntity> findByCar(CarEntity car, LocalDate initDate, LocalDate finalDate) {
		return rentRepository.findByCarAndInitDateGreaterThanEqualAndFinalDateLessThanEqual(car, initDate, finalDate);
	}

	@Override
	public Page<RentEntity> findByUserId(Integer id, Pageable page) {
		return rentRepository.findByUserId(id, page);
	}

}
