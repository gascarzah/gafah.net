package net.gafah.microservicios.auth;

import java.util.Objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import net.gafah.microservicios.auth.repository.IRolRepository;
import net.gafah.microservicios.auth.service.IUsuarioService;
import net.gafah.microservicios.commons.usuarios.dto.UsuarioRequest;
import net.gafah.microservicios.commons.usuarios.model.Rol;

@SpringBootApplication
@EntityScan({"net.gafah.microservicios.commons.usuarios"})
public class MicroserviciosAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosAuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(IRolRepository iRolRepository,
			IUsuarioService service) {
		return args -> {


//			var rol1 = Rol.builder().idRol(1l).nombre("ADMIN").build();
////			iRolRepository.save(rol1);
//
//				var admin = UsuarioRequest.builder().nombres("GIOVANNI").numeroDocumento("41181764")
//						.email("ga@correo.com").idEmpresa(1l).idRol(1l)
//						.apellidoPaterno("ASCARZA").apellidoMaterno("HINOSTROZA")
//						.activo(true)
//						.telefono("980592934")
//						.tipoDocumento("1")
//						.password("123456")
////						.sexo("M")
//						.build();
//
//				var obj = service.register(admin);
//				if(!Objects.isNull(obj)) {
//					System.out
//					.println("Admin token: " + obj);
//				}
				
				

			
		};
	}
}
