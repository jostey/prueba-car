package com.curso.dto;

public class RentDto {
	public RentDto(UserDto user, CarDto car, Integer initDate, Integer finalDate, Double price) {
		this.user = user;
		this.car = car;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.price = price;
	}
	private UserDto user;
	private CarDto car;
	private Integer initDate;
	private Integer finalDate;
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
	public Integer getInitDate() {
		return initDate;
	}
	public void setInitDate(Integer initDate) {
		this.initDate = initDate;
	}
	public Integer getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Integer finalDate) {
		this.finalDate = finalDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
