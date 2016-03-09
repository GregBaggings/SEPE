package com.cw.database.model;

import java.util.List;

public interface CarDAO {
	public List<Car> findByName(String Name);
	public void saveNewCar(Car car);
	public void updateCar(Car car);
	public void deleteCar(int carId);
}
