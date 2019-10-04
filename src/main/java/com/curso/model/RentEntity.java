package com.curso.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class RentEntity {
	public RentEntity(Integer id, UserEntity user, CarEntity car, LocalDate initDate, LocalDate finalDate, Double price) {
		this.id = id;
		this.user = user;
		this.car = car;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.price = price;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	private UserEntity user;
	@ManyToOne
	private CarEntity car;
	private LocalDate initDate;
	private LocalDate finalDate;
	@Column(precision = 2)
	private Double price;
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public CarEntity getCar() {
		return car;
	}
	public void setCar(CarEntity car) {
		this.car = car;
	}
	public LocalDate getInitDate() {
		return initDate;
	}
	public void setInitDate(LocalDate initDate) {
		this.initDate = initDate;
	}
	public LocalDate getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
