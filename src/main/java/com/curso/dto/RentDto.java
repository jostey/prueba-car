package com.curso.dto;

public class RentDto {
	public RentDto(Integer id, UserDto user, CarDto car, Long initDate, Long finalDate, Double price) {
		this.id = id;
		this.user = user;
		this.car = car;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.price = price;
	}
	private Integer id;
	private UserDto user;
	private CarDto car;
	private Long initDate;
	private Long finalDate;
	private Double price;
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public CarDto getCar() {
		return car;
	}
	public void setCar(CarDto car) {
		this.car = car;
	}
	public Long getInitDate() {
		return initDate;
	}
	public void setInitDate(Long initDate) {
		this.initDate = initDate;
	}
	public Long getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Long finalDate) {
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
