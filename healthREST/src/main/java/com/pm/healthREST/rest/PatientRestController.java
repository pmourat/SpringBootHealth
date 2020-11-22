package com.pm.healthREST.rest;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.healthREST.dao.PatientDAO;
import com.pm.healthREST.entity.Patient;

@RestController
@RequestMapping("/api")
public class PatientRestController {
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private PatientDAO patientDAO;
	


	@Autowired
	public PatientRestController(PatientDAO thePatientDAO ) {
		
		patientDAO = thePatientDAO;
		
		
	}
	
	@GetMapping("/patients/{id}")
	public Optional<Patient> getPatient(@PathVariable int id, Principal principal, Patient thePatient ) throws Exception {
	
	Optional<Patient> patient = patientDAO.findById(id);
	 // Check if patient access his own data or not
	 String myPatientsName = patient.get().getUsername();
	 String x =principal.getName();
	 if (x.equals(myPatientsName)) {
		 return patient;

	 }
	
	else {
		 
 throw new Exception("Not current users data");
	 
	}
	 
	 }

		
		
	
	
	
	
	
	
	/*
	
	@PostMapping("/patients")
	public Patient registerPatient(@RequestBody Patient thePatient) {
		
		//set id to 0 for update execution (for hibernate saveorupdate)
		thePatient.setId(0);
		patientDAO.save(thePatient);
		System.out.println(thePatient);
		return thePatient;
	}
	
	
	Optional<Patient> patient = patientDAO.findById(id);
	 // Check if patient access his own data or not
	 String myPatientsName = patient.get().getUsername();
	 String x =principal.getName();
	 if (x.equals(myPatientsName)) {
		 return patient;

	 }
	
	else {
		 
 throw new Exception("Not current users data");
	 
	}
	
	*/
	
	@PutMapping("/patients/{id}")
	public Patient updatePatient(@RequestBody Patient thePatient, @PathVariable int id, Principal principal) throws Exception {
		Optional<Patient> patient = patientDAO.findById(id);
		 // Check if patient access his own data or not
		 String myPatientsName = patient.get().getUsername();
		 String x =principal.getName();
		 if (x.equals(myPatientsName)) {
		
		thePatient.setId(id);
		thePatient.setPassword(bcryptEncoder.encode(thePatient.getPassword()));

		patientDAO.save(thePatient);
		
		return thePatient;
	}

	
	else {
		 
 throw new Exception("Not current users data");
	 
	}
		 
	
	}	
}
