package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
