package com.cw.database.cars;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer>{

	List<Car> findAllByName(String name);
	List<Car> findAll();

}
