package net.gafah.microservicios.commons.request.response.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FichaMedicaResponse {

	private ClienteResponse clienteResponse;
	private AntecedenteMedicoResponse antecedenteMedicoResponse;
}
