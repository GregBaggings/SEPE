package com.cw.database.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, Integer>{

	List<Service> findAllByName(String name);
	List<Service> findAll();

}
