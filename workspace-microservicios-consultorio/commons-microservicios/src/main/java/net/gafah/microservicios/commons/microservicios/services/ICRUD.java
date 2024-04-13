package net.gafah.microservicios.commons.microservicios.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICRUD<T, ID> {

	T registrar(T t) ;

	T modificar(T t) ;

	List<T> listar() ;

	T listarPorId(ID id) ;

	void eliminar(ID id) ;
	
	Page<T> listar(Pageable pageable) ;
}
