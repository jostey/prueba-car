package com.curso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.model.UserEntity;
import com.curso.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired private UserRepository userRepository;

	@Override
	public Optional<UserEntity> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public Page<UserEntity> findAll(Pageable page) {
		return userRepository.findAll(page);
	}

	@Override
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public void removeById(Integer id) {
		userRepository.deleteById(id);
	}

}
