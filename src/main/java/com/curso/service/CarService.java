package com.curso.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.model.CarEntity;

public interface CarService {
	/**
	 * Busca coche por id
	 * @param id
	 * @return Devuelve un Optional<CarEntity>
	 */
	public Optional<CarEntity> findById(Integer id);
	
	/**
	 * Busca todos los coches de forma paginada
	 * @param page
	 * @return Devuelve un Page<CarEntity> de los coches. Puede ser vacío.
	 */
	public Page<CarEntity> findAll(Pageable page);
	
	/**
	 * Guarda un coche
	 * @param car
	 * @return Devuelve el coche 
	 */
	public CarEntity save(CarEntity car);
	
	/**
	 * Elimina un coche buscándolo por id
	 * @param id
	 */
	public void removeById(Integer id);
}
