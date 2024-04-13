package com.gafahtec.consultorio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gafahtec.consultorio.model.Menu;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IMenuRepository;
import com.gafahtec.consultorio.service.IMenuService;

@Service
public class MenuServiceImpl extends CRUDImpl<Menu, Integer> implements IMenuService{

	@Autowired
	private IMenuRepository repo;

	@Override
	protected IGenericRepository<Menu, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		return repo.listarMenuPorUsuario(nombre);
	}

}
