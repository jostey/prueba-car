package com.curso.dto;

public class ResultRentDto {
	public ResultRentDto(String title, Long initDate, Long finalDate, Double price) {
		this.title = title;
		this.initDate = initDate;
		this.finalDate = finalDate;
		this.price = price;
	}
	private String title;
	private Long initDate;
	private Long finalDate;
	private Double price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
}
