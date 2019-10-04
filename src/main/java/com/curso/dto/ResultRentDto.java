package com.curso.dto;

public class ResultRentDto {
	public ResultRentDto(String title, Integer initDate, Integer finalDate, Double price) {
		this.title = title;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.price = price;
	}
	private String title;
	private Integer initDate;
	private Integer finalDate;
	private Double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
