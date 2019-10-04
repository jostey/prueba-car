package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.model.RentEntity;

@Service
public class RentServiceImpl implements RentService{

	@Override
	public Optional<RentEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RentEntity> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RentEntity save(RentEntity rent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
