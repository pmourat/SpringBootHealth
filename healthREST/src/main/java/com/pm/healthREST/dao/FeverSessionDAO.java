package com.pm.healthREST.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pm.healthREST.entity.FeverSession;

public interface FeverSessionDAO extends CrudRepository<FeverSession, Integer> {
	
	public FeverSession findByPatientId(int pid);
	
	
	@Query(value = "SELECT * FROM fever_session WHERE patient_id = :patientId ", nativeQuery = true)
    List<FeverSession> findLastInsertion(@Param("patientId") int patientId);



}
