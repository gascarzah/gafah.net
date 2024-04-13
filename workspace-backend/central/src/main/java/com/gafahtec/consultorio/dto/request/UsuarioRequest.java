package com.gafahtec.consultorio.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequest {
	private String email;
	private String password;
	private String nombres;
	private String numeroDocumento;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer idRol;


}
