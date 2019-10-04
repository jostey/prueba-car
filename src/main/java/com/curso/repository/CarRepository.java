package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {

}
