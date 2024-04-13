package net.gafah.microservicios.commons.request.response.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteResponse implements Serializable{
	
	
	private String nombres;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;

	private String tipoDocumento;
	
	private String numeroDocumento;

	private String direccion;

	private String telefono;
	private String celular;
	
	private String email;
	
}
