package com.gafahtec.consultorio.service.impl;

import com.gafahtec.consultorio.dto.request.UsuarioRequest;
import com.gafahtec.consultorio.model.Empleado;
import com.gafahtec.consultorio.model.Rol;
import com.gafahtec.consultorio.model.Usuario;
import com.gafahtec.consultorio.repository.IEmpleadoRepository;
import com.gafahtec.consultorio.repository.IGenericRepository;
import com.gafahtec.consultorio.repository.IRolRepository;
import com.gafahtec.consultorio.repository.IUsuarioRepository;
import com.gafahtec.consultorio.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@Service 
 
@Slf4j
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements UsuarioService, UserDetailsService {

	private IUsuarioRepository repo;
	private IEmpleadoRepository empleadoRepo;

	private IRolRepository rolRepo;
	
	private final PasswordEncoder passwordEncoder;
	
//	private AuthTokenRepository authTokenRepository;
	
	@Override
	protected IGenericRepository<Usuario, Integer> getRepo() {

		return repo;
	}

	
	@Transactional	
	@Override
	public Usuario registrarUsuarioEmpleado(UsuarioRequest  usuarioRequest) {

		var usuarioRegistrado = repo.findByEmail(usuarioRequest.getEmail());

		if (usuarioRegistrado == null) {



			var persona = Empleado.builder().nombres(usuarioRequest.getNombres())
										   .apellidoPaterno(usuarioRequest.getApellidoPaterno())
										   .apellidoMaterno(usuarioRequest.getApellidoMaterno())
						                   .numeroDocumento(usuarioRequest.getNumeroDocumento())
										   .build();

			var outputPersona = empleadoRepo.save(persona);

			log.info("id grabado " + outputPersona);

			Set<Rol> hashRoles = new HashSet<Rol>();
//			hashRoles.add(rolSearched);
			hashRoles.add(Rol.builder().idRol(usuarioRequest.getIdRol()).build());
			var usuario = Usuario.builder().email(usuarioRequest.getEmail())
										   .password(passwordEncoder.encode(usuarioRequest.getPassword()))
										   .empleado(outputPersona)
										   .roles(hashRoles).build();

			return repo.save(usuario);
		} else {
			return null;
		}
	}


//	public Rol registrarRol(Rol rol) {
//
//		return rolRepo.save(rol);
//	}
//
//	@Override
//	public void addRoleToUser(String correo, String rol) {
//
//		log.info("Agrega rol {} a usuario {}", rol, correo);
//		var list = repo.findByUsername(correo);
//		var objUsuario =list.get(0);
//		var objRol = rolRepo.findByNombre(rol);
//
//		objUsuario.getRoles().add(objRol);
//
//	}



	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repo.findByEmail(email);
		
		
		if(usuario == null) {
			log.error("Usuario no se encuentra en base de datos");
			throw new UsernameNotFoundException("Usuario no se encuentra en base de datos");
		}else {
			log.info("Usuario encontrado en  base de datos: {}", email);
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		
		usuario.getRoles().forEach(rol -> {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
			
		});
		
		return new User(usuario.getEmail(), usuario.getPassword(), authorities);
	}


	@Override
	public Usuario getUsuario(String email) {
		return repo.findByEmail(email);

	}


//	@Override
//	public void grabarToken(AuthToken token) {
//		AuthToken saved = authTokenRepository.save(token);
//		System.out.println("token grabado "+saved);
//		
//	}
	
	
}
