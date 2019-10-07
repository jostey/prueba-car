package com.curso.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.model.CarEntity;
import com.curso.model.UserEntity;

public interface CarService {
	/**
	 * Busca coche por id
	 * @param id
	 * @return Devuelve un Optional<CarEntity>
	 */
	public Optional<CarEntity> findById(Integer id);
	
	
	/**
	 * Busca coche por id perteneciente a un usuario
	 * @param id
	 * @return Devuelve un Optional<CarEntity>
	 */
	public Optional<CarEntity> findById(UserEntity user, Integer id);
	
	/**
	 * Busca todos los coches pertenecientes a un usuario de forma paginada
	 * @param user
	 * @param page
	 * @return Devuelve un Page<CarEntity> de los coches. Puede ser vacío.
	 */
	public Page<CarEntity> findAll(UserEntity user, Pageable page);
	
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
