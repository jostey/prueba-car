package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
