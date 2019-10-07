package com.curso.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {
	public UserEntity() {}
	public UserEntity(Integer id, String name, List<CarEntity> cars, List<RentEntity> rents) {
		this.id = id;
		this.name = name;
		this.cars = cars;
		this.rents = rents;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "user")
	private List<CarEntity> cars;
	@OneToMany(mappedBy = "user")
	private List<RentEntity> rents;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CarEntity> getCars() {
		return cars;
	}
	public void setCars(List<CarEntity> cars) {
		this.cars = cars;
	}
	public List<RentEntity> getRents() {
		return rents;
	}
	public void setRents(List<RentEntity> rents) {
		this.rents = rents;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rents == null) ? 0 : rents.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof UserEntity)) return false;
		
		UserEntity other = (UserEntity) obj;
		
		if(getId() != null ? !getId().equals(other.getId()) : other.getId() != null)
			return false;
		if(getName() != null ? !getName().equals(other.getName()) : other.getName() != null)
			return false;
	     
       return true;
	}
	
}
