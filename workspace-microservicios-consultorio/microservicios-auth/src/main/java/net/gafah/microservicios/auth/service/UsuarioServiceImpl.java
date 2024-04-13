package net.gafah.microservicios.auth.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.gafah.microservicios.auth.config.JwtService;
import net.gafah.microservicios.auth.repository.IRolRepository;
import net.gafah.microservicios.auth.repository.ITokenRepository;
import net.gafah.microservicios.auth.repository.IUsuarioRepository;
import net.gafah.microservicios.commons.microservicios.services.CommonServiceImpl;
import net.gafah.microservicios.commons.usuarios.dto.AuthenticationRequest;
import net.gafah.microservicios.commons.usuarios.dto.AuthenticationResponse;
import net.gafah.microservicios.commons.usuarios.dto.UsuarioRequest;
import net.gafah.microservicios.commons.usuarios.enums.TokenType;
import net.gafah.microservicios.commons.usuarios.model.Rol;
import net.gafah.microservicios.commons.usuarios.model.Token;
import net.gafah.microservicios.commons.usuarios.model.Usuario;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class UsuarioServiceImpl  extends CommonServiceImpl<Usuario, IUsuarioRepository> implements IUsuarioService {
	private final IUsuarioRepository iUsuarioRepository;
	private final ITokenRepository iTokenRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
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

	
	//////////////////para authenticar
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		var user = iUsuarioRepository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		revokeAllUserTokens(user);
		saveUserToken(user, jwtToken);
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}

	private void saveUserToken(Usuario user, String jwtToken) {
		Token token = Token.builder().usuario(user).token(jwtToken).tokenType(TokenType.BEARER).expired(false)
				.revoked(false).build();
		iTokenRepository.save(token);
	}

	private void revokeAllUserTokens(Usuario user) {
		var validUserTokens = iTokenRepository.findAllValidTokenByUser(user.getIdUsuario());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		iTokenRepository.saveAll(validUserTokens);
	}

	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extractUsername(refreshToken);
		if (userEmail != null) {
			var user = this.iUsuarioRepository.findByEmail(userEmail).orElseThrow();
			if (jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generateToken(user);
				revokeAllUserTokens(user);
				saveUserToken(user, accessToken);
				var authResponse = AuthenticationResponse.builder().accessToken(accessToken).refreshToken(refreshToken)
						.build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}
		}
	}
}
