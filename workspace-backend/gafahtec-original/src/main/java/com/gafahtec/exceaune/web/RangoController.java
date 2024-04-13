package com.gafahtec.exceaune.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.exceaune.model.ApiResponse;
import com.gafahtec.exceaune.model.Rango;
import com.gafahtec.exceaune.repository.RangoRepositoryDao;


@RestController
@RequestMapping("/rangos" )
public class RangoController {

	@Autowired
	RangoRepositoryDao rangoRepositoryDao;
	
	@GetMapping("/todo")
	public ApiResponse<List<Rango>> getRangos(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Rangos obtenido satisfactoriamente", rangoRepositoryDao.getRangos());
    }
}
