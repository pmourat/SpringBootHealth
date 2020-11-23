package com.pm.healthREST.service;

import java.security.Principal;

import com.pm.healthREST.entity.Temperature;

public interface PlayerService {



	Temperature saveTemperature(Temperature theTemperature, String username, Principal principal) throws Exception;
	
	

}
