package com.pm.healthREST.dao;

import org.springframework.data.repository.CrudRepository;

import com.pm.healthREST.entity.Temperature;

public interface TemperatureDAO extends CrudRepository<Temperature, Integer> {
	
	public Temperature findByPatientId(int pid);


}
