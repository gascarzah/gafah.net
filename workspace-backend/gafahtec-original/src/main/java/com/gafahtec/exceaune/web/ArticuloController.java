package com.gafahtec.exceaune.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gafahtec.exceaune.model.ApiResponse;
import com.gafahtec.exceaune.model.Articulo;
import com.gafahtec.exceaune.model.Foto;
import com.gafahtec.exceaune.repository.ArticuloRepositoryDao;
import com.gafahtec.exceaune.repository.FotoRepositoryDao;


@RestController
@RequestMapping("/articulos" )
public class ArticuloController {

	@Autowired
	ArticuloRepositoryDao articuloRepositoryDao;
	
	@Autowired
	FotoRepositoryDao fotoRepositoryDao;
//	    @GetMapping
//	    public ResponseEntity getArticulos() {
//	    	List<Articulo> l = articuloRepositoryDao.getList(2010);
//	        System.out.println(">> desde otro proyecto "+l.size());
//	        return null;
//	    }
	    
	
	    @GetMapping("/detalle/{id}")
	    public ApiResponse<Articulo> getArticuloDetalle(@PathVariable int id){
	    	Articulo articulo = articuloRepositoryDao.getArticuloDet(id).get(0);
//	    	System.out.println("articulo "+articulo);
	        return new ApiResponse<>(HttpStatus.OK.value(), "Acticulo obtenido satisfactoriamente", articulo);
	    }

	@CrossOrigin("*")    
	    @GetMapping("/fotos/{id}")
	    public ApiResponse<List<Foto>> getFotosArticulo(@PathVariable int id){
	    	
	        return new ApiResponse<>(HttpStatus.OK.value(), "Fotos de articulos obtenido satisfactoriamente", fotoRepositoryDao.getFotosArticulo(id));
	    }
	    
	    
}
