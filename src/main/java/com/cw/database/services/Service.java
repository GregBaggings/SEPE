package com.cw.database.services;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cw.database.cars.Car;

@Entity(name = "list_of_services")
public class Service {
	@Id
	@GeneratedValue
	Integer serviceId;
	String name;
	Boolean onStock;
	int price;

	// this annotation is necessary for the table connect
	@OneToMany(mappedBy = "serviceId")
	List<Car> carList;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getOnStock() {
		return onStock;
	}

	public void setOnStock(Boolean onStock) {
		this.onStock = onStock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
