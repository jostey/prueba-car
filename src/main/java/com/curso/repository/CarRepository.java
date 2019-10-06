package com.curso.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.CarEntity;
import com.curso.model.UserEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
	Page<CarEntity> findByUser(UserEntity user, Pageable page);
}
