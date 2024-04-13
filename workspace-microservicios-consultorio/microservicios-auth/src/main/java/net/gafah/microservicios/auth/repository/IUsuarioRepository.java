package net.gafah.microservicios.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.gafah.microservicios.commons.usuarios.model.Usuario;

public interface IUsuarioRepository  extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);

}
