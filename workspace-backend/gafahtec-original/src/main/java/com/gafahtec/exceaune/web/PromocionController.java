package com.gafahtec.exceaune.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.exceaune.model.ApiResponse;
import com.gafahtec.exceaune.model.Decada;
import com.gafahtec.exceaune.repository.PromocionRepositoryDao;

@RestController
@RequestMapping("/promociones")
public class PromocionController {

	
	@Autowired
	PromocionRepositoryDao promocionRepositoryDao;
	
		@GetMapping("/decadas/{id}")
		public ApiResponse<List<Decada>> getDecadas(@PathVariable int id){
			
	        return new ApiResponse<>(HttpStatus.OK.value(), "Decadas obtenido satisfactoriamente", promocionRepositoryDao.getDecadas(id));
	    }
		
		@GetMapping("/anios/{pdecada}")
		public ApiResponse<List<Decada>> getAnios(@PathVariable int pdecada){
	        return new ApiResponse<>(HttpStatus.OK.value(), "Años obtenido satisfactoriamente", promocionRepositoryDao.getAnios(pdecada));
	    }
		
		@GetMapping("/secciones/{anio}")
		public ApiResponse<List<Decada>> getSecciones(@PathVariable int anio){
	        return new ApiResponse<>(HttpStatus.OK.value(), "Secciones obtenido satisfactoriamente", promocionRepositoryDao.getSecciones(anio));
	    }
}
