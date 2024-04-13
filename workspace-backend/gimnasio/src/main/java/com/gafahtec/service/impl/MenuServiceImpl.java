package com.gafahtec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gafahtec.model.Menu;
import com.gafahtec.repository.IGenericRepository;
import com.gafahtec.repository.IMenuRepository;
import com.gafahtec.service.IMenuService;

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
		/*List<Menu> menus = new ArrayList<>();
		repo.listarMenuPorUsuario(nombre).forEach(x -> {
			Menu m = new Menu();
			m.setIdMenu((Integer.parseInt(String.valueOf(x[0]))));
			m.setIcono(String.valueOf(x[1]));
			m.setNombre(String.valueOf(x[2]));
			m.setUrl(String.valueOf(x[3]));		
			
			menus.add(m);
		});
		return menus;*/
		return repo.listarMenuPorUsuario(nombre);
	}

}
