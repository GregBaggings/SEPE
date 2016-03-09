package com.cw.database.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomRowMapper implements RowMapper{
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Car car = new Car();
			car.setCarId(rs.getInt("CUST_ID"));
			car.setName(rs.getString("NAME"));
			car.setAge(rs.getInt("AGE"));
			car.setPrice(rs.getInt("PRICE"));
			
			return car;
		}
}
