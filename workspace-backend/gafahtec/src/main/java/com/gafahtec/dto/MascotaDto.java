package com.gafahtec.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MascotaDto {

	private Integer idMascota;
	private String nombre;
	private String peso;
	private String sexo;
	private Integer idRaza;
	private Integer idCliente;
	
	
}
