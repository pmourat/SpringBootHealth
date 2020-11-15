package com.pm.healthREST.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.healthREST.dao.PatientDAO;
import com.pm.healthREST.entity.Patient;

@RestController
@RequestMapping("/api")
public class PatientRestController {
	
	private PatientDAO patientDAO;
	
	//constructor injection
	@Autowired
	public PatientRestController(PatientDAO thePatientDAO) {
		
		patientDAO = thePatientDAO;
	}

	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable int id) {
	 Patient patient = patientDAO.getPatient(id);
	 
	 return patient;
		
	}
	
	@PostMapping("/patients")
	public Patient registerPatient(@RequestBody Patient thePatient) {
		
		//set id to 0 for update execution (for hibernate saveorupdate)
		thePatient.setId(0);
		patientDAO.save(thePatient);
		System.out.println(thePatient);
		return thePatient;
	}
	
	
	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientDAO.save(thePatient);
		
		return thePatient;
	}
	
	
}
