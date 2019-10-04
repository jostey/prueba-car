package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {

}
