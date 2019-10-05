package com.curso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CarEntity {

	public CarEntity(Integer id, String model, String brand, UserEntity user, List<RentEntity> rents) {
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.user = user;
		this.rents = rents;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String model;
	private String brand;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
	private UserEntity user;
	@OneToMany(mappedBy = "car")
	private List<RentEntity> rents;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<RentEntity> getRents() {
		return rents;
	}
	public void setRents(List<RentEntity> rents) {
		this.rents = rents;
	}

	
}
