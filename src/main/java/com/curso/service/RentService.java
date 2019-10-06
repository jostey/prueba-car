package com.curso.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.model.RentEntity;

public interface RentService {
	/**
	 * Busca alquiler por id
	 * @param id
	 * @return Devuelve un Optional<RentEntity>
	 */
	public Optional<RentEntity> findById(Integer id);
	
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
}
