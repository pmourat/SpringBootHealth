package com.pm.healthREST.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pm.healthREST.entity.Patient;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Integer> {

	
	public Patient findByUsername(String usr);
	



}
