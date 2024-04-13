package com.gafahtec.exceaune.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.exceaune.model.ApiResponse;
import com.gafahtec.exceaune.model.Persona;
import com.gafahtec.exceaune.repository.PersonaRepositoryDao;


@RestController
@RequestMapping("/personas")
public class PersonaController {

	
	@Autowired
	PersonaRepositoryDao personaRepositoryDao;
	
		@GetMapping("/alumnos/{anio}/{seccion}")
		public ApiResponse<List<Persona>> getDecadas(
				@PathVariable int anio,
				@PathVariable String seccion){
			
	        return new ApiResponse<>(HttpStatus.OK.value(), "Alumnos obtenido satisfactoriamente", personaRepositoryDao.getAlumnos(anio, seccion));
	    }
		

}
