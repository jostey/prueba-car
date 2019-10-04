package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.model.UserEntity;

public interface UserService {
	/**
	 * Busca usuario por id
	 * @param id
	 * @return Devuelve un Optional<UserEntity>
	 */
	public Optional<UserEntity> findById(Integer id);
	
	/**
	 * Busca todos los usuarios de forma paginada
	 * @param page
	 * @return Devuelve un Page<UserEntity> de los usuarios. Puede ser vacío.
	 */
	public Page<UserEntity> findAll(Pageable page);
	
	/**
	 * Busca todos los usuarios
	 * @return Devuelve una lista de usuarios.
	 */
	public List<UserEntity> findAll();
	
	/**
	 * Guarda un usuario
	 * @param user
	 * @return Devuelve el usuario 
	 */
	public UserEntity save(UserEntity user);
	
	/**
	 * Elimina un usuario buscándolo por id
	 * @param id
	 */
	public void removeById(Integer id);
}
