package net.gafah.microservicios.commons.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

	private String email;
	private String password;
	private String nombres;
	private String numeroDocumento;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Long idRol;
	private Long idEmpresa;
	private Long idUsuario;
}
