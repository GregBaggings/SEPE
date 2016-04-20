package com.cw.database.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceDAO {

	private ServiceRepository serviceRepo;

	@Autowired
	public ServiceDAO(ServiceRepository serviceRepo) {
		super();
		this.serviceRepo = serviceRepo;
	}

	public void saveNewService(Service service) {
		serviceRepo.save(service);
	}

	public void updateService(Service service) {
		serviceRepo.save(service);
	}

	public void deleteService(int serviceId) {
		serviceRepo.delete(serviceId);
	}

	public List<Service> findByName(String name) {
		return serviceRepo.findAllByName(name);
	}

	public List<Service> findAll() {
		return serviceRepo.findAll();
	}
}
