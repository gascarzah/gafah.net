package com.gafahtec.consultorio.service;

import java.util.List;

import com.gafahtec.consultorio.model.Menu;

public interface IMenuService extends ICRUD<Menu, Integer>{
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
