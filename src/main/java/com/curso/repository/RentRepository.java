package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.RentEntity;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Integer>{

}
