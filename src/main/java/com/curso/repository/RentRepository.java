package com.curso.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.model.CarEntity;
import com.curso.model.RentEntity;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Integer>{
	Page<RentEntity> findByUserId(Integer userId, Pageable page);
	List<RentEntity> findByCarAndInitDateGreaterThanEqualAndFinalDateLessThanEqual(CarEntity car, LocalDate initDate, LocalDate finalDate);
}
