package net.gafah.microservicios.usuarios.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.commons.microservicios.services.CommonServiceImpl;
import net.gafah.microservicios.commons.usuarios.dto.UsuarioRequest;
import net.gafah.microservicios.commons.usuarios.enums.TokenType;
import net.gafah.microservicios.commons.usuarios.model.Rol;
import net.gafah.microservicios.commons.usuarios.model.Token;
import net.gafah.microservicios.commons.usuarios.model.Usuario;
import net.gafah.microservicios.usuarios.repository.IRolRepository;
import net.gafah.microservicios.usuarios.repository.ITokenRepository;
import net.gafah.microservicios.usuarios.repository.IUsuarioRepository;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class UsuarioServiceImpl  extends CommonServiceImpl<Usuario, IUsuarioRepository> implements IUsuarioService {
	private final IUsuarioRepository iUsuarioRepository;
	private final ITokenRepository iTokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	private final IRolRepository iRolRepository;
	

	public Usuario register(UsuarioRequest usuarioRequest) {
		Usuario user = Usuario.builder().build();
		  BeanUtils.copyProperties(usuarioRequest, user);
		  
		var usuarioRegistrado = iUsuarioRepository.findByEmail(user.getEmail());

		if (usuarioRegistrado.isEmpty()) {
			
			
	            
			Set<Rol> hashRoles = new HashSet<Rol>();
			 hashRoles.add(iRolRepository.findById(usuarioRequest.getIdRol()).get());

			 user.setPassword(passwordEncoder.encode(user.getPassword()));
			 user.setRoles(hashRoles);

			
			var savedUser = iUsuarioRepository.save(user);
			var jwtToken = jwtService.generateToken(user);

			var refreshToken = jwtService.generateRefreshToken(user);
			saveUserToken(savedUser, jwtToken);

			return savedUser;
		}
			log.info("Usuario ya se encuentra regostrado ");
			return null;

	}

	
	private void saveUserToken(Usuario user, String jwtToken) {
		Token token = Token.builder().usuario(user).token(jwtToken).tokenType(TokenType.BEARER).expired(false)
				.revoked(false).build();
		iTokenRepository.save(token);
	}
	
	
	public  Optional<Usuario> findByEmail(String email){
		
		return iUsuarioRepository.findByEmail(email);
	}



    
    
    public Usuario modificarUsuario(UsuarioRequest usuarioRequest) {
    	
    	Usuario user = Usuario.builder().build();
		  BeanUtils.copyProperties(usuarioRequest, user);

        Set<Rol> hashRoles = new HashSet<Rol>();
        hashRoles.add(iRolRepository.findById(usuarioRequest.getIdRol()).get());


        user.setRoles(hashRoles);
        var userUpdate = iUsuarioRepository.save(user);
        log.info("usuario grabado " + userUpdate);
        return userUpdate;

    }

	
	

	
	
}
