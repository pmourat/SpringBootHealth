package com.pm.healthREST.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.healthREST.dao.PatientDAO;
import com.pm.healthREST.entity.Patient;

@RestController
@RequestMapping("/api")
public class PatientRestController {
	
	private PatientDAO patientDAO;
	
	public PatientRestController(PatientDAO thePatientDAO) {
		
		patientDAO = thePatientDAO;
	}

	@GetMapping("/patient/{id}")
	public Patient getPatient(@PathVariable int id) {
	 Patient patient = patientDAO.getPatient(id);
	 
	 return patient;
		
	}
}
