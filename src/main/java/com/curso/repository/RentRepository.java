package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.RentEntity;

public interface RentRepository extends JpaRepository<RentEntity, Integer>{

}
