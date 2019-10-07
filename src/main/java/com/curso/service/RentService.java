package com.curso.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.dto.ResultRentDto;
import com.curso.exception.NotFoundException;
import com.curso.model.CarEntity;
import com.curso.model.RentEntity;

public interface RentService {
	/**
	 * Busca alquiler por id
	 * @param id
	 * @return Devuelve un Optional<RentEntity>
	 */
	public Optional<RentEntity> findById(Integer id);
	
	/**
	 * Busca alquiler por userId
	 * @param userId
	 * @param page
	 * @return Devuelve una Page<RentEntity>
	 */
	public Page<RentEntity> findByUserId(Integer id, Pageable page);
	
	/**
	 * Busca alquiler por coche entre fechas
	 * @param car
	 * @param initDate
	 * @param finalDate
	 * @return Devuelve una List<RentEntity>
	 */
	public List<RentEntity> findByCar(CarEntity car, LocalDate initDate, LocalDate finalDate);

	
	/**
	 * Busca todos los alquileres de forma paginada
	 * @param page
	 * @return Devuelve un Page<RentEntity> de los alquileres. Puede ser vacío.
	 */
	public Page<RentEntity> findAll(Pageable page);
	
	/**
	 * Guarda un alquiler
	 * @param rent
	 * @return Devuelve el alquiler 
	 */
	public RentEntity save(RentEntity rent);
	
	/**
	 * Elimina un alquiler buscándolo por id
	 * @param id
	 */
	public void removeById(Integer id);
	
	/**
	 * Calcula el beneficio por el alquiler de un coche que corresponda con las fechas
	 * @param carId
	 * @param initDate
	 * @param finalDate
	 * @return ResultRentDto
	 */
	public ResultRentDto profitByCarAndDate(Integer carId, Long initDate, Long finalDate) throws NotFoundException;
}
