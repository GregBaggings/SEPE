package com.cw.database.cars;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarDAO{

	private CarRepository carRepo;

	@Autowired
	public CarDAO(CarRepository carRepo) {
		super();
		this.carRepo = carRepo;
	}

	public void saveNewCar(Car car) {
		carRepo.save(car);
	}

	public void updateCar(Car car) {
		carRepo.save(car);
	}

	public void deleteCar(int carId) {
		carRepo.delete(carId);
	}

	public List<Car> findByName(String name) {
		return carRepo.findAllByName(name);
	}
	
	public List<Car> findAll(){
	return carRepo.findAll();
	}
}
