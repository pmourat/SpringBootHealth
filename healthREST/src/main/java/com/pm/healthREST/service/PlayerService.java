package com.pm.healthREST.service;

import java.security.Principal;
import java.util.Optional;

import com.pm.healthREST.entity.Patient;
import com.pm.healthREST.entity.Temperature;

public interface PlayerService {



	Temperature saveTemperature(Temperature theTemperature, String username, Principal principal) throws Exception;

	Patient updatePatient(Patient thePatient, int id, Principal principal) throws Exception;

	String getHealth(Patient thePatient, int id, Principal principal) throws Exception;

	Optional<Patient> getPatient(Patient thePatient, int id, Principal principal) throws Exception;
	
	

}
