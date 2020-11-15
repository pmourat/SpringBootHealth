package com.pm.healthREST.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pm.healthREST.entity.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	
	private EntityManager entityManager;
	
	
	//constructor injection
	@Autowired
	public PatientDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
		
	}
	
	
	
	@Override
	@Transactional
	public Patient getPatient(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Patient thePatient = currentSession.get(Patient.class, id);
		
	return thePatient;
	}
	
	@Override
	@Transactional
	public void save(Patient thePatient) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(thePatient);
	
	
	}
	
	
	

}
