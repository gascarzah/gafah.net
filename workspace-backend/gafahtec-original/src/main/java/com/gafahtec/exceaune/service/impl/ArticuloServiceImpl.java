package com.gafahtec.exceaune.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gafahtec.exceaune.model.Articulo;
import com.gafahtec.exceaune.repository.ArticuloRepositoryDao;
import com.gafahtec.exceaune.service.ArticuloService;


public class ArticuloServiceImpl implements ArticuloService{

//	@Autowired
//	ArticuloRepositoryDao articuloRepositoryDao;
//	
//	@Override
//	public List<Articulo> getListTipoArticulo(Integer id, Integer tipoListado) {
//		
//		if(tipoListado == 0) {
//			return articuloRepositoryDao.getListTipoArticulo(id).subList(0, 2);	
//		}
//		return articuloRepositoryDao.getListTipoArticulo(id); 
//		
//		
//	}
//
//	public List<Articulo> getArticuloDet(Integer id){
//		
//		return articuloRepositoryDao.getArticuloDet(id);
//	}
}
