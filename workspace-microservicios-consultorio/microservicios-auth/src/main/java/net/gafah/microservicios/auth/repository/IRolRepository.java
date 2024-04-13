package net.gafah.microservicios.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gafah.microservicios.commons.usuarios.model.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long>{
	
	Rol findByNombre(String nombre);

}
