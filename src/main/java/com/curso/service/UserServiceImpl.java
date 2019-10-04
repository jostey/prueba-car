package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.model.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public Optional<UserEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserEntity> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity save(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
