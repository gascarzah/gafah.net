package com.gafahtec.exceaune.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.exceaune.model.ApiResponse;
import com.gafahtec.exceaune.model.Articulo;
import com.gafahtec.exceaune.repository.ArticuloRepositoryDao;

@RestController
@RequestMapping("/tipoArticulos")
public class TipoArticuloController {

	@Autowired
	ArticuloRepositoryDao articuloRepositoryDao;
	
	
	    @GetMapping("/home/{id}")
	    public ApiResponse<List<Articulo>> getTipoArticulosInicio(@PathVariable int id){
	    	
	        return new ApiResponse<>(HttpStatus.OK.value(), "Tipo Articulo obtenido satisfactoriamente", articuloRepositoryDao.get3primerosArticulos(id));
	    }
	    
	
	    @GetMapping("/list/{id}")
	    public ApiResponse<List<Articulo>> getListadoArticulos(@PathVariable int id){
	    	
	        return new ApiResponse<>(HttpStatus.OK.value(), "Todos los obtenido satisfactoriamente",articuloRepositoryDao.getAllArticulos(id));
	    }
	    
}
