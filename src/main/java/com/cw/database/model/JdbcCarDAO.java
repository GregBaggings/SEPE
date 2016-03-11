package com.cw.database.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcCarDAO implements CarDAO {
	private final Logger logger = LoggerFactory.getLogger(JdbcCarDAO.class);
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// public void insert(Car car){
	// String sql = "INSERT INTO LIST_OF_CARS " +
	// "(CAR_ID, NAME, AGE, PRICE) VALUES (?, ?, ?, ?)";


	public void saveNewCar(Car car) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO LIST_OF_CARS " + "(CAR_ID, NAME, AGE, PRICE) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, car.getCarId(), car.getName(), car.getAge(), car.getPrice());
	}

	public void updateCar(Car car) {
		// TODO Auto-generated method stub

	}

	public void deleteCar(int carId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "DELETE FROM LIST_OF_CARS WHERE CAR_ID= ?";
		
		Object[] params = new Object[] { carId };
		jdbcTemplate.update(sql,params);
		logger.info("SQL query was: "+sql);

	}

	public List<Car> findByName(String name) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "SELECT * from LIST_OF_CARS WHERE NAME LIKE %?%";
		 
		List<Car> cars = new ArrayList<Car>();
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { name });
		for (Map<String, Object> row : rows) {
			Car car = new Car();
			car.setCarId((Integer)(row.get("CAR_ID")));
			car.setName((String)row.get("NAME"));
			car.setAge((Integer)row.get("AGE"));
			car.setPrice((Integer)row.get("PRICE"));
			cars.add(car);
		}
		
		return cars;
	}
}
